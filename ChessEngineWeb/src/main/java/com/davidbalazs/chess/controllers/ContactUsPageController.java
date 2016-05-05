package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.data.ContactUsForm;
import com.davidbalazs.chess.enhancers.SideBarEnhancer;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.facades.MessageFacade;
import com.davidbalazs.chess.helpers.UserHelper;
import com.davidbalazs.chess.models.UserModel;
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

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "contact-us/")
public class ContactUsPageController {
    public static final Logger LOGGER = Logger.getLogger(ContactUsPageController.class);
    private static final String RECEIVED_MESSAGE_LOG_MESSAGE = "received message from user [{0}] and message: [{1}]";
    private static final String ERROR_SUBMITTING_MESSAGE_FORM_LOG_MESSAGE = "error submitting contactUsForm";
    private static final String USING_USER_DETAILS_TO_AUTOCOMPLETE_CONTACT_US_FORM_LOG_MESSAGE = "User [ username = {0} ] is logged in, using his profile details to autocomplete contactUsForm.";

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "messageFacade")
    private MessageFacade messageFacade;

    @Resource(name = "userHelper")
    private UserHelper userHelper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);
        ContactUsForm contactUsForm = new ContactUsForm();

        UserModel loggedInUser = userHelper.getLoggedInUser(principal);
        if (loggedInUser != null) {
            populateContactUsForm(contactUsForm, loggedInUser);
            LOGGER.info(MessageFormat.format(USING_USER_DETAILS_TO_AUTOCOMPLETE_CONTACT_US_FORM_LOG_MESSAGE, loggedInUser.getUsername()));
        }

        model.addAttribute("contactUsForm", contactUsForm);
        return "pages/contactUsPage";
    }

    private void populateContactUsForm(ContactUsForm contactUsForm, UserModel loggedInUser) {
        contactUsForm.setUsername(loggedInUser.getUsername());
        contactUsForm.setEmail(loggedInUser.getEmail());
    }

    @RequestMapping(value = "send-message", method = RequestMethod.POST)
    public String sendMessage(Model model, @Valid @ModelAttribute("contactUsForm") ContactUsForm contactUsForm, BindingResult result, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        if (result.hasErrors()) {
            LOGGER.error(ERROR_SUBMITTING_MESSAGE_FORM_LOG_MESSAGE);
            return "pages/contactUsPage";
        }

        LOGGER.info(MessageFormat.format(RECEIVED_MESSAGE_LOG_MESSAGE,
                contactUsForm.getUsername(), contactUsForm.getMessage().replace(System.getProperty("line.separator"), " ")));

        messageFacade.create(contactUsForm);
        model.addAttribute("contactUsMessageSentSuccessfuly", true);
        return "pages/contactUsPage";
    }
}
