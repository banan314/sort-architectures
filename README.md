Problem: automate the cross belt management

The repository presents five different software architectures:
* layered
* modular
* event-driven
* service-based
* microservices

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
