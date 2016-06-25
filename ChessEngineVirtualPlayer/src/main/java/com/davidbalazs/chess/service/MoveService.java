package com.davidbalazs.chess.service;

import com.davidbalazs.chess.model.FriendlyPieceType;
import com.davidbalazs.chess.model.KingState;
import com.davidbalazs.chess.model.PiecePosition;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface MoveService {
    /**
     * @param finalPosition   y: bits 0..2 x: bits 3..5
     * @param initialPosition y: bits 6..8 x: bits 9..11
     * @param movedPiece      12..15 (numerical representation of pieceType)
     * @param isBigCastiling  bit 16
     * @param isSmallCastling bit 17
     * @param isKingInCheck   bit 18
     * @param promotedPiece   19..22 (numerical representation of pieceType)
     * @param capturedPiece   23..26 (numerical representation of pieceType)
     * @param isCheckMate     bit 27
     * @return
     */
    int createMove(FriendlyPieceType movedPiece, PiecePosition initialPosition, PiecePosition finalPosition,
                   boolean isCheckMate, boolean isKingInCheck, FriendlyPieceType pawnPromotion,
                   FriendlyPieceType capturedPiece, FriendlyPieceType promotedPiece, boolean isSmallCastling, boolean isBigCastiling);

    FriendlyPieceType getMovedPieceType(int move);

    PiecePosition getInitialPosition(int move);

    PiecePosition getFinalPosition(int move);

    FriendlyPieceType getCapturedPiece(int move);

    FriendlyPieceType getPromotedPiece(int move);

    boolean isCheckMate(int move);

    int updateWithOppositeKingStateAfterMove(int move, KingState kingState);

    boolean isKingInCheck(int move);

    boolean isBigCastling(int move);

    boolean isSmallCastling(int move);

    String getFriendlyFormat(int move);
}
