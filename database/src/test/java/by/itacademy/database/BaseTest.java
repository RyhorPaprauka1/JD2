package by.itacademy.database;

import by.itacademy.database.config.DBConfig;
import lombok.Getter;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Getter
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@Transactional
@Sql("classpath:testDB.sql")
public abstract class BaseTest {
}
