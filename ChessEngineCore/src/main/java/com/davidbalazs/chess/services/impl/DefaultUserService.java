package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.UserDao;
import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultUserService implements UserService {
    private UserDao userDao;

    @Override
    public UserModel getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Required
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
