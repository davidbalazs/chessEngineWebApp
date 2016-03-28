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

        }

        return new ChessPosition();
    }
}
