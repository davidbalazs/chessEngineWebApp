package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.processor.BitBoardProcessor;
import com.davidbalazs.chess.pseudolegalmoves.PseudoLegalMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class KnightPseudoLegalMovesGenerator implements PseudoLegalMovesGenerator {
    private BitBoardProcessor bitBoardProcessor;

    @Override
    public long getWhiteAttaksBitboard(ChessPosition chessPosition) {
        return getAttaksBitboard(chessPosition.getWhiteKnights());
    }

    @Override
    public long getBlackAttaksBitboard(ChessPosition chessPosition) {
        return getAttaksBitboard(chessPosition.getBlackKnights());
    }

    private long getAttaksBitboard(long knightBitboard) {
        long seeKnightMoves = (knightBitboard >> 6) & ~BitboardConstants.FILE_A & ~BitboardConstants.FILE_B;
        long sseKnightMoves = (knightBitboard >> 15) & ~BitboardConstants.FILE_A;
        long sswKnightMoves = (knightBitboard >> 17) & ~BitboardConstants.FILE_H;
        long swwKnightMoves = (knightBitboard >> 10) & ~BitboardConstants.FILE_H & ~BitboardConstants.FILE_G;
        long nwwKnightMoves = (knightBitboard << 6) & ~BitboardConstants.FILE_H & ~BitboardConstants.FILE_G;
        long nnwKnightMoves = (knightBitboard << 15) & ~BitboardConstants.FILE_H;
        long nneKnightMoves = (knightBitboard << 17) & ~BitboardConstants.FILE_A;
        long neeKnightMoves = (knightBitboard << 10) & ~BitboardConstants.FILE_A & ~BitboardConstants.FILE_B;

        return seeKnightMoves | sseKnightMoves | sswKnightMoves | swwKnightMoves | nwwKnightMoves | nnwKnightMoves | nneKnightMoves | neeKnightMoves;
    }

    @Required
    public void setBitBoardProcessor(BitBoardProcessor bitBoardProcessor) {
        this.bitBoardProcessor = bitBoardProcessor;
    }
}
