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

public class CommentTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveComment() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        User user = entityCreator.createUser("логин");
        session.save(user);

        Book book = entityCreator.createEBook();
        session.save(book);

        Comment comment = entityCreator.createComment(user, book);
        Serializable id = session.save(comment);
        assertNotNull(id);
    }

    @Test
    public void checkGetComment() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        User user = entityCreator.createUser("логин");
        session.save(user);

        Book book = entityCreator.createEBook();
        session.save(book);

        Comment comment = entityCreator.createComment(user, book);
        Serializable id = session.save(comment);
        assertNotNull(id);

        session.getTransaction().commit();
        session.clear();

        Comment savedComment = session.get(Comment.class, id);
        assertNotNull(savedComment);
        assertThat(savedComment.getUser(), equalTo(user));
        assertThat(savedComment.getBook(), equalTo(book));
    }
}