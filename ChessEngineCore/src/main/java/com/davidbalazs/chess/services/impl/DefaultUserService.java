package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.UserDao;
import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultUserService implements UserService {
    private UserDao userDao;

    @Override
    public UserModel getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    @Transactional
    public void create(UserModel user) {
        userDao.create(user);
    }

    @Required
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
