package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.ChessStrategyDetailsData;
import com.davidbalazs.chess.models.ChessStrategyCategory;
import com.davidbalazs.chess.models.ChessStrategyModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class StrategyConverter {
    public ChessStrategyModel convert(ChessStrategyDetailsData chessStrategyDetailsData) {
        ChessStrategyModel chessStrategyModel = new ChessStrategyModel();
        chessStrategyModel.setName(chessStrategyDetailsData.getName());
        chessStrategyModel.setCategory(ChessStrategyCategory.valueOf(chessStrategyDetailsData.getCategory().name()));

        return chessStrategyModel;
    }
}
