package test.users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.users.model.Role;
import test.users.model.User;

import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Role getRoleById(int id) {
        Session session = sessionFactory.openSession();
        Role role = (Role) session.createQuery("FROM Role where id =: roleId")
                .setParameter("roleId", id)
                .uniqueResult();
        session.close();
        return role;
    }
    @Override
    public List<Role> getRolesByName(Set<Integer> ids){
        return sessionFactory.getCurrentSession()
                .createQuery("from Role role where role.id in (:ids)")
                .setParameter("ids", ids).getResultList();

    }

}
