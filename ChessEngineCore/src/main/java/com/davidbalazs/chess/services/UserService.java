package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.UserModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface UserService {
    UserModel getByUsername(String username);

    void create(UserModel user);
}
