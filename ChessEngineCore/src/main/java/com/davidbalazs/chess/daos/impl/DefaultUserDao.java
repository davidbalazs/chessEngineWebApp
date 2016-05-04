package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.UserDao;
import com.davidbalazs.chess.models.UserModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultUserDao extends DefaultGenericDao<UserModel> implements UserDao {
    @Override
    public UserModel getByUsername(String username) {
        return entityManager.find(UserModel.class, username);
    }
}
