package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.processor.BitBoardProcessor;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by David on 4/8/2016.
 */
public class DiagonalSlidingPseudoLegalMovesGenerator {
    private BitBoardProcessor bitBoardProcessor;

    public long getWhiteAttaksBitboard(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.WHITE_BISHOP.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteBishops();
        } else if (FriendlyPieceType.WHITE_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a diagonal sliding piece (bishop or queen) for white. Provided piece is:" + movedPiece);
        }

        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long opponentBitboard = bitBoardProcessor.getBlackPiecesBitboard(chessPosition) | chessPosition.getBlackKing();

        return getAttacksBitboard(movedPieceBitboard, occupiedBitboard, opponentBitboard);
    }

    public long getBlackAttaksBitboard(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.BLACK_BISHOP.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackBishops();
        } else if (FriendlyPieceType.BLACK_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a diagonal sliding piece (bishop or queen) for black. Provided piece is:" + movedPiece);
        }

        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long opponentBitboard = bitBoardProcessor.getWhitePiecesBitboard(chessPosition) | chessPosition.getWhiteKing();

        return getAttacksBitboard(movedPieceBitboard, occupiedBitboard, opponentBitboard);
    }


    private long getAttacksBitboard(long movedPieceBitboard, long occupiedBitboard, long opponentBitboard) {
        long attacksBitboard = 0;
        for (int i = 0; i < 64; i++) {
            if (((movedPieceBitboard >> i) & 1L) == 1) {
                long possibleMovesBitboardToUpRight = generatePossibleMovesBitboardToUpRight(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToUpLeft = generatePossibleMovesBitboardToUpLeft(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToDownRight = generatePossibleMovesBitboardToDownRight(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToDownLeft = generatePossibleMovesBitboardToDownLeft(i, occupiedBitboard, opponentBitboard);

                long singlePiecePseudoLegalMovesBitboard = possibleMovesBitboardToUpRight | possibleMovesBitboardToUpLeft | possibleMovesBitboardToDownRight | possibleMovesBitboardToDownLeft;
                attacksBitboard = attacksBitboard | singlePiecePseudoLegalMovesBitboard;
            }
        }

        return attacksBitboard;
    }

    private long generatePossibleMovesBitboardToUpRight(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToUpRight = BitboardConstants.diagonalSlidingUpRight[i] & occupiedBitboard;
        possibleMovesToUpRight = possibleMovesToUpRight << 9 | possibleMovesToUpRight << 18 | possibleMovesToUpRight << 27 |
                possibleMovesToUpRight << 36 | possibleMovesToUpRight << 45 | possibleMovesToUpRight << 54;
        return getBitboardFromNumber(possibleMovesToUpRight, BitboardConstants.diagonalSlidingUpRight[i], opponentBitboard, occupiedBitboard);

    }

    private long generatePossibleMovesBitboardToUpLeft(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToUpLeft = BitboardConstants.diagonalSlidingUpLeft[i] & occupiedBitboard;
        possibleMovesToUpLeft = possibleMovesToUpLeft << 7 | possibleMovesToUpLeft << 14 | possibleMovesToUpLeft << 21 |
                possibleMovesToUpLeft << 28 | possibleMovesToUpLeft << 35 | possibleMovesToUpLeft << 42;
        return getBitboardFromNumber(possibleMovesToUpLeft, BitboardConstants.diagonalSlidingUpLeft[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToDownRight(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToDownRight = BitboardConstants.diagonalSlidingDownRight[i] & occupiedBitboard;
        possibleMovesToDownRight = possibleMovesToDownRight >> 7 | possibleMovesToDownRight >> 14 | possibleMovesToDownRight >> 21 |
                possibleMovesToDownRight >> 28 | possibleMovesToDownRight >> 35 | possibleMovesToDownRight >> 42;
        return getBitboardFromNumber(possibleMovesToDownRight, BitboardConstants.diagonalSlidingDownRight[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToDownLeft(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToDownLeft = BitboardConstants.diagonalSlidingDownLeft[i] & occupiedBitboard;
        possibleMovesToDownLeft = possibleMovesToDownLeft >> 9 | possibleMovesToDownLeft >> 18 | possibleMovesToDownLeft >> 27 |
                possibleMovesToDownLeft >> 36 | possibleMovesToDownLeft >> 45 | possibleMovesToDownLeft >> 54;
        return getBitboardFromNumber(possibleMovesToDownLeft, BitboardConstants.diagonalSlidingDownLeft[i], opponentBitboard, occupiedBitboard);
    }


    private long getBitboardFromNumber(long bitboardNumber, long precomputedBitboard, long opponentBitboard, long occupiedBitboard) {
        bitboardNumber = bitboardNumber & precomputedBitboard;
        bitboardNumber = bitboardNumber ^ precomputedBitboard;
        return bitboardNumber;
    }

    @Required
    public void setBitBoardProcessor(BitBoardProcessor bitBoardProcessor) {
        this.bitBoardProcessor = bitBoardProcessor;
    }
}
