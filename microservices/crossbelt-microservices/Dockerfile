FROM openjdk:21-ea-32-oraclelinux7

LABEL name="sort architectures microservices crossbelt"
LABEL version="1.0.0"

COPY target/crossbelt-microservices-0.0.1-SNAPSHOT.jar /app/crossbelt-microservices-0.0.1-SNAPSHOT.jar

WORKDIR /app

ENTRYPOINT java -jar ./crossbelt-microservices-0.0.1-SNAPSHOT.jar