package by.itacademy.database.entity;

import by.itacademy.database.BaseTest;
import by.itacademy.database.entity.enums.Rights;
import by.itacademy.database.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;

public class UserTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkSaveUser() {
        User user = User.builder()
                .login("login")
                .password("pass")
                .name("Ryhor")
                .surname("Paprauka")
                .rights(Rights.FULL)
                .contacts(Contacts.of("dskfjsd", "dfds", "+375(25)906-47-10"))
                .build();

        userRepository.save(user);
        assertNotNull(userRepository.findById(user.getId()).orElse(null));
    }

    @Test
    public void checkGetUser() {
        User user = userRepository.findById(99L).orElse(null);
        assertNotNull(user);
        assertThat(user.getBookings(), hasSize(3));
        assertThat(user.getComment(), hasSize(2));
        assertNotNull(user.getBlacklist());
    }
}