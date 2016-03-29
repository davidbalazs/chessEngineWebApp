package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayerColorData;
import com.davidbalazs.chess.facades.ChessMoveFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.MessageFormat;

/**
 * Created by David on 3/24/2016.
 */
@Controller
@RequestMapping(value = "playgame/")
public class PlayGameController {
    public static final Logger LOGGER = Logger.getLogger(PlayGameController.class);
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
        LOGGER.info(MessageFormat.format("received request to generate next move for [fen position: {0}, sideToMove {1}, virtualPlayerLevel {2}.", chessPositionFen, sideToMove, virtualPlayerLevel));
        PlayerColorData sideToMoveEnum = PlayerColorData.valueOf(sideToMove);

        ChessMoveData chessMoveData = chessMoveFacade.getNextMove(chessPositionFen, sideToMoveEnum, Integer.parseInt(virtualPlayerLevel));
        System.out.println("move:"+chessMoveData.getInitialPosition().getX()+""+chessMoveData.getInitialPosition().getY()
        +"final: "+chessMoveData.getFinalPosition().getX()+""+chessMoveData.getFinalPosition().getY());
        return chessMoveFacade.getNextMove(chessPositionFen, sideToMoveEnum, Integer.parseInt(virtualPlayerLevel));
    }
}
