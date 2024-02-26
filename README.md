
<h2 align="center">REST API</h2>
<h3 align="center">Airplane Control Traffic</h3>

### Languages and Tools:
![Java](https://img.shields.io/badge/Java-11-%23ED8B00.svg?style=java&logo=java&logoColor=white)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.22-blue.svg)](https://projectlombok.org/)
![Hibernate](https://img.shields.io/badge/Hibernate-FFD700?style=flat&logo=Hibernate&logoColor=808080)
![Spring](https://img.shields.io/badge/Spring-9ACD32?style=flat&logo=Spring&logoColor=F8F8FF)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.5.3-green.svg)](https://spring.io/projects/spring-data-jpa)
[![Spring WEB](https://img.shields.io/badge/Spring%20WEB-2.5.3-green.svg)](https://spring.io/projects/spring-framework)
![Git](https://img.shields.io/badge/Git-F8F8FF?style=flat&logo=Git&logoColor=FF0000)
![Maven](https://img.shields.io/badge/Maven-F8F8FF?style=flat&logo=apachemaven&logoColor=F4A460)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=apache&logo=apache-tomcat&logoColor=black)
![Html](https://img.shields.io/badge/HTML-F8F8FF?style=flat&logo=html5&logoColor=black)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=badge&logo=postman&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=badge&logo=intellij-idea&logoColor=white)

## Description:
A simple application to simulate the flight of an aircraft.

We have such entities as:
Airplane, which has the following properties: identifier, name, airplane characteristics,  flight.

Way point, which has the following properties: identifier, point name, latitude of the point, longitude of the point, altitude of the point, flight speed.

A temporary point that has the following properties: identifier, point latitude, point longitude, point altitude, flight speed, flight direction (course).

A flight that has the following properties: identifier, flight name, list of flight points, list of temporary flight points.

Airplane characteristics, which has the following properties: identifier, maximum speed, acceleration, rate of change of altitude, rate of change of course.

To store these entities, we use the MongoDB database.

The user, through the web service (controller), creates the Way Point entity and enters the values of all properties except the identifier, which is assigned by the database.

The user, through the web service (controller), creates the Airplane characteristics entity and enters the values of all properties except the identifier assigned by the database.

The user, through the web service (controller), creates the Flight entity and enters such properties as Flight name, the value of the identifier assigned by the database, the value for the list of flight points is selected by the user from the Way points stored in the database.

The user creates the Aircraft entity using a web service (controller) and enters such properties as the name, the identifier value is assigned by the database, the value for the flight is selected by the user from those stored in the database.

To start the flight simulation, you need to select the appropriate controller and enter the aircraft identifier that was saved in the database as a parameter.
With each refresh of the page, all current flight parameters will be recalculated, added and saved in the database and displayed on the page.

* WayPointController, WayPointRestController
* AirplanecharacteristicsController, AirplanecharacteristicsRestController 
* FlightController, FlightRestController
* AirplaneController, AirplaneRestController

### Project structure.
* Repository - Data Access Layer
* DTO - Data Transfer Object
* Service - Application logic layer
* RestControllers, Controllers - Presentation layer



### Quick Start:
1. Clone the [repository](https://github.com/sergeiburya/food-sparks)
2. Install NOSQL MongoDB
3. Create schema airs_control
4. Set the necessary database connection settings in the file [application.properties](src/main/resources/application.properties)
5. Start application.
