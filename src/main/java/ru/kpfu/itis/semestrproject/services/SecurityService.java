package ru.kpfu.itis.semestrproject.services;

import com.twmacinta.util.MD5;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.repositories.UserSubjectRepository;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;

public class SecurityService {
    private final UsersRepository usersRepository;
    private final UserSubjectRepository userSubjectRepository;

    public SecurityService(UsersRepository usersRepository, UserSubjectRepository userSubjectRepository){
        this.usersRepository = usersRepository;
        this.userSubjectRepository = userSubjectRepository;
    }
    public void deleteUser(User user){
        userSubjectRepository.deleteUserById(user.getId());
        usersRepository.deleteUserById(user.getId());
    }
    public String getHash(String pass){
        MD5 md5 = new MD5();
        md5.Update(pass);
        return md5.asHex();
    }
}
