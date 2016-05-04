package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.UserModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface UserDao {
    UserModel getByUsername(String username);

    void create(UserModel user);
}
