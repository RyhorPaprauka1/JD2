package by.itacademy.web.controller;

import by.itacademy.database.entity.enums.Genre;
import by.itacademy.service.service.BookService;
import by.itacademy.service.vo.CatalogValues;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static by.itacademy.web.path.UrlPath.CATALOG;

@Controller
@RequestMapping(CATALOG)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CatalogController {

    private BookService bookService;

    @ModelAttribute
    public void setReferences(Model model) {
        model.addAttribute("genres", Genre.values());
    }

    @GetMapping
    public String getPage(Model model, CatalogValues values) {
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("pageNumber", bookService.getPageNumber(values));

        return "catalog";
    }

    @PostMapping
    public String getFilteredPage(Model model, CatalogValues values) {
        model.addAttribute("books", bookService.getCatalog(values));
        model.addAttribute("pageNumber", bookService.getPageNumber(values));

        return "catalog";
    }
}
