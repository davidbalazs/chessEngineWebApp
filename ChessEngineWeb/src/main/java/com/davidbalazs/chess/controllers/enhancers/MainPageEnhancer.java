package com.davidbalazs.chess.controllers.enhancers;

import com.davidbalazs.chess.services.LatestNewsSideBarService;
import com.davidbalazs.chess.services.QuoteOfTheDayService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

/**
 * Created by David on 4/4/2016.
 */
public class MainPageEnhancer {
    private LatestNewsSideBarService latestNewsSideBarService;
    private QuoteOfTheDayService quoteOfTheDayService;

    public void enhanceModelWithSideBar(Model model) {
        enhanceModelWithLatestNewsSideBar(model);
        enhanceModelWithQuoteOfTheDaySideBar(model);
        enhanceModelWithProblemOfTheDaySideBar(model);
    }

    private void enhanceModelWithProblemOfTheDaySideBar(Model model) {
    }

    private void enhanceModelWithQuoteOfTheDaySideBar(Model model) {
        model.addAttribute("quoteOfTheDay", quoteOfTheDayService.getQuoteOfTheDay());
    }

    private void enhanceModelWithLatestNewsSideBar(Model model) {
        model.addAttribute("latestNews", latestNewsSideBarService.getLatestNews());
    }

    @Required
    public void setLatestNewsSideBarService(LatestNewsSideBarService latestNewsSideBarService) {
        this.latestNewsSideBarService = latestNewsSideBarService;
    }

    @Required
    public void setQuoteOfTheDayService(QuoteOfTheDayService quoteOfTheDayService) {
        this.quoteOfTheDayService = quoteOfTheDayService;
    }
}
