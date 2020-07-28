package test.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import test.users.model.Role;
import test.users.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {  //чтобы засунуть в конфиг!!!!!!!!!
    List<User> allUsers();
    void addAdmin(User user);
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getUserById(int id);
    public List<Role> getRolesByName(Set<Integer> ids);
}
