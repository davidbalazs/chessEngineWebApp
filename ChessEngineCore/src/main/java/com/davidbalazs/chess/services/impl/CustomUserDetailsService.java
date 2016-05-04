package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class CustomUserDetailsService implements UserDetailsService {
    public static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);
    private static final String LOAD_BY_USERNAME_LOG_MESSAGE = "Trying to load user by username: {0}.";
    private static final String USER_ROLE_LOG_MESSAGE = "User with username: {0} has the following role: {1}";
    private static final String FOUND_USER_LOG_MESSAGE = "Found user: {0}.";
    private static final String USER_NOT_FOUND_LOG_MESSAGE = "User with username: {0} not found.";
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info(MessageFormat.format(LOAD_BY_USERNAME_LOG_MESSAGE, username));
        UserModel userModel = userService.getByUsername(username);

        if (userModel == null) {
            String logMessage = MessageFormat.format(USER_NOT_FOUND_LOG_MESSAGE, username);
            LOGGER.error(logMessage);
            throw new UsernameNotFoundException(logMessage);
        }

        LOGGER.info(MessageFormat.format(FOUND_USER_LOG_MESSAGE, userModel));
        return generateSpringUser(userModel);
    }

    private User generateSpringUser(UserModel userModel) {
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, getGrantedAuthorities(userModel));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UserModel userModel) {
        String userRole = userModel.getRole().name();
        LOGGER.info(MessageFormat.format(USER_ROLE_LOG_MESSAGE, userModel.getUsername(), userRole));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole));
        return authorities;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
