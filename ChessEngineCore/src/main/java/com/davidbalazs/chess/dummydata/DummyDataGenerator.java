package com.davidbalazs.chess.dummydata;

import com.davidbalazs.chess.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DummyDataGenerator {

    public List<ChessProblemModel> generateChessProblems() {
        List<ChessProblemModel> chessProblems = new ArrayList<>();

        ChessProblemModel chessProblem = new ChessProblemModel();
        chessProblem.setDifficultyLevel(ChessProblemDifficultyLevel.EASY);
        chessProblem.setName("First chess problem");
        chessProblem.setDescription("Make one move for check mate.");
        chessProblem.setInitialPositionFen("r1bqkbnr/ppQQ1ppp/2n5/1B2p3/4P3/5R2/PPPP1PPP/RNBQK2R");

        ChessProblemModel chessProblem2 = new ChessProblemModel();
        chessProblem2.setDifficultyLevel(ChessProblemDifficultyLevel.HARD);
        chessProblem2.setName("Second chess problem");
        chessProblem2.setDescription("Make one move for check mate.");
        chessProblem2.setInitialPositionFen("r1bqkbnr/ppQQ4/8/8/4P3/5R2/8/RNBQK2R");

        chessProblems.add(chessProblem);
        chessProblems.add(chessProblem2);

        return chessProblems;
    }

    public ChessStrategyModel generateChessStrategy() {
        ChessMoveModel blackChessMoveModel3 = new ChessMoveModel();
        blackChessMoveModel3.setFenPosition("rnbqk2r/ppp1bppp/4pn2/3p2B1/2PP4/5N2/PP2PPPP/RN1QKB1R");
        blackChessMoveModel3.setMoveThatWasMade("Be7");
        ChessStrategyMoveModel blackMove3 = new ChessStrategyMoveModel();
        blackMove3.setMove(blackChessMoveModel3);

        ChessMoveModel whiteChessMoveModel3 = new ChessMoveModel();
        whiteChessMoveModel3.setFenPosition("rnbqkb1r/ppp2ppp/4pn2/3p2B1/2PP4/5N2/PP2PPPP/RN1QKB1R");
        whiteChessMoveModel3.setMoveThatWasMade("Bg5");
        ChessStrategyMoveModel whiteMove3 = new ChessStrategyMoveModel();
        whiteMove3.setMove(whiteChessMoveModel3);

        ChessStrategyMovePairModel chessStrategyMovePairModel3 = new ChessStrategyMovePairModel();
        chessStrategyMovePairModel3.setWhiteMove(whiteMove3);
        chessStrategyMovePairModel3.setBlackMove(blackMove3);


        ChessMoveModel blackChessMoveModel2 = new ChessMoveModel();
        blackChessMoveModel2.setFenPosition("rnbqkb1r/ppp2ppp/4pn2/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R");
        blackChessMoveModel2.setMoveThatWasMade("e6");
        ChessStrategyMoveModel blackMove2 = new ChessStrategyMoveModel();
        blackMove2.setMove(blackChessMoveModel2);

        ChessMoveModel whiteChessMoveModel2 = new ChessMoveModel();
        whiteChessMoveModel2.setFenPosition("rnbqkb1r/ppp1pppp/5n2/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R");
        whiteChessMoveModel2.setMoveThatWasMade("c4");
        ChessStrategyMoveModel whiteMove2 = new ChessStrategyMoveModel();
        whiteMove2.setMove(whiteChessMoveModel2);

        ChessStrategyMovePairModel chessStrategyMovePairModel2 = new ChessStrategyMovePairModel();
        chessStrategyMovePairModel2.setWhiteMove(whiteMove2);
        chessStrategyMovePairModel2.setBlackMove(blackMove2);

        ChessMoveModel blackChessMoveModel1 = new ChessMoveModel();
        blackChessMoveModel1.setFenPosition("rnbqkb1r/ppp1pppp/5n2/3p4/3P4/5N2/PPP1PPPP/RNBQKB1R");
        blackChessMoveModel1.setMoveThatWasMade("Nf6");
        ChessStrategyMoveModel blackMove1 = new ChessStrategyMoveModel();
        blackMove1.setMove(blackChessMoveModel1);

        ChessMoveModel whiteChessMoveModel1 = new ChessMoveModel();
        whiteChessMoveModel1.setFenPosition("rnbqkbnr/ppp1pppp/8/3p4/3P4/5N2/PPP1PPPP/RNBQKB1R");
        whiteChessMoveModel1.setMoveThatWasMade("Nf3");
        ChessStrategyMoveModel whiteMove1 = new ChessStrategyMoveModel();
        whiteMove1.setMove(whiteChessMoveModel1);

        ChessStrategyMovePairModel chessStrategyMovePairModel1 = new ChessStrategyMovePairModel();
        chessStrategyMovePairModel1.setWhiteMove(whiteMove1);
        chessStrategyMovePairModel1.setBlackMove(blackMove1);

        ChessMoveModel blackChessMoveModel = new ChessMoveModel();
        blackChessMoveModel.setFenPosition("rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR");
        blackChessMoveModel.setMoveThatWasMade("d5");
        ChessStrategyMoveModel blackMove = new ChessStrategyMoveModel();
        blackMove.setMove(blackChessMoveModel);

        ChessMoveModel whiteChessMoveModel = new ChessMoveModel();
        whiteChessMoveModel.setFenPosition("rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR");
        whiteChessMoveModel.setMoveThatWasMade("d4");
        ChessStrategyMoveModel whiteMove = new ChessStrategyMoveModel();
        whiteMove.setMove(whiteChessMoveModel);

        ChessStrategyMovePairModel chessStrategyMovePairModel = new ChessStrategyMovePairModel();
        chessStrategyMovePairModel.setWhiteMove(whiteMove);
        chessStrategyMovePairModel.setBlackMove(blackMove);

        List<ChessStrategyMovePairModel> chessStrategyMovePairs = new ArrayList<>();
        chessStrategyMovePairs.add(chessStrategyMovePairModel);
        chessStrategyMovePairs.add(chessStrategyMovePairModel1);
        chessStrategyMovePairs.add(chessStrategyMovePairModel2);
        chessStrategyMovePairs.add(chessStrategyMovePairModel3);

        ChessStrategyModel chessStrategyModel = new ChessStrategyModel();
        chessStrategyModel.setName("Sicilian defense");
        chessStrategyModel.setCategory(ChessStrategyCategory.OPENING);
        chessStrategyModel.setMovePairs(chessStrategyMovePairs);

        return chessStrategyModel;
    }
}
