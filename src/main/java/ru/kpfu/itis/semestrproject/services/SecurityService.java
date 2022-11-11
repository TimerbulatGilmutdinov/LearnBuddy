package ru.kpfu.itis.semestrproject.services;

import com.twmacinta.util.MD5;
import ru.kpfu.itis.semestrproject.models.User;
import ru.kpfu.itis.semestrproject.repositories.UsersRepository;

public class SecurityService {
    private UsersRepository usersRepository;

    public SecurityService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public void deleteUser(User user){
        usersRepository.deleteUserById(user.getId());
    }
    public String getHash(String pass){
        MD5 md5 = new MD5();
        md5.Update(pass);
        return md5.asHex();
    }
}
