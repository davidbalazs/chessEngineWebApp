package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import com.davidbalazs.chess.services.ChessStrategyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "chessStrategy/")
public class ChessStrategiesPageController {

    @Resource(name = "chessStrategyService")
    private ChessStrategyService chessStrategyService;

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "display-all", method = RequestMethod.GET)
    public String getStrategiesPage(Model model) {
        model.addAttribute("chessStrategies", chessStrategyService.getChessStrategies());
        mainPageEnhancer.enhanceModelWithSideBar(model);
        return "pages/chessStrategiesPage";
    }

    @RequestMapping(value = "display-strategy", method = RequestMethod.GET)
    public String getStrategy(@RequestParam("id") long chessStategyId, Model model) {
        model.addAttribute("chessStrategy", chessStrategyService.getById(chessStategyId));
        return "pages/chessStrategyPage";
    }
}
