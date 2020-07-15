package test.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import test.users.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {  //чтобы засунуть в конфиг!!!!!!!!!
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);

}
