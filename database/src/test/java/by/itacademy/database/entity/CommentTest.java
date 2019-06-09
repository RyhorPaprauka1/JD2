package by.itacademy.database.entity;

import by.itacademy.database.BaseTest;
import by.itacademy.database.repository.BookRepository;
import by.itacademy.database.repository.CommentRepository;
import by.itacademy.database.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

public class CommentTest extends BaseTest {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkSaveComment() {
        Comment comment = Comment.builder()
                .user(userRepository.findById(99L).orElse(null))
                .book(bookRepository.findById(99L).orElse(null))
                .text("Otlichnaya kniga")
                .build();

        commentRepository.save(comment);
        assertNotNull(commentRepository.findById(comment.getId()).orElse(null));
    }

    @Test
    public void checkGetComment() {
        Comment comment = commentRepository.findById(99L).orElse(null);

        assertNotNull(comment);
        assertThat(comment.getUser().getLogin(), equalTo("user"));
        assertThat(comment.getBook().getName(), equalTo("БИОЛОГИЯ"));
    }
}