@echo off
set JAVA_OPTS=-Duser.timezone=UTC -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager
mvn spring-boot:run -Dspring-boot.run.profiles=prod
