package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.pseudolegalmoves.PseudoLegalMovesGenerator;

/**
 * Created by David on 3/31/2016.
 */
public class PawnPseudoLegalMovesGenerator implements PseudoLegalMovesGenerator {
    @Override
    public long getWhiteAttaksBitboard(ChessPosition chessPosition) {
        long whitePawnBitboard = chessPosition.getWhitePawns();
        long pawnCaptureLeft = (whitePawnBitboard << 7) & ~BitboardConstants.FILE_H;
        long pawnCaptureRight = (whitePawnBitboard << 9) & ~BitboardConstants.FILE_A;

        return pawnCaptureLeft | pawnCaptureRight;
    }

    @Override
    public long getBlackAttaksBitboard(ChessPosition chessPosition) {
        long blackPawnBitboard = chessPosition.getBlackPawns();
        long pawnCaptureLeft = (blackPawnBitboard >> 9) & ~BitboardConstants.FILE_H;
        long pawnCaptureRight = (blackPawnBitboard >> 7) & ~BitboardConstants.FILE_A;

        return pawnCaptureLeft | pawnCaptureRight;
    }
}
