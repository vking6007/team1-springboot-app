# Base image with JDK 21
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the packaged JAR from Maven target folder
COPY target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8081

# Run Spring Boot with UTC timezone
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "app.jar"]
