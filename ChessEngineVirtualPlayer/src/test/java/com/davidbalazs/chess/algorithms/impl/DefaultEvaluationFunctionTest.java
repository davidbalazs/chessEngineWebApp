package com.davidbalazs.chess.algorithms.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPiecePosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.services.impl.DefaultFriendlyChessBoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:virtualPlayerApplicationContext.xml"})
public class DefaultEvaluationFunctionTest {

    @Resource(name = "defaultEvaluationFunction")
    private DefaultEvaluationFunction evaluationFunction;

    @Resource(name = "friendlyChessBoardService")
    private DefaultFriendlyChessBoardService friendlyChessBoardService;

    @Test
    public void compareMaterialAdvantageTest() {
        ChessPosition weakChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition1());
        long weakPositionEvaluation = evaluationFunction.evaluate(weakChessPosition);

        ChessPosition goodChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition2());
        long goodPositionEvaluation = evaluationFunction.evaluate(goodChessPosition);
        assertTrue(weakPositionEvaluation < goodPositionEvaluation);
        System.out.println("weak2: " + weakPositionEvaluation + " good: " + goodPositionEvaluation);
    }


    @Test
    public void compareMaterialAdvantageTest2() {
        ChessPosition weakChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition4());
        long weakPositionEvaluation = evaluationFunction.evaluate(weakChessPosition);

        ChessPosition goodChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition2());
        long goodPositionEvaluation = evaluationFunction.evaluate(goodChessPosition);
        assertTrue(weakPositionEvaluation < goodPositionEvaluation);
        System.out.println("weak: " + weakPositionEvaluation + " good: " + goodPositionEvaluation);
    }

    @Test
    public void compareMaterialAdvantageBalancerTest() {
        ChessPosition whiteChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition2());
        long weakPositionEvaluation = evaluationFunction.evaluate(whiteChessPosition);

        ChessPosition blackChessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition3());
        long goodPositionEvaluation = evaluationFunction.evaluate(blackChessPosition);
        assertEquals(weakPositionEvaluation, 0 - goodPositionEvaluation);
    }

    private List<FriendlyPiecePosition> getDummyChessPosition1() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 3, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 0, 0));
    }

    private List<FriendlyPiecePosition> getDummyChessPosition2() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 3, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_QUEEN, 0, 0));
    }

    private List<FriendlyPiecePosition> getDummyChessPosition3() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 3, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, 0, 0));
    }

    private List<FriendlyPiecePosition> getDummyChessPosition4() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 0, 7),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 3, 3),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 3, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 0, 0));
    }
}
