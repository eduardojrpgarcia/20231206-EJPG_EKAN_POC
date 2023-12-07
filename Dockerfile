FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} unt-webapp.jar
ENTRYPOINT ["java", "-jar", "/unt-webapp.jar"]
