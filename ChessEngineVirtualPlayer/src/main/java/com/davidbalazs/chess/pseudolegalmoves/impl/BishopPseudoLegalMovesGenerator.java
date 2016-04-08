package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.pseudolegalmoves.PseudoLegalMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

/**
 * Created by David on 4/8/2016.
 */
public class BishopPseudoLegalMovesGenerator implements PseudoLegalMovesGenerator {
    private DiagonalSlidingPseudoLegalMovesGenerator diagonalSlidingPseudoLegalMovesGenerator;

    @Override
    public long getWhiteAttaksBitboard(ChessPosition chessPosition) {
        return diagonalSlidingPseudoLegalMovesGenerator.getWhiteAttaksBitboard(chessPosition, FriendlyPieceType.WHITE_BISHOP);
    }

    @Override
    public long getBlackAttaksBitboard(ChessPosition chessPosition) {
        return diagonalSlidingPseudoLegalMovesGenerator.getBlackAttaksBitboard(chessPosition, FriendlyPieceType.BLACK_BISHOP);
    }

    @Required
    public void setDiagonalSlidingPseudoLegalMovesGenerator(DiagonalSlidingPseudoLegalMovesGenerator diagonalSlidingPseudoLegalMovesGenerator) {
        this.diagonalSlidingPseudoLegalMovesGenerator = diagonalSlidingPseudoLegalMovesGenerator;
    }
}
