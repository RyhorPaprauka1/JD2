package by.itacademy.database.entity;

import by.itacademy.database.BaseTest;
import by.itacademy.database.repository.BlackListRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BlacklistTest extends BaseTest {

    @Autowired
    private BlackListRepository blackListRepository;

    @Test
    public void checkGetBlacklist() {
        Blacklist blacklist = blackListRepository.findById(99L).orElse(null);
        assertNotNull(blacklist);
        assertThat(blacklist.getUser().getLogin(), equalTo("user"));
    }
}