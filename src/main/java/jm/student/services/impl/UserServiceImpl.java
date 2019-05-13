package jm.student.services.impl;

import jm.student.dao.UserDao;
import jm.student.models.User;
import jm.student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) { return userDao.getUserByLogin(login);}

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
