package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.movegenerator.PossibleMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

import java.util.TreeSet;

/**
 * Created by David on 11/1/2015.
 */
public class RookPossibleMovesGenerator implements PossibleMovesGenerator {
    private LineSlidingPiecePossibleMovesGenerator lineSlidingPiecePossibleMovesGenerator;

    @Override
    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition) {
        return lineSlidingPiecePossibleMovesGenerator.generateWhiteMoves(chessPosition, FriendlyPieceType.WHITE_ROOK);
    }

    @Override
    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition) {
        return lineSlidingPiecePossibleMovesGenerator.generateBlackMoves(chessPosition, FriendlyPieceType.BLACK_ROOK);
    }

    @Required
    public void setLineSlidingPiecePossibleMovesGenerator(LineSlidingPiecePossibleMovesGenerator lineSlidingPiecePossibleMovesGenerator) {
        this.lineSlidingPiecePossibleMovesGenerator = lineSlidingPiecePossibleMovesGenerator;
    }
}
