package com.davidbalazs.chess.constants;

import com.davidbalazs.chess.model.FriendlyPiecePosition;
import com.davidbalazs.chess.model.FriendlyPieceType;

import java.util.Arrays;
import java.util.List;

/**
 * Created by David on 10/18/2015.
 */
public class DummyChessPositions {
    /**
     * = = = = = = = =
     * = = = = = = = =
     * = = = = = = = =
     * = = = = = = = =
     * = = = = = = = =
     * = = B = = = = =
     * p = = = = = = B
     * = = = = = = = =
     */
    public static List<FriendlyPiecePosition> dummyChessPosition1() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 0, 3)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 0, 0)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 6, 6));
    }

    public static List<FriendlyPiecePosition> dummyChessPosition2() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 0, 2),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 1, 4),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 2, 4));
    }

    public static List<FriendlyPiecePosition> dummyChessPosition3() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 6, 3), new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 2, 1)
                , new FriendlyPiecePosition(FriendlyPieceType.WHITE_QUEEN, 7, 7), new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 4, 6));
    }

    public static List<FriendlyPiecePosition> dummyChessPosition4() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 4, 4),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 1, 1));
    }

    public static List<FriendlyPiecePosition> dummyChessPosition5() {
        return Arrays.asList(new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 7, 7), new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, 0, 1));
    }
}
