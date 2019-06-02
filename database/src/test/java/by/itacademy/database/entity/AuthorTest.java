package by.itacademy.database.entity;

import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hamcrest.Matchers;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static by.itacademy.database.util.SessionManager.getSession;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AuthorTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveAuthor() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        Author author = entityCreator.createAuthor();
        Serializable id = session.save(author);
        assertNotNull(id);
    }

    @Test
    public void checkGetAuthor() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        Author author = entityCreator.createAuthor();
        Serializable id = session.save(author);
        assertNotNull(id);

        writeBooks(session, author);
        session.getTransaction().commit();
        session.clear();

        Author savedAuthor = session.get(Author.class, id);
        assertNotNull(savedAuthor);
        assertThat(savedAuthor.getBooks(), Matchers.hasSize(2));
    }

    private void writeBooks(Session session, Author author) {
        Book book = entityCreator.createAudioBook();
        book.getAuthors().add(author);
        session.save(book);

        Book secondBook = entityCreator.createAudioBook();
        book.getAuthors().add(author);
        session.save(secondBook);
    }
}