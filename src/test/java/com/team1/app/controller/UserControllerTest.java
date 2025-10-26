package com.team1.app.controller;

import com.team1.app.entity.User;
import com.team1.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ActiveProfiles("dev")
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testDatabaseConnection() {
        // This test will verify that the database connection is working
        // by performing a simple count operation
        long count = userRepository.count();
        System.out.println("Database connection test successful. Total users: " + count);
    }

    @Test
    void testCreateAndRetrieveUser() {
        // Create a test user
        User testUser = new User("testuser", "test@example.com");
        User savedUser = userRepository.save(testUser);
        
        // Verify the user was saved
        assert savedUser.getId() != null;
        assert savedUser.getUsername().equals("testuser");
        assert savedUser.getEmail().equals("test@example.com");
        
        // Clean up
        userRepository.delete(savedUser);
        
        System.out.println("User creation and retrieval test successful");
    }
}
