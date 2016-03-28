package com.davidbalazs.chess.service.impl;

import com.davidbalazs.chess.exceptions.NoSuchPieceException;
import com.davidbalazs.chess.model.*;
import com.davidbalazs.chess.service.FriendlyChessBoardService;
import com.davidbalazs.chess.service.MoveService;
import org.springframework.beans.factory.annotation.Required;

import java.util.Arrays;
import java.util.List;

/**
 * Created by David on 9/28/2015.
 */
public class DefaultFriendlyChessBoardService implements FriendlyChessBoardService {

    private MoveService moveService;

    public ChessPosition initializeChessBoard(List<FriendlyPiecePosition> piecePositionList) {
        ChessPosition chessPosition = new ChessPosition();
        for (FriendlyPiecePosition piecePosition : piecePositionList) {
            long position;
            if (piecePosition.getCoordinateX() == 7 && piecePosition.getCoordinateY() == 7) {
                position = Long.MIN_VALUE;
            } else {
                position = (long) Math.pow(2, piecePosition.getCoordinateY() * 8 + piecePosition.getCoordinateX());
            }
            switch (piecePosition.getPieceType()) {
                case WHITE_PAWN:
                    chessPosition.setWhitePawns(chessPosition.getWhitePawns() + position);
                    break;
                case WHITE_KNIGHT:
                    chessPosition.setWhiteKnights(chessPosition.getWhiteKnights() + position);
                    break;
                case WHITE_BISHOP:
                    chessPosition.setWhiteBishops(chessPosition.getWhiteBishops() + position);
                    break;
                case WHITE_ROOK:
                    chessPosition.setWhiteRooks(chessPosition.getWhiteRooks() + position);
                    break;
                case WHITE_QUEEN:
                    chessPosition.setWhiteQueens(chessPosition.getWhiteQueens() + position);
                    break;
                case BLACK_PAWN:
                    chessPosition.setBlackPawns(chessPosition.getBlackPawns() + position);
                    break;
                case BLACK_KNIGHT:
                    chessPosition.setBlackKnights(chessPosition.getBlackKnights() + position);
                    break;
                case BLACK_BISHOP:
                    chessPosition.setBlackBishops(chessPosition.getBlackBishops() + position);
                    break;
                case BLACK_ROOK:
                    chessPosition.setBlackRooks(chessPosition.getBlackRooks() + position);
                    break;
                case BLACK_QUEEN:
                    chessPosition.setBlackQueens(chessPosition.getBlackQueens() + position);
                    break;
                case WHITE_KING:
                    chessPosition.setWhiteKing(chessPosition.getWhiteKing() + position);
                    break;
                case BLACK_KING:
                    chessPosition.setBlackKing(chessPosition.getBlackKing() + position);
                    break;
            }
        }

        return chessPosition;
    }

    public ChessPosition initializeChessBoard() {
        return initializeChessBoard(getInitialChessBoardPosition());
    }

    public FriendlyChessPosition getFriendlyChessPosition(ChessPosition chessPosition) {
        FriendlyChessPosition friendlyChessPosition = new FriendlyChessPosition();
        long whitePawnsPosition = chessPosition.getWhitePawns();
        long whiteKnightsPosition = chessPosition.getWhiteKnights();
        long whiteBishopsPosition = chessPosition.getWhiteBishops();
        long whiteRooksPosition = chessPosition.getWhiteRooks();
        long whiteQueensPosition = chessPosition.getWhiteQueens();
        long blackPawnsPosition = chessPosition.getBlackPawns();
        long blackKnightsPosition = chessPosition.getBlackKnights();
        long blackBishopsPosition = chessPosition.getBlackBishops();
        long blackRooksPosition = chessPosition.getBlackRooks();
        long blackQueensPosition = chessPosition.getBlackQueens();
        long whiteKingPosition = chessPosition.getWhiteKing();
        long blackKingPosition = chessPosition.getBlackKing();
        for (int i = 0; i < 64; i++) {
            int coordinateX = i / 8, coordinateY = i % 8;
            if ((whiteKingPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, coordinateX, coordinateY));
            }
            if ((blackKingPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, coordinateX, coordinateY));
            }

            if ((whitePawnsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, coordinateX, coordinateY));
            }

            if ((whiteKnightsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, coordinateX, coordinateY));
            }

            if ((whiteBishopsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_BISHOP, coordinateX, coordinateY));
            }

            if ((whiteRooksPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, coordinateX, coordinateY));
            }

            if ((whiteQueensPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.WHITE_QUEEN, coordinateX, coordinateY));
            }

            if ((blackPawnsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, coordinateX, coordinateY));
            }

            if ((blackKnightsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_KNIGHT, coordinateX, coordinateY));
            }

            if ((blackBishopsPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_BISHOP, coordinateX, coordinateY));
            }

            if ((blackRooksPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, coordinateX, coordinateY));
            }

            if ((blackQueensPosition & 1L) != 0) {
                friendlyChessPosition.setPiece(new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, coordinateX, coordinateY));
            }

            whitePawnsPosition = whitePawnsPosition >> 1;
            whiteKnightsPosition = whiteKnightsPosition >> 1;
            whiteBishopsPosition = whiteBishopsPosition >> 1;
            whiteRooksPosition = whiteRooksPosition >> 1;
            whiteQueensPosition = whiteQueensPosition >> 1;
            whiteKingPosition = whiteKingPosition >> 1;

            blackPawnsPosition = blackPawnsPosition >> 1;
            blackKnightsPosition = blackKnightsPosition >> 1;
            blackBishopsPosition = blackBishopsPosition >> 1;
            blackRooksPosition = blackRooksPosition >> 1;
            blackQueensPosition = blackQueensPosition >> 1;
            blackKingPosition = blackKingPosition >> 1;
        }
        return friendlyChessPosition;
    }

    public void displayChessBoard(ChessPosition chessPosition) {
        System.out.println(getFriendlyChessPosition(chessPosition));
    }

    @Override
    public ChessPosition applyMove(ChessPosition chessPosition, int move) {
        //TODO: apply move works only without capturing pieces. Moves that have captured pieces won't be applied correctly.
        ChessPosition newChessPosition = new ChessPosition();
        populateChessPosition(chessPosition, newChessPosition);

        FriendlyPieceType movedPiece = moveService.getMovedPieceType(move);
        long movedPieceBitboard = getBitboardOfPiece(chessPosition, movedPiece);
        PiecePosition initialPosition = moveService.getInitialPosition(move);
        int shift = initialPosition.getX() + initialPosition.getY() * 8;
        long initialPositionMask = ~(1L << shift);

        PiecePosition finalPosition = moveService.getFinalPosition(move);
        shift = finalPosition.getX() + finalPosition.getY() * 8;
        long finalPositionMask = 1L << shift;

        long newBitboardForMovedPiece = movedPieceBitboard & initialPositionMask;
        newBitboardForMovedPiece = newBitboardForMovedPiece | finalPositionMask;
        setBitboardForPiece(newChessPosition, movedPiece, newBitboardForMovedPiece);
        return newChessPosition;
    }

    @Override
    public long getBitboardOfPiece(ChessPosition chessPosition, FriendlyPieceType pieceType) {
        switch (pieceType) {
            case WHITE_PAWN:
                return chessPosition.getWhitePawns();
            case WHITE_KNIGHT:
                return chessPosition.getWhiteKnights();
            case WHITE_BISHOP:
                return chessPosition.getWhiteBishops();
            case WHITE_ROOK:
                return chessPosition.getWhiteRooks();
            case WHITE_QUEEN:
                return chessPosition.getWhiteQueens();
            case BLACK_PAWN:
                return chessPosition.getBlackPawns();
            case BLACK_KNIGHT:
                return chessPosition.getBlackKnights();
            case BLACK_BISHOP:
                return chessPosition.getBlackBishops();
            case BLACK_ROOK:
                return chessPosition.getBlackRooks();
            case BLACK_QUEEN:
                return chessPosition.getBlackQueens();
            case WHITE_KING:
                return chessPosition.getWhiteKing();
            case BLACK_KING:
                return chessPosition.getBlackKing();
            default:
                throw new NoSuchPieceException(pieceType);
        }
    }

    @Override
    public void setBitboardForPiece(ChessPosition chessPosition, FriendlyPieceType pieceType, long newBitboard) {
        switch (pieceType) {
            case WHITE_PAWN:
                chessPosition.setWhitePawns(newBitboard);
                break;
            case WHITE_KNIGHT:
                chessPosition.setWhiteKnights(newBitboard);
                break;
            case WHITE_BISHOP:
                chessPosition.setWhiteBishops(newBitboard);
                break;
            case WHITE_ROOK:
                chessPosition.setWhiteRooks(newBitboard);
                break;
            case WHITE_QUEEN:
                chessPosition.setWhiteQueens(newBitboard);
                break;
            case BLACK_PAWN:
                chessPosition.setBlackPawns(newBitboard);
                break;
            case BLACK_KNIGHT:
                chessPosition.setBlackKnights(newBitboard);
                break;
            case BLACK_BISHOP:
                chessPosition.setBlackBishops(newBitboard);
                break;
            case BLACK_ROOK:
                chessPosition.setBlackRooks(newBitboard);
                break;
            case BLACK_QUEEN:
                chessPosition.setBlackQueens(newBitboard);
                break;
            case WHITE_KING:
                chessPosition.setWhiteKing(newBitboard);
                break;
            case BLACK_KING:
                chessPosition.setBlackKing(newBitboard);
                break;
            default:
                throw new NoSuchPieceException(pieceType);
        }
    }

    private void populateChessPosition(ChessPosition source, ChessPosition target) {
        target.setWhitePawns(source.getWhitePawns());
        target.setWhiteRooks(source.getWhiteRooks());
        target.setWhiteKnights(source.getWhiteKnights());
        target.setWhiteBishops(source.getWhiteBishops());
        target.setWhiteQueens(source.getWhiteQueens());
        target.setWhiteKing(source.getWhiteKing());

        target.setBlackPawns(source.getBlackPawns());
        target.setBlackRooks(source.getBlackRooks());
        target.setBlackKnights(source.getBlackKnights());
        target.setBlackBishops(source.getBlackBishops());
        target.setBlackQueens(source.getBlackQueens());
        target.setBlackKing(source.getBlackKing());
    }

    private List<FriendlyPiecePosition> getInitialChessBoardPosition() {
        return Arrays.asList(
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 0, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 1, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 2, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 3, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 4, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 5, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 6, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_PAWN, 7, 1),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 1, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KNIGHT, 6, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_BISHOP, 2, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_BISHOP, 5, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 0, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_ROOK, 7, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_QUEEN, 3, 0),
                new FriendlyPiecePosition(FriendlyPieceType.WHITE_KING, 4, 0),

                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 0, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 1, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 2, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 3, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 4, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 5, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 6, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_PAWN, 7, 6),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KNIGHT, 1, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KNIGHT, 6, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_BISHOP, 2, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_BISHOP, 5, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 0, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_ROOK, 7, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_QUEEN, 3, 7),
                new FriendlyPiecePosition(FriendlyPieceType.BLACK_KING, 4, 7));
    }

    @Required
    public void setMoveService(MoveService moveService) {
        this.moveService = moveService;
    }
}
