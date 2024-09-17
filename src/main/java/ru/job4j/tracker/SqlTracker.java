package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
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

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO items(name, created) VALUES(?, ?)",
                Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error add item", e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?"
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new IllegalStateException("Error replace item", e);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM items WHERE id = ?"
        )) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("Errod delete item", e);
        }
    }

    @Override
    public List<Item> findAll() {
        var items = new ArrayList<Item>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                     items.add(createItem(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error findAll items", e);
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        var items = new ArrayList<Item>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(createItem(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error find it items by name", e);
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM items WHERE id = ?"
        )) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = createItem(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error find it items by id", e);
        }
        return result;
    }

    private Item createItem(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        LocalDateTime created = resultSet.getTimestamp("created").toLocalDateTime();
        var result = new Item(id, name);
        result.setCreated(created);
        return result;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
