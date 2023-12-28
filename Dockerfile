FROM maven:3.9.6-eclipse-temurin-21-jammy

ARG MONGO_DATABASE
ARG MONGO_USER
ARG MONGO_PASSWORD
ARG MONGO_CLUSTER

WORKDIR /app

COPY ./movies/pom.xml .
COPY ./movies/src ./src

RUN mvn clean package

RUN mv /app/target/*.jar /app/target/app.jar


ENTRYPOINT ["java","-jar", "/app/target/app.jar"]