package com.team1.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class Team1SpringbootAppApplicationTests {

    @Test
    void contextLoads() {
        // This test will pass if the Spring context loads successfully
        // which means the database connection configuration is correct
    }

}
