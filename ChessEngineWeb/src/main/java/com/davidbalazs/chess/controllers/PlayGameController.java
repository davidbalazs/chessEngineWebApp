package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayerColorData;
import com.davidbalazs.chess.facades.ChessMoveFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by David on 3/24/2016.
 */
@Controller
@RequestMapping(value = "playgame/")
public class PlayGameController {

    @Resource(name = "chessMoveFacade")
    private ChessMoveFacade chessMoveFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPage() {
        return "pages/playGamePage";
    }

    @RequestMapping(value = "next-move", method = RequestMethod.GET)
    @ResponseBody
    public ChessMoveData generateNextMove(@RequestParam("chessPositionFen") String chessPositionFen,
                                          @RequestParam("sideToMove") String sideToMove,
                                          @RequestParam("virtualPlayerLevel") String virtualPlayerLevel) {
        PlayerColorData sideToMoveEnum = PlayerColorData.valueOf(sideToMove);
        return chessMoveFacade.getNextMove(chessPositionFen, sideToMoveEnum, Integer.parseInt(virtualPlayerLevel));
    }
}
