package com.davidbalazs.chess.movegenerator.impl;

import com.davidbalazs.chess.constants.BitboardConstants;
import com.davidbalazs.chess.model.*;
import com.davidbalazs.chess.processor.BitBoardProcessor;
import com.davidbalazs.chess.service.FriendlyChessBoardService;
import com.davidbalazs.chess.service.KingService;
import com.davidbalazs.chess.service.MoveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.TreeSet;

public class DiagonalSlidingPiecePossibleMovesGenerator {
    public static final Logger LOGGER = Logger.getLogger(DiagonalSlidingPiecePossibleMovesGenerator.class);
    private BitBoardProcessor bitBoardProcessor;
    private MoveService moveService;
    private KingService kingService;
    private FriendlyChessBoardService chessBoardService;

    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.WHITE_BISHOP.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteBishops();
        } else if (FriendlyPieceType.WHITE_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a diagonal sliding piece (bishop or queen) for white. Provided piece is:" + movedPiece);
        }

        return generateMoves(chessPosition, movedPieceBitboard, bitBoardProcessor.getBlackPiecesBitboard(chessPosition), movedPiece);
    }

    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.BLACK_BISHOP.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackBishops();
        } else if (FriendlyPieceType.BLACK_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a diagonal sliding piece (bishop or queen) for black. Provided piece is:" + movedPiece);
        }

        return generateMoves(chessPosition, movedPieceBitboard, bitBoardProcessor.getWhitePiecesBitboard(chessPosition), movedPiece);
    }

    private TreeSet<Integer> generateMoves(ChessPosition chessPosition, long slidingPieceBitboard, long opponentBotboard, FriendlyPieceType pieceToMove) {
        TreeSet<Integer> possibleMoves = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < 64; i++) {
            if (((slidingPieceBitboard >> i) & 1L) == 1) {
                long possibleMovesBitboardToRight = generatePossibleMovesBitboardToUpRight(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToLeft = generatePossibleMovesBitboardToUpLeft(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToTop = generatePossibleMovesBitboardToDownRight(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToBottom = generatePossibleMovesBitboardToDownLeft(i, chessPosition, opponentBotboard);

                long possibleMovesBitboard = possibleMovesBitboardToRight | possibleMovesBitboardToLeft | possibleMovesBitboardToTop | possibleMovesBitboardToBottom;

                generateMoves(pieceToMove, possibleMovesBitboard, possibleMoves, new PiecePosition(i % 8, i / 8), chessPosition);
            }
        }

        return possibleMoves;
    }

    private long generatePossibleMovesBitboardToUpRight(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToUpRight = BitboardConstants.diagonalSlidingUpRight[i] & occupiedBitboard;
        possibleMovesToUpRight = possibleMovesToUpRight << 9 | possibleMovesToUpRight << 18 | possibleMovesToUpRight << 27 |
                possibleMovesToUpRight << 36 | possibleMovesToUpRight << 45 | possibleMovesToUpRight << 54;
        return getBitboardFromNumber(possibleMovesToUpRight, BitboardConstants.diagonalSlidingUpRight[i], opponentBitboard, occupiedBitboard);

    }

    private long generatePossibleMovesBitboardToUpLeft(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToUpLeft = BitboardConstants.diagonalSlidingUpLeft[i] & occupiedBitboard;
        possibleMovesToUpLeft = possibleMovesToUpLeft >> 9 | possibleMovesToUpLeft >> 18 | possibleMovesToUpLeft >> 27 |
                possibleMovesToUpLeft >> 36 | possibleMovesToUpLeft >> 45 | possibleMovesToUpLeft >> 54;
        return getBitboardFromNumber(possibleMovesToUpLeft, BitboardConstants.diagonalSlidingUpLeft[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToDownRight(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToDownRight = BitboardConstants.diagonalSlidingDownRight[i] & occupiedBitboard;
        possibleMovesToDownRight = possibleMovesToDownRight << 7 | possibleMovesToDownRight << 14 | possibleMovesToDownRight << 21 |
                possibleMovesToDownRight << 28 | possibleMovesToDownRight << 35 | possibleMovesToDownRight << 42;
        return getBitboardFromNumber(possibleMovesToDownRight, BitboardConstants.diagonalSlidingDownRight[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToDownLeft(int i, ChessPosition chessPosition, long opponentBitboard) {

        //TODO: call .getOccupiedPositions only once in the generate moves method and send the occupiedPositionsBitboard as parameter for all these 4 methods.
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToDownLeft = BitboardConstants.diagonalSlidingDownLeft[i] & occupiedBitboard;
        possibleMovesToDownLeft = possibleMovesToDownLeft >> 7 | possibleMovesToDownLeft >> 14 | possibleMovesToDownLeft >> 21 |
                possibleMovesToDownLeft >> 28 | possibleMovesToDownLeft >> 35 | possibleMovesToDownLeft >> 42;
        return getBitboardFromNumber(possibleMovesToDownLeft, BitboardConstants.diagonalSlidingDownLeft[i], opponentBitboard, occupiedBitboard);
    }


    private long getBitboardFromNumber(long bitboardNumber, long precomputedBitboard, long opponentBitboard, long occupiedBitboard) {
        bitboardNumber = bitboardNumber & precomputedBitboard;
        bitboardNumber = bitboardNumber ^ precomputedBitboard;
        return bitboardNumber & (opponentBitboard | (~occupiedBitboard));
    }

    private void generateMoves(FriendlyPieceType pieceType, long bitboard, TreeSet<Integer> possibleMoves, PiecePosition initialPosition, ChessPosition chessPosition) {
        for (int i = 0; i < 64; i++) {
            if (((bitboard >> i) & 1L) == 1) {
                FriendlyPieceType capturedPiece = bitBoardProcessor.getPieceAtPosition(i % 8, i / 8, chessPosition);
                int generatedMove = moveService.createMove(pieceType, initialPosition, new PiecePosition(i % 8, i / 8),
                        false, false, null, capturedPiece, null, false, false);

                ChessPosition chessPositionAfterMove = chessBoardService.applyMove(chessPosition, generatedMove);
                if (!doesMovePutHisKingInCheck(chessPositionAfterMove, pieceType.getPlayer())) {
                    KingState kingStateAfterMove = null;
                    if (Player.WHITE.equals(pieceType.getPlayer())) {
                        if (!kingService.isWhiteKingInCheck(chessPosition)) {
                            kingStateAfterMove = kingService.getBlackKingStateAfterMove(chessPosition, generatedMove);
                        }
                    } else {
                        if (!kingService.isBlackKingInCheck(chessPosition)) {
                            kingStateAfterMove = kingService.getWhiteKingStateAfterMove(chessPosition, generatedMove);
                        }
                    }

                    generatedMove = moveService.updateWithOppositeKingStateAfterMove(generatedMove, kingStateAfterMove);
                    possibleMoves.add(generatedMove);
                    LOGGER.debug("new move:" + moveService.getFriendlyFormat(generatedMove));
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
