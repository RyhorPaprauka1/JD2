package by.itacademy.web.servlet;

import by.itacademy.database.entity.enums.Genre;
import by.itacademy.service.service.BookService;
import by.itacademy.service.vo.CatalogValues;
import by.itacademy.web.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.register(WebConfig.class);
        context.refresh();

        req.setAttribute("books", context.getBean(BookService.class).getAll());
        req.setAttribute("genres", Genre.values());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/catalog.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CatalogValues values = CatalogValues.builder()
                .name(req.getParameter("name"))
                .genre(req.getParameter("genre"))
                .price(req.getParameter("maxPrice"))
                .limit(req.getParameter("limit"))
                .page(req.getParameter("page"))
                .build();

        req.setAttribute("books", context.getBean(BookService.class).getCatalog(values));
        req.setAttribute("genres", Genre.values());
        req.setAttribute("pageNumber", context.getBean(BookService.class).getPageNumber(values));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/catalog.jsp")
                .forward(req, resp);
    }
}
