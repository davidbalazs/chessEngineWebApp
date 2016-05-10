package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.data.ChessStrategyCategoryData;
import com.davidbalazs.chess.data.ChessStrategyDetailsData;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "administration/strategy/")
public class AdministrationStrategyPageController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationStrategyPageController.class);

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @RequestMapping(value = "add-strategy-details-form", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying add strategy form.");
        model.addAttribute("chessStrategyDetails", new ChessStrategyDetailsData());
        model.addAttribute("possibleChessStrategyCategories", ChessStrategyCategoryData.values());
        return "pages/administration/administrationStrategyPage";
    }

}
