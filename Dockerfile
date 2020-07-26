FROM openjdk:8-jdk-alpine
MAINTAINER Sunil Rai <sunilrai7607@gmail.com>
VOLUME /app
ARG version
ENV version_number=$version
COPY ./build/libs/profile-service-$version_number.jar profile-service.jar
ENTRYPOINT ["java", "-jar","/profile-service.jar"]