FROM openjdk:21-ea-32-oraclelinux7

LABEL name="sort architectures microservices report"
LABEL version="1.0.0"

COPY target/report-microservices-0.0.1-SNAPSHOT.jar /app/report-microservices-0.0.1-SNAPSHOT.jar

WORKDIR /app

ENTRYPOINT java -jar ./report-microservices-0.0.1-SNAPSHOT.jar