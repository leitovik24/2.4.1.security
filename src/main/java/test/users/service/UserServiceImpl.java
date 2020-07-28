package test.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import test.users.dao.RoleDao;
import test.users.dao.UserDao;
import test.users.model.Role;
import test.users.model.User;;
import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private final RoleDao roleDao;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(RoleDao roleDao, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void addAdmin(User user) {
        user.setRoles(Collections.singleton(roleDao.getRoleById(1)));
        userDao.add(user);
    }
    @Override
    @Transactional
    public void add(User user) {
        user.setRoles(Collections.singleton(roleDao.getRoleById(2)));
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }


}
