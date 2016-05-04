package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.converters.UserConverter;
import com.davidbalazs.chess.data.UserData;
import com.davidbalazs.chess.facades.UserFacade;
import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultUserFacade implements UserFacade {
    private UserService userService;
    private UserConverter userConverter;

    public void create(UserData userData) {
        UserModel userModel = userConverter.convert(userData);
        userService.create(userModel);
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Required
    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }
}
