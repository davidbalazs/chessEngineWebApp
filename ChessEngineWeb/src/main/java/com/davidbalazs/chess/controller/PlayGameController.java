package com.davidbalazs.chess.controller;

import com.davidbalazs.chess.algorithms.MoveAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "next-move", method = RequestMethod.GET)
    public String generateNextMove(@RequestParam("chessPositionFen") String chessPositionFen,
                                   @RequestParam("sideToMove") String sideToMove,
                                   @RequestParam("virtualPlayerLevel") String virtualPlayerLevel) {
        return "";
    }
}
