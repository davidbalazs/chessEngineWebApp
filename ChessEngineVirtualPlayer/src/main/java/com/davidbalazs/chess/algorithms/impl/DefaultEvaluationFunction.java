package com.davidbalazs.chess.algorithms.impl;

import com.davidbalazs.chess.algorithms.EvaluationFunction;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPiecePosition;
import com.davidbalazs.chess.model.FriendlyPieceType;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultEvaluationFunction implements EvaluationFunction {

    private static final int PAWN_MATERIAL_VALUE = 70;
    private static final int KNIGHT_MATERIAL_VALUE = 90;
    private static final int BISHOP_MATERIAL_VALUE = 100;
    private static final int ROOK_MATERIAL_VALUE = 150;
    private static final int QUEEN_MATERIAL_VALUE = 300;
    private static final int[] KNIGHT_BEST_POSITIONS_MASK = {
            -50, -40, -30, -30, -30, -30, -40, -50,
            -40, -20, 0, 0, 0, 0, -20, -40,
            -30, 0, 10, 15, 15, 10, 0, -30,
            -30, 5, 15, 20, 20, 15, 5, -30,
            -30, 0, 15, 20, 20, 15, 0, -30,
            -30, 5, 10, 15, 15, 10, 5, -30,
            -40, -20, 0, 5, 5, 0, -20, -40,
            -50, -40, -30, -30, -30, -30, -40, -50
    };

    private static final int[] WHITE_PAWN_BEST_POSITIONS_MASK = {
            0, 0, 0, 0, 0, 0, 0, 0,
            50, 50, 50, 50, 50, 50, 50, 50,
            10, 10, 20, 30, 30, 20, 10, 10,
            5, 5, 10, 25, 25, 10, 5, 5,
            0, 0, 0, 20, 20, 0, 0, 0,
            5, -5, -10, 0, 0, -10, -5, 5,
            5, 10, 10, -20, -20, 10, 10, 5,
            0, 0, 0, 0, 0, 0, 0, 0
    };

    private static final int[] BLACK_PAWN_BEST_POSITIONS_MASK = {
            0, 0, 0, 0, 0, 0, 0, 0,
            5, 10, 10, -20, -20, 10, 10, 5,
            5, -5, -10, 0, 0, -10, -5, 5,
            0, 0, 0, 20, 20, 0, 0, 0,
            5, 5, 10, 25, 25, 10, 5, 5,
            10, 10, 20, 30, 30, 20, 10, 10,
            50, 50, 50, 50, 50, 50, 50, 50,
            0, 0, 0, 0, 0, 0, 0, 0
    };

    public long evaluate(ChessPosition chessPosition) {
        long materialAdvantage = computeMaterialAdvantage(chessPosition);
        long kingSafety = computeKingSafety(chessPosition);
        long kingPosition = evaluateKingPosition(chessPosition);
        long positionalEvaluation = evaluateWhitePositional(chessPosition) - evaluateBlackPositional(chessPosition);
        long distanceBetweenKingsEvaluation = evaluateDistancewBetweenKings(materialAdvantage, computeDistanceBetweenKings(chessPosition));
        return materialAdvantage + kingSafety + kingPosition + positionalEvaluation;
    }

    private long evaluateDistancewBetweenKings(long materialAdvantage, double distanceBetweenKings) {
        return 0;
    }

    private long computeMaterialAdvantage(ChessPosition chessPosition) {
        long materialAdvantage = 0;

        int numberOfWhitePawns = getNumberOfPiecesOnBitboard(chessPosition.getWhitePawns());
        int numberOfBlackPawns = getNumberOfPiecesOnBitboard(chessPosition.getBlackPawns());

        materialAdvantage += (numberOfWhitePawns - numberOfBlackPawns) * PAWN_MATERIAL_VALUE;

        int numberOfWhiteBishops = getNumberOfPiecesOnBitboard(chessPosition.getWhiteBishops());
        int numberOfBlackBishops = getNumberOfPiecesOnBitboard(chessPosition.getBlackBishops());

        materialAdvantage += (numberOfWhiteBishops - numberOfBlackBishops) * BISHOP_MATERIAL_VALUE;

        int numberOfWhiteKnights = getNumberOfPiecesOnBitboard(chessPosition.getWhiteKnights());
        int numberOfBlackKnights = getNumberOfPiecesOnBitboard(chessPosition.getBlackKnights());

        materialAdvantage += (numberOfWhiteKnights - numberOfBlackKnights) * KNIGHT_MATERIAL_VALUE;

        int numberOfWhiteRooks = getNumberOfPiecesOnBitboard(chessPosition.getWhiteRooks());
        int numberOfBlackRooks = getNumberOfPiecesOnBitboard(chessPosition.getBlackRooks());

        materialAdvantage += (numberOfWhiteRooks - numberOfBlackRooks) * ROOK_MATERIAL_VALUE;

        int numberOfWhiteQueens = getNumberOfPiecesOnBitboard(chessPosition.getWhiteQueens());
        int numberOfBlackQueens = getNumberOfPiecesOnBitboard(chessPosition.getBlackQueens());

        materialAdvantage += (numberOfWhiteQueens - numberOfBlackQueens) * QUEEN_MATERIAL_VALUE;

        return materialAdvantage;
    }

    private long evaluateWhitePositional(ChessPosition chessPosition) {
        long knightPositionEvaluation = evaluateBitboard(chessPosition.getWhiteKnights(), KNIGHT_BEST_POSITIONS_MASK);
        long pawnPositionEvaluation = evaluateBitboard(chessPosition.getWhitePawns(), WHITE_PAWN_BEST_POSITIONS_MASK);

        return knightPositionEvaluation + pawnPositionEvaluation;
    }

    private long evaluateBlackPositional(ChessPosition chessPosition) {
        long knightPositionEvaluation = evaluateBitboard(chessPosition.getBlackKnights(), KNIGHT_BEST_POSITIONS_MASK);
        long pawnPositionEvaluation = evaluateBitboard(chessPosition.getBlackPawns(), BLACK_PAWN_BEST_POSITIONS_MASK);

        return knightPositionEvaluation + pawnPositionEvaluation;
    }

    private long evaluateBitboard(long bitboard, int[] positionEvaluationMask) {
        if (bitboard == 0) {
            return 0;
        }

        long evaluationValue = 0;

        for (int i = 0; i < 64; i++) {
            if (((bitboard >> i) & 1L) == 1) {
                evaluationValue += positionEvaluationMask[i];
            }
        }
        return evaluationValue;
    }


    private int computeKingSafety(ChessPosition chessPosition) {
        return 0;
    }


    private int evaluateKingPosition(ChessPosition chessPosition) {
           /*
        king middle game
            -30,-40,-40,-50,-50,-40,-40,-30,
            -30,-40,-40,-50,-50,-40,-40,-30,
            -30,-40,-40,-50,-50,-40,-40,-30,
            -30,-40,-40,-50,-50,-40,-40,-30,
            -20,-30,-30,-40,-40,-30,-30,-20,
            -10,-20,-20,-20,-20,-20,-20,-10,
             20, 20,  0,  0,  0,  0, 20, 20,
             20, 30, 10,  0,  0, 10, 30, 20
        This is to make the king stand behind the pawn shelter.

        In the ending the values change.
        // king end game
            -50,-40,-30,-20,-20,-30,-40,-50,
            -30,-20,-10,  0,  0,-10,-20,-30,
            -30,-10, 20, 30, 30, 20,-10,-30,
            -30,-10, 30, 40, 40, 30,-10,-30,
            -30,-10, 30, 40, 40, 30,-10,-30,
            -30,-10, 20, 30, 30, 20,-10,-30,
            -30,-30,  0,  0,  0,  0,-30,-30,
            -50,-30,-30,-30,-30,-30,-30,-50
         */
        return 0;
    }

    private double computeDistanceBetweenKings(ChessPosition chessPosition) {
        int whiteKingPositionNumber = chessPosition.getWhiteKingPositionNumber();
        int blackKingPositionNumber = chessPosition.getBlackKingPositionNumber();
        FriendlyPiecePosition whiteKingPosition = new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, whiteKingPositionNumber % 8, whiteKingPositionNumber / 8);
        FriendlyPiecePosition blackKingPosition = new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, blackKingPositionNumber % 8, blackKingPositionNumber / 8);

        return Math.sqrt(Math.pow(whiteKingPosition.getCoordinateX() - blackKingPosition.getCoordinateX(), 2) +
                Math.pow(whiteKingPosition.getCoordinateY() - blackKingPosition.getCoordinateY(), 2));
    }

    private int getNumberOfPiecesOnBitboard(long bitboard) {
        int numberOfPiecesOnBitboard = 0;

        for (int i = 0; i < 64; i++) {
            if (((bitboard >> i) & 1L) == 1) {
                numberOfPiecesOnBitboard++;
            }
        }

        return numberOfPiecesOnBitboard;
    }

    //TODO: if white has material advantage on chess table, "remiza" is a mistake and should be evaluated with a negative score.
    //http://chessprogramming.wikispaces.com/Simplified+evaluation+function
    //number of pieces on each side
    //doubled pawns
    //knights position on table:
        /*
        // knight
            -50,-40,-30,-30,-30,-30,-40,-50,
            -40,-20,  0,  0,  0,  0,-20,-40,
            -30,  0, 10, 15, 15, 10,  0,-30,
            -30,  5, 15, 20, 20, 15,  5,-30,
            -30,  0, 15, 20, 20, 15,  0,-30,
            -30,  5, 10, 15, 15, 10,  5,-30,
            -40,-20,  0,  5,  5,  0,-20,-40,
            -50,-40,-30,-30,-30,-30,-40,-50,
         */
    //king:
}
