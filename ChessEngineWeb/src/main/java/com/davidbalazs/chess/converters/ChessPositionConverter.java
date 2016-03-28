package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.model.ChessPosition;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessPositionConverter {
    public ChessPosition convert(String chessPositionFen) {
        //TODO: implement this method.
        String[] chessTableLines = chessPositionFen.split("/");
        int index = 64;
        for (String chessTableLine : chessTableLines) {
            char[] chessTableLineChars = chessTableLine.toCharArray();
            for (char fenCharacter : chessTableLineChars) {
                if (Character.isDigit(fenCharacter)) {
                    index = index - Character.getNumericValue(fenCharacter);
                } else {
                    index--;
                    switch (fenCharacter) {
                        case 'k':
                            break;
                    }
                }
            }
        }

        return new ChessPosition();
    }
}
