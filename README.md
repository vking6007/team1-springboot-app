# Team 1 Spring Boot Application

A simple Spring Boot application for testing PostgreSQL database connections with different profiles (dev and prod).

## Project Structure

```
src/
├── main/
│   ├── java/com/team1/app/
│   │   ├── Team1SpringbootAppApplication.java
│   │   ├── controller/
│   │   │   └── UserController.java
│   │   ├── entity/
│   │   │   └── User.java
│   │   └── repository/
│   │       └── UserRepository.java
│   └── resources/
│       ├── application.properties
│       ├── application-dev.properties
│       └── application-prod.properties
└── test/
    └── java/com/team1/app/
        ├── Team1SpringbootAppApplicationTests.java
        └── controller/
            └── UserControllerTest.java
```

## Configuration

The application supports two profiles:

### Development Profile (dev)
- Database: `team_1_dev_1_postgres:5432/team_1_db`
- Username: `team_1_user`
- Password: `team_1_pass`
- Hibernate DDL: `update` (creates/updates tables automatically)
- SQL logging: enabled

### Production Profile (prod)
- Database: `team_1_prod_postgres:5432/team_1_prod_db`
- Username: `team_1_prod_user`
- Password: `team_1_prod_pass`
- Hibernate DDL: `validate` (validates existing schema)
- SQL logging: disabled

## How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL database running on the configured hosts

### Running the Application

1. **Default (Development Profile):**
   ```bash
   mvn spring-boot:run
   ```

2. **With Specific Profile:**
   ```bash
   # Development profile
   mvn spring-boot:run -Dspring-boot.run.profiles=dev
   
   # Production profile
   mvn spring-boot:run -Dspring-boot.run.profiles=prod
   ```

3. **Build and Run JAR:**
   ```bash
   mvn clean package
   java -jar target/team1-springboot-app-0.0.1-SNAPSHOT.jar
   ```

## Testing Database Connection

### REST API Endpoints

The application provides several endpoints to test the database connection:

1. **Health Check:**
   ```
   GET http://localhost:8080/api/users/health
   ```

2. **Test Database Connection:**
   ```
   GET http://localhost:8080/api/users/test-connection
   ```

3. **Get All Users:**
   ```
   GET http://localhost:8080/api/users
   ```

4. **Create a User:**
   ```
   POST http://localhost:8080/api/users
   Content-Type: application/json
   
   {
     "username": "testuser",
     "email": "test@example.com"
   }
   ```

5. **Get User by ID:**
   ```
   GET http://localhost:8080/api/users/{id}
   ```

### Running Tests

```bash
# Run all tests
mvn test

# Run tests with specific profile
mvn test -Dspring.profiles.active=dev
```

## Database Setup

Make sure your PostgreSQL database is running and accessible with the configured connection details. The application will:

- **Dev profile**: Automatically create/update the `users` table
- **Prod profile**: Validate that the `users` table exists with the correct schema

## Troubleshooting

1. **Connection Refused:** Check if PostgreSQL is running and accessible on the configured host/port
2. **Authentication Failed:** Verify username and password in the profile-specific properties files
3. **Database Not Found:** Ensure the database exists on your PostgreSQL server
4. **Schema Validation Failed (Prod):** Make sure the `users` table exists with the correct schema

## Logs

- **Dev profile**: Detailed SQL logging is enabled
- **Prod profile**: Minimal logging for production use

Check the console output for connection status and any error messages.
