package by.itacademy.database.repository;

import by.itacademy.database.entity.Blacklist;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<Blacklist, Long> {
}
