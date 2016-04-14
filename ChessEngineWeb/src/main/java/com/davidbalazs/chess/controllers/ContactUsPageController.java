package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import com.davidbalazs.chess.data.ContactUsForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "contact-us/")
public class ContactUsPageController {
    public static final Logger LOGGER = Logger.getLogger(ContactUsPageController.class);

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadPage(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);
        model.addAttribute("contactUsForm", generateContactUsForm());
        return "pages/contactUsPage";
    }

    @RequestMapping(value = "send-message", method = RequestMethod.POST)
    public String sendMessage(Model model, @Valid @ModelAttribute("contactUsForm") ContactUsForm contactUsForm, BindingResult result) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        if (result.hasErrors()) {
            LOGGER.error("error submitting contactUsForm");
            return "pages/contactUsPage";
        }

        model.addAttribute("contactUsForm", generateContactUsForm());
        LOGGER.info("received message from user " + contactUsForm.getUsername());
        return "pages/contactUsPage";
    }

    private ContactUsForm generateContactUsForm() {
        return new ContactUsForm();
    }
}
