#Use alpine image
FROM openjdk:8-jre-alpine3.9

#copy the package jar in docker image
COPY build/libs/fds-app-0.0.1-SNAPSHOT.jar /fds-app.jar

#Set the startup to execute the fds-app.jar
CMD ["java", "-jar", "fds-app.jar"]