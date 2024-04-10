FROM openjdk:21-ea-32-oraclelinux7

LABEL name="sort architectures microservices belt"
LABEL version="1.0.0"

COPY target/belt-microservices-0.0.1-SNAPSHOT.jar /app/belt-microservices-0.0.1-SNAPSHOT.jar

WORKDIR /app

ENTRYPOINT java -jar ./belt-microservices-0.0.1-SNAPSHOT.jar