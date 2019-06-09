package by.itacademy.web.servlet;

import by.itacademy.database.CatalogFilterDto;
import by.itacademy.database.entity.enums.Genre;
import by.itacademy.service.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    private BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.getAll());
        req.setAttribute("genres", Genre.values());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/catalog.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNumber = Integer.valueOf(req.getParameter("pageNumber"));
        CatalogFilterDto catalogFilter = CatalogFilterDto.builder()
                .name(req.getParameter("name"))
                .genre(Genre.valueOf(req.getParameter("genre")))
                .maxPrice(Integer.valueOf(req.getParameter("maxPrice")))
                .limit(Integer.valueOf(req.getParameter("maxResult")))
                .pageNumber(Objects.isNull(pageNumber) ? 1 : pageNumber)gi
                .build();

        req.setAttribute("books", bookService.getCatalog(catalogFilter));
        req.setAttribute("genres", Genre.values());
        req.setAttribute("pageNumber", catalogFilter.getAllPageNumber());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/catalog.jsp")
                .forward(req, resp);
    }
}
