package com.davidbalazs.chess.service.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPiecePosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.model.PiecePosition;
import com.davidbalazs.chess.service.MoveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:virtualPlayerApplicationContext.xml"})
public class DefaultFriendlyChessBoardServiceTest {
    @Resource(name = "friendlyChessBoardService")
    private DefaultFriendlyChessBoardService friendlyChessBoardService;

    @Resource(name = "moveService")
    private MoveService moveService;

    @Test
    public void test() {
        ChessPosition chessPosition = friendlyChessBoardService.initializeChessBoard(getDummyChessPosition5());
        int move = moveService.createMove(FriendlyPieceType.WHITE_PAWN, new PiecePosition(0, 1), new PiecePosition(1, 2),
                false, false, null, FriendlyPieceType.BLACK_ROOK, null, false, false);

        ChessPosition chessPositionAfterMove = friendlyChessBoardService.applyMove(chessPosition, move);

        friendlyChessBoardService.displayChessBoard(chessPosition);
        friendlyChessBoardService.displayChessBoard(chessPositionAfterMove);
    }

    private List<FriendlyPiecePosition> getDummyChessPosition1() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 3, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, 0, 0));
    }

    private List<FriendlyPiecePosition> getDummyChessPosition5() {
        return Arrays.asList(
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 0, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 1, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 2, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 3, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 4, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 5, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 6, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 7, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 1, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 6, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_BISHOP, 2, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_BISHOP, 5, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 0, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 7, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_QUEEN, 3, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 4, 0),

                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 0, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 1, 2),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 2, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 3, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 4, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 5, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 6, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 7, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KNIGHT, 1, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KNIGHT, 6, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_BISHOP, 2, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_BISHOP, 5, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 0, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 7, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, 3, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 4, 7));
    }

}
