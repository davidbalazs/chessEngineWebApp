package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.enhancers.SideBarEnhancer;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.services.ChessStrategyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping(value = "chessStrategy/")
public class ChessStrategiesPageController {

    @Resource(name = "chessStrategyService")
    private ChessStrategyService chessStrategyService;

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @RequestMapping(value = "display-all", method = RequestMethod.GET)
    public String getStrategiesPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        model.addAttribute("chessStrategies", chessStrategyService.getChessStrategies());
        return "pages/chessStrategiesPage";
    }

    @RequestMapping(value = "display-strategy", method = RequestMethod.GET)
    public String getStrategy(@RequestParam("id") long chessStategyId, Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        model.addAttribute("chessStrategy", chessStrategyService.getById(chessStategyId));
        return "pages/chessStrategyPage";
    }
}
