package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.pseudolegalmoves.PseudoLegalMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by David on 4/8/2016.
 */
public class QueenPseudoLegalMovesGenerator implements PseudoLegalMovesGenerator {
    private LineSlidingPseudoLegalMovesGenerator lineSlidingPseudoLegalMovesGenerator;
    private DiagonalSlidingPseudoLegalMovesGenerator diagonalSlidingPseudoLegalMovesGenerator;

    @Override
    public long getWhiteAttaksBitboard(ChessPosition chessPosition) {
        long lineAttacks = lineSlidingPseudoLegalMovesGenerator.getWhiteAttaksBitboard(chessPosition, FriendlyPieceType.WHITE_QUEEN);
        long diagonalAttaks = diagonalSlidingPseudoLegalMovesGenerator.getWhiteAttaksBitboard(chessPosition, FriendlyPieceType.WHITE_QUEEN);
        return lineAttacks | diagonalAttaks;
    }

    @Override
    public long getBlackAttaksBitboard(ChessPosition chessPosition) {
        long lineAttacks = lineSlidingPseudoLegalMovesGenerator.getBlackAttaksBitboard(chessPosition, FriendlyPieceType.BLACK_QUEEN);
        long diagonalAttaks = diagonalSlidingPseudoLegalMovesGenerator.getBlackAttaksBitboard(chessPosition, FriendlyPieceType.BLACK_QUEEN);
        return lineAttacks | diagonalAttaks;
    }

    @Required
    public void setDiagonalSlidingPseudoLegalMovesGenerator(DiagonalSlidingPseudoLegalMovesGenerator diagonalSlidingPseudoLegalMovesGenerator) {
        this.diagonalSlidingPseudoLegalMovesGenerator = diagonalSlidingPseudoLegalMovesGenerator;
    }

    @Required
    public void setLineSlidingPseudoLegalMovesGenerator(LineSlidingPseudoLegalMovesGenerator lineSlidingPseudoLegalMovesGenerator) {
        this.lineSlidingPseudoLegalMovesGenerator = lineSlidingPseudoLegalMovesGenerator;
    }
}
