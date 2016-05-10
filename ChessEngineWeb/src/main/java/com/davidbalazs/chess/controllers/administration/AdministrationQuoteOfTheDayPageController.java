package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.data.QuoteData;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.facades.QuoteOfTheDayFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.text.MessageFormat;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "administration/quote/")
public class AdministrationQuoteOfTheDayPageController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationQuoteOfTheDayPageController.class);
    private static final String DELETE_QUOTE_LOG_MESSAGE = "Received request to delete quote with id: {0}";
    private static final String MARK_AS_QUOTE_OF_THE_DAY_LOG_MESSAGE = "Received request to mark quote with id {0} as quote of the day.";
    private static final String UNMARK_AS_QUOTE_OF_THE_DAY_LOG_MESSAGE = "Received request to unmark quote with id {0} as quote of the day.";
    private static final String ERROR_SUBMITTING_ADD_QUOTE_FORM_LOG_MESSAGE = "Error submitting add quote form.";
    private static final String ADD_QUOTE_LOG_MESSAGE = "Received request to add quote with text {0}.";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "quoteOfTheDayFacade")
    private QuoteOfTheDayFacade quoteOfTheDayFacade;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all quotes");
        model.addAttribute("quoteList", quoteOfTheDayFacade.getAll());
        model.addAttribute("quoteData", new QuoteData());
        return "pages/administration/administrationQuoteOfTheDayPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteQuote(@RequestParam("quote-id") long quoteId) {
        LOGGER.info(MessageFormat.format(DELETE_QUOTE_LOG_MESSAGE, quoteId));
        quoteOfTheDayFacade.delete(quoteId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "mark-as-quote-of-the-day", method = RequestMethod.GET)
    public String markAsQuoteOfTheDay(@RequestParam("quote-id") long quoteId) {
        LOGGER.info(MessageFormat.format(MARK_AS_QUOTE_OF_THE_DAY_LOG_MESSAGE, quoteId));
        quoteOfTheDayFacade.markAsQuoteOfTheDay(quoteId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "unmark-as-quote-of-the-day", method = RequestMethod.GET)
    public String unmarkAsQuoteOfTheDay(@RequestParam("quote-id") long quoteId) {
        LOGGER.info(MessageFormat.format(UNMARK_AS_QUOTE_OF_THE_DAY_LOG_MESSAGE, quoteId));
        quoteOfTheDayFacade.unmarkAsQuoteOfTheDay(quoteId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addQuote(RedirectAttributes redirectAttrs, @Valid @ModelAttribute("quoteData") QuoteData quoteData, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.error(ERROR_SUBMITTING_ADD_QUOTE_FORM_LOG_MESSAGE);
            redirectAttrs.addFlashAttribute("message", "Error submitting form. Please try again with valid data.");
            return "redirect:show-all";
        }

        LOGGER.info(MessageFormat.format(ADD_QUOTE_LOG_MESSAGE, quoteData.getQuote()));
        redirectAttrs.addFlashAttribute("message", "Quote has been successfully added.");
        quoteOfTheDayFacade.add(quoteData);
        return "redirect:show-all";
    }
}
