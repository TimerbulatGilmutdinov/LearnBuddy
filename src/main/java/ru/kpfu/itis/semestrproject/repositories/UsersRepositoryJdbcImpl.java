package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private static final String SQL_FIND_HASH_BY_EMAIL = "select password_hash from users where email = ?";
    private static final String SQL_INSERT_USER = "insert into users(name, surname, email, password_hash, birthdate, gender, country, city) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_EMAIL = "select * from users where email = ?";
    private static final String SQL_FIND_BY_ID = "select * from users where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from users where id = ?";
    private static final String SQL_UPDATE_BY_ID = "update users set name = ?,surname = ?, password_hash = ? ,country = ?, city = ? where id = ?";

    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static final Function<ResultSet, User> userMapper = row -> {

        try {
            Long id = row.getLong("id");
            String name = row.getString("name");
            String surname = row.getString("surname");
            String email = row.getString("email");
            String passwordHash = row.getString("password_hash");
            String birthdate = row.getString("birthdate");
            String gender = row.getString("gender");
            String country = row.getString("country");
            String city = row.getString("city");
            boolean isAdmin = row.getBoolean("is_admin");
            return new User(id, name, surname, email, passwordHash, birthdate, gender, country, city, isAdmin);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    };

    private void setUserArgsToStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getName());
        statement.setString(2, user.getSurname());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPasswordHash());
        statement.setString(5, user.getBirthdate());
        statement.setString(6, user.getGender());
        statement.setString(7, user.getCountry());
        statement.setString(8, user.getCity());
    }

    @Override
    public boolean registerUser(User user) {
        boolean result = true;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER)) {
            setUserArgsToStatement(statement, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return result;
    }

    public List<User> findAllByUserIdList(List<Long> userIds) {
        List<User> foundUsers = new ArrayList<>();
        for (Long id : userIds) {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        User user = userMapper.apply(resultSet);
                        foundUsers.add(user);
                    }
                }
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return foundUsers;
    }


    @Override
    public void updateUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_ID)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPasswordHash());
            statement.setString(4, user.getCountry());
            statement.setString(5, user.getCity());
            statement.setLong(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return true;
    }


    @Override
    public User findByEmail(String email) {
        email = email.toLowerCase();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_EMAIL)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = userMapper.apply(resultSet);
                    return user;
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public User findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = userMapper.apply(resultSet);
                    return user;
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String findHashByEmail(String email) {
        String passwordHash = "";
        email = email.toLowerCase();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_HASH_BY_EMAIL)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    passwordHash = resultSet.getString("password_hash");
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return passwordHash;
    }
}
