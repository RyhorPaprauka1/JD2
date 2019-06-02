package by.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.ArrayDeque;
import java.util.Deque;

import static by.itacademy.database.util.SessionManager.getFactory;
import static by.itacademy.database.util.SessionManager.getSession;

public abstract class EntityBaseTest {

    private static Deque<Class> classes;

    static {
        classes = new ArrayDeque<>();
        classes.add(Blacklist.class);
        classes.add(Comment.class);
        classes.add(Author.class);
        classes.add(Booking.class);
        classes.add(Book.class);
        classes.add(User.class);
    }

    @Before
    public void cleanTable() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        for (Class clazz : classes) {
            session.createQuery(String.format("delete from %s", clazz.getSimpleName())).executeUpdate();
        }
        session.getTransaction().commit();
    }

    @AfterClass
    public static void close() {
        getFactory().close();
    }
}
