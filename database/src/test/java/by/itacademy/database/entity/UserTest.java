package by.itacademy.database.entity;

import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static by.itacademy.database.util.SessionManager.getSession;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveUser() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        User user = entityCreator.createUser("логин");
        Serializable id = session.save(user);
        assertNotNull(id);
    }

    @Test
    public void checkGetUser() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        User user = entityCreator.createUser("логин");
        Serializable id = session.save(user);
        assertNotNull(id);

        fillUser(session, user);
        session.getTransaction().commit();
        session.clear();

        User savedUser = session.get(User.class, id);
        assertNotNull(savedUser);
        assertThat(savedUser.getBookings(), hasSize(2));
        assertThat(savedUser.getComment(), hasSize(2));
        assertNotNull(savedUser.getBlacklist());
    }

    private void fillUser(Session session, User user) {
        Book book = entityCreator.createAudioBook();
        session.save(book);
        session.save(entityCreator.createBooking(user));
        session.save(entityCreator.createBooking(user));
        session.save(entityCreator.createComment(user, book));
        session.save(entityCreator.createComment(user, book));
        session.save(entityCreator.createBlacklist(user));
    }
}