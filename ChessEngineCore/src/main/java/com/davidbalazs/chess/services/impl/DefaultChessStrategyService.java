package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.ChessStrategyDao;
import com.davidbalazs.chess.models.*;
import com.davidbalazs.chess.services.ChessStrategyService;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessStrategyService implements ChessStrategyService {
    private ChessStrategyDao chessStrategyDao;

    @Override
    @Transactional
    public List<ChessStrategyModel> getChessStrategies() {
        System.out.println("DELETE THE LINE BELLOW in code");
        chessStrategyDao.create(generateChessStrategyModel());
        return chessStrategyDao.getAll();
    }

    private ChessStrategyModel generateChessStrategyModel() {
        ChessStrategyModel chessStrategyModel = new ChessStrategyModel();
        chessStrategyModel.setCategory(ChessStrategyCategory.OPENING);
        chessStrategyModel.setName("My custom opening");
        ChessMoveModel move1 = new ChessMoveModel();
        move1.setFenPosition("rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR");
        move1.setMoveThatWasMade("d4");

        ChessMoveModel move2 = new ChessMoveModel();
        move2.setFenPosition("rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR");
        move2.setMoveThatWasMade("d5");

        ChessStrategyMoveModel chessStrategyMove1 = new ChessStrategyMoveModel();
        chessStrategyMove1.setDescription("bla bla 1");
        chessStrategyMove1.setMove(move1);

        ChessStrategyMoveModel chessStrategyMove2 = new ChessStrategyMoveModel();
        chessStrategyMove2.setDescription("bla bla 2");
        chessStrategyMove2.setMove(move2);

        ChessStrategyMovePairModel chessStrategyMovePairModel = new ChessStrategyMovePairModel();
        chessStrategyMovePairModel.setWhiteMove(chessStrategyMove1);
        chessStrategyMovePairModel.setBlackMove(chessStrategyMove2);

        List<ChessStrategyMovePairModel> movePairs = new ArrayList<>();
        movePairs.add(chessStrategyMovePairModel);

        chessStrategyModel.setMovePairs(movePairs);

        return chessStrategyModel;
    }

    @Override
    public ChessStrategyModel getById(long id) {
        return chessStrategyDao.getById(id);
    }

    @Required
    public void setChessStrategyDao(ChessStrategyDao chessStrategyDao) {
        this.chessStrategyDao = chessStrategyDao;
    }
}
