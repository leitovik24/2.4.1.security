package test.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import test.users.model.User;

import java.util.List;

public interface UserService {  //чтобы засунуть в конфиг!!!!!!!!!
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getUserById(int id);
}
