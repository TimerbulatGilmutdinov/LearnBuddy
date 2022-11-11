package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.Subject;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserSubjectRepositoryJdbcImpl implements UserSubjectRepository {
    private static final String SQL_FIND_ALL_USER_ID_BY_MATCHING_SUBJECTS = "select * from user_subject t where (t.maths = ? or ? = false) and (t.physics = ? or ? = false) and (t.english_language = ? or ? = false) and (t.programming = ? or ? = false) and (t.history = ? or ? = false) and (t.economics = ? or ? = false) and (t.law = ? or ? = false)";
    private static final String SQL_FIND_ALL_USER_ID_BY_ = "select * from user_subject where ";
    private static final String SQL_FIND_BY_USER_ID = "select * from user_subject where user_id=?";
    private static final String SQL_ADD_DEFAULT_SUBJECT_VALUES_TO_USER = "insert into user_subject values(?,?,?,?,?,?,?,?)";
    private static final String SQL_SET_SUBJECT_VALUE_TO_USER = "update user_subject set maths = ?, physics = ?, programming = ?, english_language = ?, history = ?, economics = ?, law = ? where user_id=?";
    private static final String SQL_DELETE_USER_BY_ID = "delete from user_subject where user_id = ?";

    private final DataSource dataSource;

    public UserSubjectRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static final Function<ResultSet, UserSubject> userSubjectMapper = row -> {

        try {
            Long user_id = row.getLong("user_id");
            Boolean maths = row.getBoolean("maths");
            Boolean physics = row.getBoolean("physics");
            Boolean englishLanguage = row.getBoolean("english_language");
            Boolean programming = row.getBoolean("programming");
            Boolean history = row.getBoolean("history");
            Boolean economics = row.getBoolean("economics");
            Boolean law = row.getBoolean("law");
            return new UserSubject(user_id, maths, physics, englishLanguage, programming, history, economics, law);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    };

    @Override
    public void setDefaultSubjectValuesToUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_DEFAULT_SUBJECT_VALUES_TO_USER)) {
            statement.setLong(1, user.getId());
            for (int i = 2; i <= 8; i++) {
                statement.setBoolean(i, false);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void setSubjectValuesToUser(UserSubject userSubject) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SET_SUBJECT_VALUE_TO_USER)) {
            statement.setBoolean(1, userSubject.isMaths());
            statement.setBoolean(2, userSubject.isPhysics());
            statement.setBoolean(3, userSubject.isProgramming());
            statement.setBoolean(4, userSubject.isEnglishLanguage());
            statement.setBoolean(5, userSubject.isHistory());
            statement.setBoolean(6, userSubject.isEconomics());
            statement.setBoolean(7, userSubject.isLaw());
            statement.setLong(8, userSubject.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Long> findAllUserIdBySubject(String subject) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USER_ID_BY_ + subject +" = true")) {
            List<Long> userIds = new ArrayList<>();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UserSubject userSubject = userSubjectMapper.apply(resultSet);
                    userIds.add(userSubject.getUserId());
                }
            }
            return userIds;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Long> findAllUserIdByMatchingSubjects(UserSubject userSubject) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USER_ID_BY_MATCHING_SUBJECTS)) {
            List<Long> userIds = new ArrayList<>();
            statement.setBoolean(1, userSubject.isMaths());
            statement.setBoolean(2, userSubject.isMaths());
            statement.setBoolean(3, userSubject.isPhysics());
            statement.setBoolean(4, userSubject.isPhysics());
            statement.setBoolean(5, userSubject.isEnglishLanguage());
            statement.setBoolean(6, userSubject.isEnglishLanguage());
            statement.setBoolean(7, userSubject.isProgramming());
            statement.setBoolean(8, userSubject.isProgramming());
            statement.setBoolean(9, userSubject.isHistory());
            statement.setBoolean(10, userSubject.isHistory());
            statement.setBoolean(11, userSubject.isEconomics());
            statement.setBoolean(12, userSubject.isEconomics());
            statement.setBoolean(13, userSubject.isLaw());
            statement.setBoolean(14, userSubject.isLaw());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    UserSubject matchedUserSubject = userSubjectMapper.apply(resultSet);
                    userIds.add(matchedUserSubject.getUserId());
                }
            }
            return userIds;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public UserSubject findByUserId(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_USER_ID)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserSubject userSubject = userSubjectMapper.apply(resultSet);
                    return userSubject;
                } else {
                    return null;
                }
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    @Override
    public boolean deleteUserById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return true;
    }

}
