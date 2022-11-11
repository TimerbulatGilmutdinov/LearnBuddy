package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.User;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface UsersRepository {
    boolean registerUser(User user);
    void updateUser(User user);
    boolean deleteUserById(Long id);
    User findByEmail(String email);
    User findById(Long id);
    String findHashByEmail(String email);
    List<User> findAllByUserIdList(List<Long> userIds);
}
