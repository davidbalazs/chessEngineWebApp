package com.davidbalazs.chess.dummydata;

import com.davidbalazs.chess.models.ChessProblemDifficultyLevel;
import com.davidbalazs.chess.models.ChessProblemModel;

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
}
