@echo off
echo Building Spring Boot application...
mvn clean package -DskipTests

echo Building Docker image...
docker build -t team1-springboot-app .

echo Docker image built successfully!
echo.
echo To run the application:
echo   docker run -p 8080:8080 team1-springboot-app
echo.
echo Or use docker-compose:
echo   docker-compose up
