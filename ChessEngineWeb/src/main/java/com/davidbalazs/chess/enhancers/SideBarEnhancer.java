package com.davidbalazs.chess.enhancers;

import com.davidbalazs.chess.services.ChessProblemService;
import com.davidbalazs.chess.services.LatestNewsService;
import com.davidbalazs.chess.services.QuoteOfTheDayService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

public class SideBarEnhancer {
    private LatestNewsService latestNewsService;
    private QuoteOfTheDayService quoteOfTheDayService;
    private ChessProblemService chessProblemService;

    public void enhanceModelWithSideBar(Model model) {
        enhanceModelWithLatestNewsSideBar(model);
        enhanceModelWithQuoteOfTheDaySideBar(model);
        enhanceModelWithProblemOfTheDaySideBar(model);
    }

    private void enhanceModelWithProblemOfTheDaySideBar(Model model) {
        model.addAttribute("chessProblemOfTheDay", chessProblemService.getProblemOfTheDay());
    }

    private void enhanceModelWithQuoteOfTheDaySideBar(Model model) {
        model.addAttribute("quoteOfTheDay", quoteOfTheDayService.getQuoteOfTheDay());
    }

    private void enhanceModelWithLatestNewsSideBar(Model model) {
        model.addAttribute("latestNews", latestNewsService.getAll());
    }

    @Required
    public void setLatestNewsService(LatestNewsService latestNewsService) {
        this.latestNewsService = latestNewsService;
    }

    @Required
    public void setQuoteOfTheDayService(QuoteOfTheDayService quoteOfTheDayService) {
        this.quoteOfTheDayService = quoteOfTheDayService;
    }

    @Required
    public void setChessProblemService(ChessProblemService chessProblemService) {
        this.chessProblemService = chessProblemService;
    }
}
