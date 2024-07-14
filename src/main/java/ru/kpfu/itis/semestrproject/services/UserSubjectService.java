package ru.kpfu.itis.semestrproject.services;

import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.models.UserSubject;
import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;

import java.util.List;

public class UserSubjectService {
    private final UsersRepository usersRepository;
    private final UserSubjectRepository userSubjectRepository;

    public UserSubjectService(UsersRepository usersRepository, UserSubjectRepository userSubjectRepository){
        this.usersRepository = usersRepository;
        this.userSubjectRepository = userSubjectRepository;
    }

    public List<User> findAllUsersBySubject(String subject){
        List<Long> userIds = findAllUserIdBySubject(subject);
        return usersRepository.findAllByUserIdList(userIds);
    }

    private List<Long> findAllUserIdBySubject(String subject){
        return userSubjectRepository.findAllUserIdBySubject(subject);
    }

    public List<User> findAllMatchingUsers(UserSubject userSubject){
        List<Long> userIds = findAllUserIdByMatchingSubjects(userSubject);
        return usersRepository.findAllByUserIdList(userIds);
    }

    private List<Long> findAllUserIdByMatchingSubjects(UserSubject userSubject){
        return userSubjectRepository.findAllUserIdByMatchingSubjects(userSubject);
    }
}
