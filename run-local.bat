@echo off
echo ========================================
echo 🚀 Starting Team1 Spring Boot App (LOCAL)
echo ========================================
echo.
echo 📊 Profile: local
echo 🌐 Server: http://localhost:8081
echo 🗄️  Database: 168.220.248.40:5432/team_1_db
echo.

REM Set timezone for JVM
set JAVA_OPTS=-Duser.timezone=UTC

REM Run with local profile
mvn spring-boot:run -Dspring-boot.run.profiles=local

pause
