package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAadReplaceItemThenItemMustHaveNewNameAntReturnTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        Item newItem = new Item("newItem");
        boolean result = tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("newItem");
        assertThat(result).isTrue();
    }

    @Test
    public void whenDeleteItamThenFindByGeneratedIdReturnNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenSaveItemsThenAllItemsExistInList() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> expected = List.of(first, second);
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenSaveItemAndFindByNameThenReturnSameItemsList() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        List<Item> expected = List.of(item);
        assertThat(tracker.findByName("Item")).isEqualTo(expected);
    }
}