package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.ChessPosition;
import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.model.PiecePosition;
import com.davidbalazs.chess.model.Player;
import com.davidbalazs.chess.movegenerator.PossibleMovesGenerator;
import com.davidbalazs.chess.processor.BitBoardProcessor;
import com.davidbalazs.chess.service.FriendlyChessBoardService;
import com.davidbalazs.chess.service.KingService;
import com.davidbalazs.chess.service.MoveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.TreeSet;

/**
 * Generates moves for white pawns.
 * Created by David on 10/11/2015.
 */
public class PawnPossibleMovesGenerator implements PossibleMovesGenerator {
    //TODO: remaining cases: pawn promotion for white and black
    //TODO: check if king is in chess for white and black

    public static final Logger LOGGER = Logger.getLogger(PawnPossibleMovesGenerator.class);
    private BitBoardProcessor bitBoardProcessor;
    private MoveService moveService;
    private KingService kingService;
    private FriendlyChessBoardService chessBoardService;

    @Override
    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition) {
        TreeSet<Integer> possibleMoves = new TreeSet<Integer>(Collections.reverseOrder());

        long emptyPositionsBitboard = bitBoardProcessor.getEmptyPositions(chessPosition);
        long blackPiecesBitBoard = bitBoardProcessor.getBlackPiecesBitboard(chessPosition);
        long whitePawnBitboard = chessPosition.getWhitePawns();

        long pawnMove1Forward = (whitePawnBitboard << 8) & emptyPositionsBitboard;
        long pawnMove2Forward = (whitePawnBitboard << 16) & emptyPositionsBitboard & (emptyPositionsBitboard << 8) & BitboardConstants.RANK_4;
        long pawnCaptureLeft = (whitePawnBitboard << 7) & blackPiecesBitBoard & ~BitboardConstants.FILE_H;
        long pawnCaptureRight = (whitePawnBitboard << 9) & blackPiecesBitBoard & ~BitboardConstants.FILE_A;

        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.WHITE_PAWN, pawnMove1Forward, 0, -1, false, FriendlyPieceType.WHITE_QUEEN);
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.WHITE_PAWN, pawnMove2Forward, 0, -2, false, FriendlyPieceType.WHITE_QUEEN);

        //TODO: add captured piece to this method.
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.WHITE_PAWN, pawnCaptureLeft, 1, -1, true, FriendlyPieceType.WHITE_QUEEN);
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.WHITE_PAWN, pawnCaptureRight, -1, -1, true, FriendlyPieceType.WHITE_QUEEN);

        return possibleMoves;
    }

    @Override
    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition) {
        TreeSet<Integer> possibleMoves = new TreeSet<Integer>(Collections.reverseOrder());

        long emptyPositionsBitboard = bitBoardProcessor.getEmptyPositions(chessPosition);
        long blackPawnBitboard = chessPosition.getBlackPawns();

        long pawnMove1Forward = (blackPawnBitboard >> 8) & emptyPositionsBitboard;
        long pawnMove2Forward = (blackPawnBitboard >> 16) & emptyPositionsBitboard & (emptyPositionsBitboard >> 8) & BitboardConstants.RANK_5;
        long pawnCaptureLeft = (blackPawnBitboard >> 9) & bitBoardProcessor.getWhitePiecesBitboard(chessPosition) & ~BitboardConstants.FILE_H;
        long pawnCaptureRight = (blackPawnBitboard >> 7) & bitBoardProcessor.getWhitePiecesBitboard(chessPosition) & ~BitboardConstants.FILE_A;

        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.BLACK_PAWN, pawnMove1Forward, 0, 1, false, FriendlyPieceType.BLACK_QUEEN);
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.BLACK_PAWN, pawnMove2Forward, 0, 2, false, FriendlyPieceType.BLACK_QUEEN);

        //TODO: add captured piece to this method.
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.BLACK_PAWN, pawnCaptureLeft, 1, 1, true, FriendlyPieceType.BLACK_QUEEN);
        populatePossibleMovesListFromBitboard(chessPosition, possibleMoves, FriendlyPieceType.BLACK_PAWN, pawnCaptureRight, -1, 1, true, FriendlyPieceType.BLACK_QUEEN);

        return possibleMoves;
    }

    private void populatePossibleMovesListFromBitboard(ChessPosition chessPosition, TreeSet<Integer> possibleMoves, FriendlyPieceType pieceType,
                                                       long possibleMovesBitboard, int distanceToInitialPositionX, int distanceToInitialPositionY,
                                                       boolean isCapture, FriendlyPieceType possiblePromotionPiece) {
        if (possibleMovesBitboard == 0) {
            return;
        }

        //the last RANK is checked in the next for, because when a pawn reaches the last rank, it will be prommoted to another piece.
        generatePossibleMovesFromBitboardSection(chessPosition, possibleMoves, pieceType, possibleMovesBitboard, distanceToInitialPositionX, distanceToInitialPositionY,
                isCapture, null, 8, 56);

        //There will be only promotions of white pawns
        generatePossibleMovesFromBitboardSection(chessPosition, possibleMoves, pieceType, possibleMovesBitboard, distanceToInitialPositionX, distanceToInitialPositionY,
                isCapture, possiblePromotionPiece, 56, 64);

        //There will be only promotions of black pawns
        generatePossibleMovesFromBitboardSection(chessPosition, possibleMoves, pieceType, possibleMovesBitboard, distanceToInitialPositionX, distanceToInitialPositionY,
                isCapture, possiblePromotionPiece, 0, 8);
    }

    private void generatePossibleMovesFromBitboardSection(ChessPosition chessPosition, TreeSet<Integer> possibleMoves, FriendlyPieceType pieceType, long possibleMovesBitboard,
                                                          int distanceToInitialPositionX, int distanceToInitialPositionY, boolean isCapture, FriendlyPieceType possiblePromotionPiece,
                                                          int bitboardIterationStart, int bitboardIterationEnd) {
        for (int i = bitboardIterationStart; i < bitboardIterationEnd; i++) {
            if (((possibleMovesBitboard >> i) & 1L) == 1) {
                FriendlyPieceType capturedPiece = null;
                if (isCapture) {
                    capturedPiece = bitBoardProcessor.getPieceAtPosition(i % 8, i / 8, chessPosition);
                }
                int generatedMove = moveService.createMove(pieceType, new PiecePosition(i % 8 + distanceToInitialPositionX,
                        i / 8 + distanceToInitialPositionY), new PiecePosition(i % 8, i / 8), false, false, null, capturedPiece, possiblePromotionPiece, false, false);

                ChessPosition chessPositionAfterMove = chessBoardService.applyMove(chessPosition, generatedMove);
                if (!doesMovePutHisKingInCheck(chessPositionAfterMove, pieceType.getPlayer())) {
                    possibleMoves.add(generatedMove);
                    LOGGER.debug("new move:" + moveService.getFriendlyFormat(generatedMove));
                    //TODO: instead of false, see if black king will be in check by this new pawn move.
                }
            }
        }
    }

    private boolean doesMovePutHisKingInCheck(ChessPosition chessPositionAfterMove, Player playerColor) {
        return (Player.WHITE.equals(playerColor) && kingService.isWhiteKingInCheck(chessPositionAfterMove)) ||
                (Player.BLACK.equals(playerColor) && kingService.isBlackKingInCheck(chessPositionAfterMove));
    }

    @Required
    public void setBitBoardProcessor(BitBoardProcessor bitBoardProcessor) {
        this.bitBoardProcessor = bitBoardProcessor;
    }

    @Required
    public void setMoveService(MoveService moveService) {
        this.moveService = moveService;
    }

    @Required
    public void setKingService(KingService kingService) {
        this.kingService = kingService;
    }

    @Required
    public void setChessBoardService(FriendlyChessBoardService chessBoardService) {
        this.chessBoardService = chessBoardService;
    }
}
