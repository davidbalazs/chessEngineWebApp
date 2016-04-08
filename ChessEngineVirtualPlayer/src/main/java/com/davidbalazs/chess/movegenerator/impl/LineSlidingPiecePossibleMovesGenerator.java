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

/**
 * Created by David on 10/31/2015.
 */
public class LineSlidingPiecePossibleMovesGenerator {
    public static final Logger LOGGER = Logger.getLogger(LineSlidingPiecePossibleMovesGenerator.class);
    private BitBoardProcessor bitBoardProcessor;
    private MoveService moveService;
    private KingService kingService;
    private FriendlyChessBoardService chessBoardService;

    public TreeSet<Integer> generateWhiteMoves(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.WHITE_ROOK.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteRooks();
        } else if (FriendlyPieceType.WHITE_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getWhiteQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a sliding piece (rook or queen) for white. Provided piece is:" + movedPiece);
        }
        return generateMoves(chessPosition, movedPieceBitboard, bitBoardProcessor.getBlackPiecesBitboard(chessPosition), movedPiece);
    }

    public TreeSet<Integer> generateBlackMoves(ChessPosition chessPosition, FriendlyPieceType movedPiece) {
        long movedPieceBitboard;
        if (FriendlyPieceType.BLACK_ROOK.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackRooks();
        } else if (FriendlyPieceType.BLACK_QUEEN.equals(movedPiece)) {
            movedPieceBitboard = chessPosition.getBlackQueens();
        } else {
            throw new IllegalArgumentException("Wrong movedPiece provided as parameter. The provided piece type is not a sliding piece (rook or queen) for black. Provided piece is:" + movedPiece);
        }

        return generateMoves(chessPosition, movedPieceBitboard, bitBoardProcessor.getWhitePiecesBitboard(chessPosition), movedPiece);
    }

    private TreeSet<Integer> generateMoves(ChessPosition chessPosition, long slidingPieceBitboard, long opponentBotboard, FriendlyPieceType pieceToMove) {
        TreeSet<Integer> possibleMoves = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < 64; i++) {
            if (((slidingPieceBitboard >> i) & 1L) == 1) {
                long possibleMovesBitboardToRight = generatePossibleMovesBitboardToRight(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToLeft = generatePossibleMovesBitboardToLeft(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToTop = generatePossibleMovesBitboardToTop(i, chessPosition, opponentBotboard);
                long possibleMovesBitboardToBottom = generatePossibleMovesBitboardToBottom(i, chessPosition, opponentBotboard);

                long possibleMovesBitboard = possibleMovesBitboardToRight | possibleMovesBitboardToLeft | possibleMovesBitboardToTop | possibleMovesBitboardToBottom;

                generateMoves(pieceToMove, possibleMovesBitboard, possibleMoves, new PiecePosition(i % 8, i / 8), chessPosition);
            }
        }

        return possibleMoves;
    }

    private long generatePossibleMovesBitboardToRight(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToRight = BitboardConstants.lineSlidingRight[i] & occupiedBitboard;
        possibleMovesToRight = possibleMovesToRight << 1 | possibleMovesToRight << 2 | possibleMovesToRight << 3 | possibleMovesToRight << 4 | possibleMovesToRight << 5 | possibleMovesToRight << 6;
        return getBitboardFromNumber(possibleMovesToRight, BitboardConstants.lineSlidingRight[i], opponentBitboard, occupiedBitboard);

    }

    private long generatePossibleMovesBitboardToLeft(int i, ChessPosition chessPosition, long opponentBitboard) {
        //TODO: call .getOccupiedPositions only once in the generate moves method and send the occupiedPositionsBitboard as parameter for all these 4 methods.
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToLeft = BitboardConstants.lineSlidingLeft[i] & occupiedBitboard;
        possibleMovesToLeft = possibleMovesToLeft >> 1 | possibleMovesToLeft >> 2 | possibleMovesToLeft >> 3 | possibleMovesToLeft >> 4 | possibleMovesToLeft >> 5 | possibleMovesToLeft >> 6;
        return getBitboardFromNumber(possibleMovesToLeft, BitboardConstants.lineSlidingLeft[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToTop(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToTop = BitboardConstants.lineSlidingUp[i] & occupiedBitboard;
        possibleMovesToTop = possibleMovesToTop << 8 | possibleMovesToTop << 16 | possibleMovesToTop << 24 | possibleMovesToTop << 32 | possibleMovesToTop << 40 | possibleMovesToTop << 48;
        return getBitboardFromNumber(possibleMovesToTop, BitboardConstants.lineSlidingUp[i], opponentBitboard, occupiedBitboard);
    }

    private long generatePossibleMovesBitboardToBottom(int i, ChessPosition chessPosition, long opponentBitboard) {
        long occupiedBitboard = bitBoardProcessor.getOccupiedPositions(chessPosition);
        long possibleMovesToBottom = BitboardConstants.lineSlidingDown[i] & occupiedBitboard;
        possibleMovesToBottom = possibleMovesToBottom >> 8 | possibleMovesToBottom >> 16 | possibleMovesToBottom >> 24 | possibleMovesToBottom >> 32 | possibleMovesToBottom >> 40 | possibleMovesToBottom >> 48;
        return getBitboardFromNumber(possibleMovesToBottom, BitboardConstants.lineSlidingDown[i], opponentBitboard, occupiedBitboard);
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

