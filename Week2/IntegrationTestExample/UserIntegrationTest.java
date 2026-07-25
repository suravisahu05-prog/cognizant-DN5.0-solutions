import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetUser_fullFlowFromControllerToDatabase() {
        User user = new User();
        user.setId(1L);
        user.setName("Suravi Sahu");
        userRepository.save(user);

        String url = "http://localhost:" + port + "/users/1";
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Suravi Sahu", response.getBody().getName());
    }
}
