package com.davidbalazs.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by David on 3/24/2016.
 */
@Controller
@RequestMapping(value = "playgame/")
public class PlayGameController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPage() {
        return "pages/playGamePage";
    }
}