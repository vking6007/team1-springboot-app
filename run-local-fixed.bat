@echo off
echo Starting Spring Boot application with UTC timezone...
set JAVA_OPTS=-Duser.timezone=UTC
call mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Duser.timezone=UTC"
