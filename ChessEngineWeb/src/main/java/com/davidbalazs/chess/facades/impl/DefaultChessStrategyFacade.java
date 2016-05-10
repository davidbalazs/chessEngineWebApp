package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.converters.StrategyConverter;
import com.davidbalazs.chess.data.ChessStrategyDetailsData;
import com.davidbalazs.chess.facades.ChessStrategyFacade;
import com.davidbalazs.chess.models.ChessStrategyModel;
import com.davidbalazs.chess.services.ChessStrategyService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessStrategyFacade implements ChessStrategyFacade {
    private StrategyConverter strategyConverter;
    private ChessStrategyService chessStrategyService;

    @Override
    public long createUsingStrategyDetails(ChessStrategyDetailsData chessStrategyDetailsData) {
        ChessStrategyModel chessStrategyModel = strategyConverter.convert(chessStrategyDetailsData);
        return chessStrategyService.create(chessStrategyModel);
    }

    @Required
    public void setStrategyConverter(StrategyConverter strategyConverter) {
        this.strategyConverter = strategyConverter;
    }

    @Required
    public void setChessStrategyService(ChessStrategyService chessStrategyService) {
        this.chessStrategyService = chessStrategyService;
    }
}
