package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.UserData;
import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.models.UserRole;
import com.davidbalazs.chess.models.UserState;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class UserConverter {
    public UserModel convert(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setUsername(userData.getUsername());
        userModel.setPassword(userData.getPassword());
        userModel.setEmail(userData.getEmail());
        userModel.setFirstName(userData.getFirstName());
        userModel.setLastName(userData.getLastName());
        userModel.setRole(UserRole.ROLE_USER);
        userModel.setState(UserState.ACTIVE);

        return userModel;
    }
}
