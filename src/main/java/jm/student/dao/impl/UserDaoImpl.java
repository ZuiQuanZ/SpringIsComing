package jm.student.dao.impl;

import jm.student.dao.UserDao;
import jm.student.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByLogin(String login){ return (User) entityManager.createQuery("select u from User u where u.login = :login").setParameter("login",login).getSingleResult();}

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void editUser(User user) {
        entityManager.merge(user);
    }

    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("FROM User").getResultList();
    }
}
