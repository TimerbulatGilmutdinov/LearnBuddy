package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.Subject;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;

import java.util.List;

public interface UserSubjectRepository {
    void setDefaultSubjectValuesToUser(User user);
    void setSubjectValuesToUser(UserSubject userSubject);
    UserSubject findByUserId(Long userId);
    List<Long> findAllUserIdBySubject(String subject);
    List<Long> findAllUserIdByMatchingSubjects(UserSubject userSubject);
}
