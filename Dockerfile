FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD /build/libs/plants-0.0.1-SNAPSHOT.jar plants.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/plants.jar"]
