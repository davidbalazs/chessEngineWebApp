package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.processor.BitBoardProcessor;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by David on 4/8/2016.
 */
public class LineSlidingPseudoLegalMovesGenerator {
    private BitBoardProcessor bitBoardProcessor;

    public long getWhiteAttaksBitboard(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.WHITE_ROOK.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteRooks();
        } else if (FriendlyPieceType.WHITE_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a sliding piece (rook or queen) for white. Provided piece is:" + movedPiece);
        }
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long opponentBitboard = bitBoardProcessor.getBlackPiecesBitboard(chessPosition) | chessPosition.getBlackKing();

        return getAttacksBitboard(movedPieceBitboard, occupiedBitboard, opponentBitboard);
    }

    public long getBlackAttaksBitboard(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.BLACK_ROOK.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackRooks();
        } else if (FriendlyPieceType.BLACK_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a sliding piece (rook or queen) for black. Provided piece is:" + movedPiece);
        }
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long opponentBitboard = bitBoardProcessor.getWhitePiecesBitboard(chessPosition) | chessPosition.getWhiteKing();

        return getAttacksBitboard(movedPieceBitboard, occupiedBitboard, opponentBitboard);
    }

    private long getAttacksBitboard(long movedPieceBitboard, long occupiedBitboard, long opponentBitboard) {
        long attacksBitboard = 0;
        for (int i = 0; i < 64; i++) {
            if (((movedPieceBitboard >> i) & 1L) == 1) {
                long possibleMovesBitboardToRight = generatePseudoLegalMovesBitboardToRight(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToLeft = generatePseudoLegalMovesBitboardToLeft(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToTop = generatePseudoLegalMovesBitboardToTop(i, occupiedBitboard, opponentBitboard);
                long possibleMovesBitboardToBottom = generatePseudoLegalMovesBitboardToBottom(i, occupiedBitboard, opponentBitboard);

                long singlePiecePseudoLegalMovesBitboard = possibleMovesBitboardToRight | possibleMovesBitboardToLeft | possibleMovesBitboardToTop | possibleMovesBitboardToBottom;
                attacksBitboard = attacksBitboard | singlePiecePseudoLegalMovesBitboard;
            }
        }
        return attacksBitboard;
    }

    private long generatePseudoLegalMovesBitboardToRight(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToRight = BitboardConstants.lineSlidingRight[i] & occupiedBitboard;
        possibleMovesToRight = possibleMovesToRight << 1 | possibleMovesToRight << 2 | possibleMovesToRight << 3 | possibleMovesToRight << 4 | possibleMovesToRight << 5 | possibleMovesToRight << 6;
        return getBitboardFromNumber(possibleMovesToRight, BitboardConstants.lineSlidingRight[i], opponentBitboard, occupiedBitboard);

    }

    private long generatePseudoLegalMovesBitboardToLeft(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToLeft = BitboardConstants.lineSlidingLeft[i] & occupiedBitboard;
        possibleMovesToLeft = possibleMovesToLeft >> 1 | possibleMovesToLeft >> 2 | possibleMovesToLeft >> 3 | possibleMovesToLeft >> 4 | possibleMovesToLeft >> 5 | possibleMovesToLeft >> 6;
        return getBitboardFromNumber(possibleMovesToLeft, BitboardConstants.lineSlidingLeft[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePseudoLegalMovesBitboardToTop(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToTop = BitboardConstants.lineSlidingUp[i] & occupiedBitboard;
        possibleMovesToTop = possibleMovesToTop << 8 | possibleMovesToTop << 16 | possibleMovesToTop << 24 | possibleMovesToTop << 32 | possibleMovesToTop << 40 | possibleMovesToTop << 48;
        return getBitboardFromNumber(possibleMovesToTop, BitboardConstants.lineSlidingUp[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePseudoLegalMovesBitboardToBottom(int i, long occupiedBitboard, long opponentBitboard) {
        long possibleMovesToBottom = BitboardConstants.lineSlidingDown[i] & occupiedBitboard;
        possibleMovesToBottom = possibleMovesToBottom >> 8 | possibleMovesToBottom >> 16 | possibleMovesToBottom >> 24 | possibleMovesToBottom >> 32 | possibleMovesToBottom >> 40 | possibleMovesToBottom >> 48;
        return getBitboardFromNumber(possibleMovesToBottom, BitboardConstants.lineSlidingDown[i], opponentBitboard, occupiedBitboard);
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
