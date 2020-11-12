package za.co.iqbusiness.onlineregistrationserver;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.iqbusiness.onlineregistrationserver.domain.User;
import za.co.iqbusiness.onlineregistrationserver.repository.UserRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OnlineRegistrationServerApplication.class)
@ActiveProfiles(profiles = "test")
class OnlineRegistrationServerApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUser() throws Exception {
        User customer = new User();
        customer.setIdNumber("100");
        customer.setName("John");
        customer.setTelephoneNumber("07");
        userRepository.save(customer);

        List<User> all = userRepository.findAll();
        assertTrue(all.stream().anyMatch(user -> user.getIdNumber().equalsIgnoreCase("100")));
    }

    @Test
    public void findAll() throws Exception {
        User customer = new User();
        customer.setIdNumber("100");
        customer.setName("John");
        customer.setTelephoneNumber("07");
        userRepository.save(customer);

        List<User> all = userRepository.findAll();
        assertFalse(all.isEmpty());
    }
}
