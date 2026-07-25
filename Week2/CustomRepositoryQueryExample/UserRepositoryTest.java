import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName_returnsMatchingUsers() {
        // Arrange - save some real users into the in-memory test database
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Suravi Sahu");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Suravi Sahu"); // same name, different id
        userRepository.save(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("Rahul Verma");
        userRepository.save(user3);

        // Act - use the custom derived query method
        List<User> result = userRepository.findByName("Suravi Sahu");

        // Assert - should find exactly the 2 users with matching name
        assertEquals(2, result.size());
    }
}
