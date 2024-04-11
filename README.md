The problem set revolves around automating a conveyor belt system used for sorting items, with a specific focus on cross-belt sorting. 
Here's a short description of the problem set and its features:

**Problem Description**:  
The goal is to design and implement a system that efficiently sorts items using a cross-belt conveyor system. 
The system should be capable of handling various tasks such as placing items onto the belt, removing items from the belt, 
performing quality assurance checks, generating reports, and optimizing the sorting process.

Features:

Belt System Management:

1. Place items onto the conveyor belt.
2. Remove items from the conveyor belt.
3. Monitor and manage the status of the conveyor belt.

Cross-Belt Sorting:

1. Start and stop the cross-belt sorter.
2. Calibrate and optimize the sorter for efficient operation.
3. Perform quality assurance checks on sorted items.

Reporting:

1. Generate reports based on sorted items or system status.
2. Store and manage report data.

Presented are five different software architectures to solve the problem:
* layered
* modular
* event-driven
* service-based
* microservices

# Architecture diagrams

![sequence_diagram.png](assets%2Fsequence_diagram.png)

Layered  
![layered.png](assets%2Flayered.png)

Modular  
![modular.png](assets%2Fmodular.png)

Event-driven
![event-driven.png](assets%2Fevent-driven.png)

Service-based  
![service-based.png](assets%2Fservice-based.png)

Microservices  
![microservices.png](assets%2Fmicroservices.png)


# Build

Layered, modular and event-driven solutions are simply Spring Boot applications that can be build and run as per usual.

## Service-based

A little difference for the service-based solution is that it contains two modules but they are both Spring Boot apps, so 
there should be also no problem to run it.

## Microservices

Here because each microservice has its own database, I demonstrate it using docker build, which is a little more complicated.
```bash
cd microservices

cd belt-microservices
mvn package

cd ../crossbelt-microservices
mvn package

cd ../report-microservices
mvn package 

cd ..
docker compose up
```
