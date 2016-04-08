package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.movegenerator.PossibleMovesGenerator;
import org.springframework.beans.factory.annotation.Required;

import java.util.TreeSet;

/**
 * Created by David on 4/8/2016.
 */
public class QueenPossibleMovesGenerator implements PossibleMovesGenerator {
    private LineSlidingPiecePossibleMovesGenerator lineSlidingPiecePossibleMovesGenerator;
    private DiagonalSlidingPiecePossibleMovesGenerator diagonalSlidingPiecePossibleMovesGenerator;

    @Override
    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition) {
        TreeSet<Integer> possibleMoves = lineSlidingPiecePossibleMovesGenerator.generateWhiteMoves(chessPosition, FriendlyPieceType.WHITE_QUEEN);
        possibleMoves.addAll(diagonalSlidingPiecePossibleMovesGenerator.generateWhiteMoves(chessPosition, FriendlyPieceType.WHITE_QUEEN));

        return possibleMoves;
    }

    @Override
    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition) {
        TreeSet<Integer> possibleMoves = lineSlidingPiecePossibleMovesGenerator.generateBlackMoves(chessPosition, FriendlyPieceType.BLACK_QUEEN);
        possibleMoves.addAll(diagonalSlidingPiecePossibleMovesGenerator.generateBlackMoves(chessPosition, FriendlyPieceType.BLACK_QUEEN));

        return possibleMoves;
    }

    @Required
    public void setDiagonalSlidingPiecePossibleMovesGenerator(DiagonalSlidingPiecePossibleMovesGenerator diagonalSlidingPiecePossibleMovesGenerator) {
        this.diagonalSlidingPiecePossibleMovesGenerator = diagonalSlidingPiecePossibleMovesGenerator;
    }

    @Required
    public void setLineSlidingPiecePossibleMovesGenerator(LineSlidingPiecePossibleMovesGenerator lineSlidingPiecePossibleMovesGenerator) {
        this.lineSlidingPiecePossibleMovesGenerator = lineSlidingPiecePossibleMovesGenerator;
    }
}
