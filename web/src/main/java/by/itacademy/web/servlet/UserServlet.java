package by.itacademy.web.servlet;

import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.User;
import by.itacademy.service.service.BookService;
import by.itacademy.service.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User defaultUser = userService.getDefaultUser();
        Book randomBook = bookService.getRandomBook();

        req.setAttribute("user", defaultUser);
        req.setAttribute("book", randomBook);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
