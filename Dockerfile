# Base image with JDK 21
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the packaged JAR from Maven target folder
COPY target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Run Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
