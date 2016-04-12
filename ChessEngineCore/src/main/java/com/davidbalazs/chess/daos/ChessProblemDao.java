package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.ChessProblemModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessProblemDao extends GenericDao<ChessProblemModel> {
    ChessProblemModel getProblemOfTheDay();
}
