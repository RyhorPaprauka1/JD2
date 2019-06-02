package by.itacademy.database;

import by.itacademy.database.dao.BookDao;
import by.itacademy.database.entity.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogFilterDto {

    private String name;
    private Genre genre;
    private Integer maxPrice;
    private Integer limit;
    private Integer pageNumber;

    public Integer getOffset() {
        return pageNumber <= 1 ? 0 : (pageNumber - 1) * limit;
    }

    public Integer getAllPageNumber() {
        return Math.round(BookDao.getInstance().getAll().size()/limit);
    }
}
