package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.exceptions.ChessFenRepresentationException;
import com.davidbalazs.chess.model.ChessPosition;

import java.text.MessageFormat;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessPositionConverter {

    private static final String CHESS_FEN_REPRESENTATION_EXCEPTION_MESSAGE = "Wrong FEN representation: [{0}].One of the characters in the FEN string is not a digit, nor a character that represents a chess piece. A chess piece is represented by following chars: rnbqkpRNBQKP";
    private static final String CHESS_FEN_REPRESENTATION_EXCEPTION_WRONG_NUMBER_OF_LINES_MESSAGE = "Wrong FEN representation: [{0}]. The number of strings split by '/' should be 8.";

    public ChessPosition convert(String chessPositionFen) {
        //TODO: implement this method.
        String[] chessTableLines = chessPositionFen.split("/");
        int index = 64;
        ChessPosition chessPosition = new ChessPosition();
        for (String chessTableLine : chessTableLines) {
            if (chessTableLines.length != 8) {
                throw new ChessFenRepresentationException(MessageFormat.format(CHESS_FEN_REPRESENTATION_EXCEPTION_WRONG_NUMBER_OF_LINES_MESSAGE, chessPositionFen));
            }

            char[] chessTableLineChars = chessTableLine.toCharArray();
            for (int i = chessTableLineChars.length - 1; i >= 0; i--) {
                char fenCharacter = chessTableLineChars[i];
                if (Character.isDigit(fenCharacter)) {
                    index = index - Character.getNumericValue(fenCharacter);
                } else {
                    switch (fenCharacter) {
                        case 'r':
                            chessPosition.setBlackRooks(updateBitboard(chessPosition.getBlackRooks(), index));
                            break;
                        case 'n':
                            chessPosition.setBlackKnights(updateBitboard(chessPosition.getBlackKnights(), index));
                            break;
                        case 'b':
                            chessPosition.setBlackBishops(updateBitboard(chessPosition.getBlackBishops(), index));
                            break;
                        case 'q':
                            chessPosition.setBlackQueens(updateBitboard(chessPosition.getBlackQueens(), index));
                            break;
                        case 'k':
                            chessPosition.setBlackKing(updateBitboard(chessPosition.getBlackKing(), index));
                            break;
                        case 'p':
                            chessPosition.setBlackPawns(updateBitboard(chessPosition.getBlackPawns(), index));
                            break;
                        case 'R':
                            chessPosition.setWhiteRooks(updateBitboard(chessPosition.getWhiteRooks(), index));
                            break;
                        case 'N':
                            chessPosition.setWhiteKnights(updateBitboard(chessPosition.getWhiteKnights(), index));
                            break;
                        case 'B':
                            chessPosition.setWhiteBishops(updateBitboard(chessPosition.getWhiteBishops(), index));
                            break;
                        case 'Q':
                            chessPosition.setWhiteQueens(updateBitboard(chessPosition.getWhiteQueens(), index));
                            break;
                        case 'K':
                            chessPosition.setWhiteKing(updateBitboard(chessPosition.getWhiteKing(), index));
                            break;
                        case 'P':
                            chessPosition.setWhitePawns(updateBitboard(chessPosition.getWhitePawns(), index));
                            break;
                        default:
                            throw new ChessFenRepresentationException(MessageFormat.format(CHESS_FEN_REPRESENTATION_EXCEPTION_MESSAGE, chessPositionFen));
                    }

                    index--;
                }
            }
        }

        return chessPosition;
    }

    private long updateBitboard(long bitboard, int index) {
        return bitboard | (1L << index);
    }
}
