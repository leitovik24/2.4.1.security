package test.users.dao;

import org.springframework.stereotype.Repository;
import test.users.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return (User)entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        User user = (User) entityManager.createQuery(" from User where name=:name")
                .setParameter("name", name).getSingleResult();
        return user;

    }
}
