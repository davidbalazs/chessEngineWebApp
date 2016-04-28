package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.ChessProblemModel;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessProblemService {
    List<ChessProblemModel> getAll();

    ChessProblemModel getProblemOfTheDay();

    ChessProblemModel getById(long id);
}
