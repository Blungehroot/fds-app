# Set a variable that can be used in all stages.
ARG BUILD_HOME=/fds-app

# Gradle image for the build stage.
FROM arm64v8/gradle:7.4.2-jdk-focal AS build-image

# Set the working directory.
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

# Copy the Gradle source code into the build container.
COPY --chown=gradle:gradle build.gradle settings.gradle $APP_HOME/
COPY --chown=gradle:gradle src $APP_HOME/src


# Build the application.
RUN gradle --no-daemon build

# Java image for the application to run in.
FROM arm64v8/openjdk:17

# Copy the jar file in and name it app.jar.
ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
COPY --from=build-image $APP_HOME/build/libs/fds-app-0.0.1-SNAPSHOT.jar fds-app.jar

EXPOSE 80

# The command to run when the container starts.
ENTRYPOINT java -jar fds-app.jar