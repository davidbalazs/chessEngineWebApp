package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.movegenerator.PossibleMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

import java.util.TreeSet;

/**
 * Created by David on 4/8/2016.
 */
public class BishopPossibleMovesGenerator implements PossibleMovesGenerator {
    private DiagonalSlidingPiecePossibleMovesGenerator diagonalSlidingPiecePossibleMovesGenerator;

    @Override
    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition) {
        return diagonalSlidingPiecePossibleMovesGenerator.generateWhiteMoves(chessPosition, FriendlyPieceType.WHITE_BISHOP);
    }

    @Override
    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition) {
        return diagonalSlidingPiecePossibleMovesGenerator.generateBlackMoves(chessPosition, FriendlyPieceType.BLACK_BISHOP);
    }

    @Required
    public void setDiagonalSlidingPiecePossibleMovesGenerator(DiagonalSlidingPiecePossibleMovesGenerator diagonalSlidingPiecePossibleMovesGenerator) {
        this.diagonalSlidingPiecePossibleMovesGenerator = diagonalSlidingPiecePossibleMovesGenerator;
    }
}
