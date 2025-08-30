package com.lamdayne.service.impl;

import com.lamdayne.dao.UserDAO;
import com.lamdayne.dao.impl.UserDAOImpl;
import com.lamdayne.model.User;
import com.lamdayne.service.UserService;
import com.lamdayne.util.PasswordUtil;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDao = new UserDAOImpl();

    @Override
    public User create(User entity) {
        entity.setPasswordHash(PasswordUtil.hashPassword(entity.getPasswordHash()));
        entity.setCreateAt(new Date());
        return findOne(userDao.create(entity).getUserID());
    }

    @Override
    public User update(User entity) {
        entity.setPasswordHash(PasswordUtil.hashPassword(entity.getPasswordHash()));
        userDao.update(entity);
        return this.findOne(entity.getUserID());
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public User findOne(Long id) {
        User user = userDao.findById(id);
        return user;
    }
}
