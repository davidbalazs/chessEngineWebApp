package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayGameForm;
import com.davidbalazs.chess.data.PlayerColorData;
import com.davidbalazs.chess.data.VirtualPlayerLevelData;
import com.davidbalazs.chess.facades.ChessMoveFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.MessageFormat;

@Controller
@RequestMapping(value = "playgame/")
public class PlayGameController {
    public static final Logger LOGGER = Logger.getLogger(PlayGameController.class);
    private static final String RECEIVED_REQUEST_LOG_MESSAGE = "received request to generate next move for [fen position: {0}, sideToMove {1}, virtualPlayerLevel {2}.";
    private static final String START_GAME_LOG_MESSAGE = "Received request to start game with virtualPlayerLevel={0} and playerColor={1}";
    private static final String GET_PLAY_GAME_FORM_LOG_MESSAGE = "Received request to retrieve playGameForm.";
    @Resource(name = "chessMoveFacade")
    private ChessMoveFacade chessMoveFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String playGame(Model model) {
        LOGGER.info(GET_PLAY_GAME_FORM_LOG_MESSAGE);
        PlayGameForm playGameForm = new PlayGameForm();
        model.addAttribute("playGameForm", playGameForm);
        model.addAttribute("possibleVirtualPlayerLevels", VirtualPlayerLevelData.values());
        model.addAttribute("possiblePlayerColorValues", PlayerColorData.values());

        return "pages/playGameFormPage";
    }

    @RequestMapping(value = "start-game", method = RequestMethod.POST)
    public String startGame(Model model, @ModelAttribute("playGameForm") PlayGameForm playGameForm) {
        LOGGER.info(MessageFormat.format(START_GAME_LOG_MESSAGE, playGameForm.getVirtualPlayerLevel(), playGameForm.getPlayerColor()));
        //try to add match entry in db. If it fails, log an error message, but let player play the game without saving it.
        return "pages/playGamePage";
    }

    @RequestMapping(value = "next-move", method = RequestMethod.GET)
    @ResponseBody
    public ChessMoveData generateNextMove(@RequestParam("chessPositionFen") String chessPositionFen,
                                          @RequestParam("sideToMove") String sideToMove,
                                          @RequestParam("virtualPlayerLevel") String virtualPlayerLevel) {
        LOGGER.info(MessageFormat.format(RECEIVED_REQUEST_LOG_MESSAGE, chessPositionFen, sideToMove, virtualPlayerLevel));

        PlayerColorData sideToMoveEnum = PlayerColorData.valueOf(sideToMove);

        ChessMoveData chessMoveData = chessMoveFacade.getNextMove(chessPositionFen, sideToMoveEnum, Integer.parseInt(virtualPlayerLevel));
        LOGGER.info("move:" + chessMoveData.getInitialPosition().getX() + "" + chessMoveData.getInitialPosition().getY()
                + "final: " + chessMoveData.getFinalPosition().getX() + "" + chessMoveData.getFinalPosition().getY());
        return chessMoveData;
    }
}
