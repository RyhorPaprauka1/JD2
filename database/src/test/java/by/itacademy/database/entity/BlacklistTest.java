package by.itacademy.database.entity;

import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static by.itacademy.database.util.SessionManager.getSession;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BlacklistTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveBlacklist() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        User user = entityCreator.createUser("логин");
        session.save(user);

        Blacklist blacklist = entityCreator.createBlacklist(user);
        Serializable id = session.save(blacklist);
        assertNotNull(id);
    }

    @Test
    public void checkGetBlacklist() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        User user = entityCreator.createUser("логин");
        session.save(user);

        Blacklist blacklist = entityCreator.createBlacklist(user);
        Serializable id = session.save(blacklist);
        assertNotNull(id);

        session.getTransaction().commit();
        session.clear();

        Blacklist savedBlacklist = session.get(Blacklist.class, id);
        assertNotNull(savedBlacklist);
        assertThat(savedBlacklist.getUser(), equalTo(user));
    }
}