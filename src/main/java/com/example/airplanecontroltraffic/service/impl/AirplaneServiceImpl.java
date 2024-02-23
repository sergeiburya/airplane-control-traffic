package com.example.airplanecontroltraffic.service.impl;

import com.example.airplanecontroltraffic.model.Airplane;
import com.example.airplanecontroltraffic.model.AirplaneCharacteristics;
import com.example.airplanecontroltraffic.model.Flight;
import com.example.airplanecontroltraffic.model.TemporaryPoint;
import com.example.airplanecontroltraffic.model.WayPoint;
import com.example.airplanecontroltraffic.repository.AirplaneRepository;
import com.example.airplanecontroltraffic.service.AirplaneCharacteristicsService;
import com.example.airplanecontroltraffic.service.AirplaneService;
import com.example.airplanecontroltraffic.service.FlightService;
import com.example.airplanecontroltraffic.service.TemporaryPointService;
import com.example.airplanecontroltraffic.service.WayPointService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private static Geodesic GEODESIC = Geodesic.WGS84;
    private final AirplaneRepository airplaneRepository;
    private final AirplaneCharacteristicsService characteristicsService;
    private final FlightService flightService;
    private final WayPointService wayPointService;
    private final TemporaryPointService temporaryPointService;

    @Autowired
    public AirplaneServiceImpl(AirplaneRepository airplaneRepository,
                               AirplaneCharacteristicsService characteristicsService,
                               FlightService flightService, WayPointService wayPointService,
                               TemporaryPointService temporaryPointService) {
        this.airplaneRepository = airplaneRepository;
        this.characteristicsService = characteristicsService;
        this.flightService = flightService;
        this.wayPointService = wayPointService;
        this.temporaryPointService = temporaryPointService;
    }

    @Override
    public Airplane save(Airplane airplane) {
        AirplaneCharacteristics characteristics = airplane.getCharacteristics();
        if (characteristics != null && characteristics.getId() != null) {
            characteristics = characteristicsService.findById(characteristics.getId());
        } else {
            characteristicsService.save(characteristics);
        }
        airplane.setCharacteristics(characteristics);

        if (airplane.getFlight() != null) {
            if (airplane.getFlight().getId() != null) {
                airplane.setFlight(flightService.findById(airplane.getFlight().getId()));
            } else {
                airplane.setFlight(flightService.save(airplane.getFlight()));
            }
        }

        TemporaryPoint position = generateStartAirplanePosition();
        airplane.setPosition(temporaryPointService.save(position));
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane findById(String id) {
        return airplaneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find Airplane by id" + id));
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        airplaneRepository.deleteById(id);
    }

    @Override
    public Airplane updateAirplanePositionInFly(String id) {
        Airplane airplane = findById(id);
        TemporaryPoint position = temporaryPointService.findById(airplane.getPosition().getId());
        Flight flight = flightService.findById(airplane.getFlight().getId());
        LocalDateTime startTime =
                position.getTimeInPoint() != null ? position.getTimeInPoint() : LocalDateTime.now();

        airplane.setFlight(flightService.updatePassedPoints(position, flight));

        double time = (double) ChronoUnit.SECONDS.between(startTime, LocalDateTime.now()) / 3600;
        double[] coordinate = calculateNewCoordinates(position, time);
        double latitude = coordinate[0];
        double longitude = coordinate[1];
        WayPoint wayPoint = wayPointService.determineTargetWayPoint(position, flight);
        position.setLatitude(latitude);
        position.setLongitude(longitude);
        position.setCourse(updateAirplaneCourse(airplane, wayPoint, time));
        position.setFlightHeight(updateAirplaneAltitude(airplane, position, wayPoint, time));
        position.setFlightSpeed(updateAirplaneSpeed(airplane, position, wayPoint, time));
        position.setTimeInPoint(LocalDateTime.now());
        position.setDistanceToTargetPoint(calculatingDistanceToTargetPoint(position, wayPoint));
        airplane.setPosition(temporaryPointService.save(position));

        return airplaneRepository.save(airplane);
    }

    private double calculatingDistanceToTargetPoint(TemporaryPoint position, WayPoint wayPoint) {
        GeodesicData geod = GEODESIC.WGS84.Inverse(
                position.getLatitude(),
                position.getLongitude(),
                wayPoint.getLatitude(),
                wayPoint.getLongitude());

        return geod.s12 / 1000.0;
    }

    private double updateAirplaneSpeed(
            Airplane airplane,
            TemporaryPoint position,
            WayPoint wayPoint, double time) {

        double airplaneSpeed = position.getFlightSpeed();
        if (airplaneSpeed < wayPoint.getFlightSpeed()) {
            airplaneSpeed =
                    airplaneSpeed + airplane.getCharacteristics().getAcceleration() * time;
            if (airplaneSpeed > airplane.getCharacteristics().getMaxSpeed()) {
                return airplane.getCharacteristics().getMaxSpeed();
            }
            return Math.min(airplaneSpeed, wayPoint.getFlightSpeed());

        } else if (airplaneSpeed > wayPoint.getFlightSpeed()) {
            airplaneSpeed = airplaneSpeed - airplane.getCharacteristics().getAcceleration() * time;
            return Math.max(airplaneSpeed, wayPoint.getFlightSpeed());
        }
        return airplaneSpeed;
    }

    private double updateAirplaneAltitude(
            Airplane airplane,
            TemporaryPoint position,
            WayPoint wayPoint,
            double time) {

        double airplaneAltitude = position.getFlightHeight();
        if (airplaneAltitude < wayPoint.getFlightHeight()) {
            airplaneAltitude = airplaneAltitude
                    + airplane.getCharacteristics().getSpeedOfChangeAltitude() * time;
            return Math.min(airplaneAltitude, wayPoint.getFlightHeight());
        } else if (airplaneAltitude > wayPoint.getFlightHeight()) {
            airplaneAltitude = airplaneAltitude
                    - airplane.getCharacteristics().getSpeedOfChangeAltitude() * time;
            return Math.max(airplaneAltitude, wayPoint.getFlightHeight());
        } else {
            return airplaneAltitude;
        }
    }

    private double updateAirplaneCourse(Airplane airplane, WayPoint wayPoint, double time) {
        GeodesicData result =
                GEODESIC.Inverse(
                        airplane.getPosition().getLatitude(),
                        airplane.getPosition().getLongitude(),
                        wayPoint.getLatitude(),
                        wayPoint.getLongitude());

        double course = result.azi1;
        course = course < 0 ? course + 360 : course;
        double sign = Math.signum(course - airplane.getPosition().getCourse());
        double intermediateCourse =
                airplane.getPosition().getCourse()
                        + sign * airplane.getCharacteristics().getSpeedOfChangeCourse() * time;
        intermediateCourse = (intermediateCourse + 360) % 360;
        return intermediateCourse;
    }

    public static double[] calculateNewCoordinates(TemporaryPoint position, double time) {
        double distance = position.getFlightSpeed() * time;

        GeodesicData result =
                GEODESIC.Direct(
                        position.getLatitude(),
                        position.getLongitude(),
                        position.getCourse(),
                        distance);
        double newLat = result.lat2;
        double newLon = result.lon2;

        return new double[]{newLat, newLon};
    }

    private TemporaryPoint generateStartAirplanePosition() {
        Random random = new Random();
        TemporaryPoint startPosition = new TemporaryPoint();
        startPosition.setLatitude(-90 + (90 - (-90)) * random.nextDouble());
        startPosition.setLongitude(- 180 + (180 - (-180)) * random.nextDouble());
        startPosition.setCourse(360 * random.nextDouble());
        startPosition.setFlightHeight(0);
        startPosition.setFlightSpeed(0);
        return startPosition;
    }
}
