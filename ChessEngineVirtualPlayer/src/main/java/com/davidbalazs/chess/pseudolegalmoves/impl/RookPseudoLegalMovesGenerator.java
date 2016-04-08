package com.davidbalazs.chess.pseudolegalmoves.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.pseudolegalmoves.PseudoLegalMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class RookPseudoLegalMovesGenerator implements PseudoLegalMovesGenerator {
    private LineSlidingPseudoLegalMovesGenerator lineSlidingPseudoLegalMovesGenerator;

    @Override
    public long getWhiteAttaksBitboard(ChessPosition chessPosition) {
        return lineSlidingPseudoLegalMovesGenerator.getWhiteAttaksBitboard(chessPosition, FriendlyPieceType.WHITE_ROOK);
    }

    @Override
    public long getBlackAttaksBitboard(ChessPosition chessPosition) {
        return lineSlidingPseudoLegalMovesGenerator.getBlackAttaksBitboard(chessPosition, FriendlyPieceType.BLACK_ROOK);
    }

    @Required
    public void setLineSlidingPseudoLegalMovesGenerator(LineSlidingPseudoLegalMovesGenerator lineSlidingPseudoLegalMovesGenerator) {
        this.lineSlidingPseudoLegalMovesGenerator = lineSlidingPseudoLegalMovesGenerator;
    }
}
