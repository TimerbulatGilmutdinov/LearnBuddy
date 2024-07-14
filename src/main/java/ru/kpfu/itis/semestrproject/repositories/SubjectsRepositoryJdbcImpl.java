package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.Subject;
import ru.kpfu.itis.semestrproject.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.function.Function;

public class SubjectsRepositoryJdbcImpl implements SubjectsRepository{
    private static final String SQL_FIND_BY_ID = "select * from subjects where id = ?";
    private static final String SQL_FIND_BY_NAME = "select * from subjects where name = ?";
    private static final String SQL_ADD_SUBJECT = "insert into subjects(name) values (?)";

    private final DataSource dataSource;

    public SubjectsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static final Function<ResultSet, Subject> subjectMapper = row -> {
        try {
            Long id = row.getLong("id");
            String name = row.getString("name");
            return new Subject(id, name);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public Subject findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return subjectMapper.apply(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Subject findByName(String name) {
        name = name.toLowerCase();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return subjectMapper.apply(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public boolean addSubject(Subject subject) {
        boolean result = true;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_SUBJECT)) {
            statement.setString(1, subject.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return result;
    }
}
