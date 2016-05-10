package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.UserModel;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface UserDao {
    List<UserModel> getAll();

    UserModel getByUsername(String username);

    void create(UserModel user);

    void update(UserModel user);

    void deleteByUsername(String username);
}
