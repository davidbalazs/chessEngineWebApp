package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.models.UserState;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface UserService {
    List<UserModel> getAll();

    UserModel getByUsername(String username);

    @Transactional
    void create(UserModel user);

    @Transactional
    void delete(String username);

    @Transactional
    void changeUserState(String username,UserState newState);
}
