package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.UserDao;
import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.models.UserState;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultUserService implements UserService {
    private UserDao userDao;

    @Override
    public List<UserModel> getAll() {
        return userDao.getAll();
    }

    @Override
    public UserModel getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void create(UserModel user) {
        userDao.create(user);
    }

    @Override
    public void delete(String username) {
        userDao.deleteByUsername(username);
    }

    @Override
    public void changeUserState(String username,UserState newState) {
        UserModel user = userDao.getByUsername(username);
        user.setState(newState);
        userDao.update(user);
    }

    @Required
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
