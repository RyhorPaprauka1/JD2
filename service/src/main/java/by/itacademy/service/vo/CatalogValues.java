package by.itacademy.service.vo;

import by.itacademy.database.entity.enums.Genre;
import lombok.Builder;

@Builder
public class CatalogValues {

    private String name;
    private String genre;
    private String price;
    private String limit;
    private String page;

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return Genre.valueOf(genre);
    }

    public Integer getPrice() {
        return Integer.valueOf(price);
    }

    public Integer getLimit() {
        return Integer.valueOf(limit);
    }

    public Integer getPage() {
        return Integer.valueOf(page);
    }
}
