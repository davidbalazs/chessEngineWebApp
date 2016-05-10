package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.data.ChessStrategyCategoryData;
import com.davidbalazs.chess.data.ChessStrategyDetailsData;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.facades.ChessStrategyFacade;
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

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "administration/strategy/")
public class AdministrationStrategyPageController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationStrategyPageController.class);
    private static final String ERROR_SUBMITTING_STRATEGY_DETAILS_FORM_LOG_MESSAGE = "Error submitting strategy details form";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "chessStrategyFacade")
    private ChessStrategyFacade chessStrategyFacade;

    @RequestMapping(value = "add-strategy-details-form", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying add strategy form.");
        model.addAttribute("chessStrategyDetails", new ChessStrategyDetailsData());
        model.addAttribute("possibleChessStrategyCategories", ChessStrategyCategoryData.values());
        return "pages/administration/administrationStrategyDetailsPage";
    }

    @RequestMapping(value = "add-strategy-moves", method = RequestMethod.GET)
    public String generateStrategyMoves(Model model, Principal principal, @RequestParam("strategy-id") long strategyId) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);

        return "pages/administration/administrationStrategyMovesPage";
    }


    @RequestMapping(value = "add-strategy-details", method = RequestMethod.POST)
    public String addQuote(RedirectAttributes redirectAttrs, @Valid @ModelAttribute("chessStrategyDetails") ChessStrategyDetailsData chessStrategyDetails, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.error(ERROR_SUBMITTING_STRATEGY_DETAILS_FORM_LOG_MESSAGE);
            redirectAttrs.addFlashAttribute("message", "Error submitting form. Please try again with valid data.");
            return "redirect:add-strategy-details-form";
        }

        long strategyId = chessStrategyFacade.createUsingStrategyDetails(chessStrategyDetails);
        return "redirect:add-strategy-moves?strategy-id=" + strategyId;
    }
}
