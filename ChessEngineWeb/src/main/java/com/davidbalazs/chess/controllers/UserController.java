package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.data.UserData;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.facades.UserFacade;
import com.davidbalazs.chess.validators.AdditionalUserValidator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    public static final Logger LOGGER = Logger.getLogger(UserController.class);
    private static final String REGISTER_USER_VALIDATION_ERRORS_LOG_MESSAGE = "Error submitting register user form due to validation errors.";
    private static final String REGISTER_USER_ADDITIONAL_VALIDATION_ERRORS_LOG_MESSAGE = "Additional validator found the following errors in the submitted userData: {0}";
    private static final String REGISTER_USER_LOG_MESSAGE = "Received request to register user with username: {0}";

    @Resource(name = "userFacade")
    private UserFacade userFacade;

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "additionalUserValidator")
    private AdditionalUserValidator additionalUserValidator;

    @RequestMapping(value = "register-form", method = RequestMethod.GET)
    public String loadPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        UserData user = new UserData();
        model.addAttribute("user", user);
        return "pages/registerUserPage";
    }

    @RequestMapping(value = "register-user", method = RequestMethod.POST)
    public String registerUser(Model model, @Valid @ModelAttribute("user") UserData userData, BindingResult result, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);

        if (result.hasErrors()) {
            LOGGER.error(REGISTER_USER_VALIDATION_ERRORS_LOG_MESSAGE);
            return "pages/registerUserPage";
        }

        List<String> errorMessages = additionalUserValidator.validate(userData);

        if (!errorMessages.isEmpty()) {
            LOGGER.error(MessageFormat.format(REGISTER_USER_ADDITIONAL_VALIDATION_ERRORS_LOG_MESSAGE, errorMessages));

            return "pages/registerUserPage";
        }

        LOGGER.info(MessageFormat.format(REGISTER_USER_LOG_MESSAGE, userData.getUsername()));

        userFacade.create(userData);

        model.addAttribute("userRegisteredSuccessfully", true);
        return "pages/registerUserPage";
    }
}
