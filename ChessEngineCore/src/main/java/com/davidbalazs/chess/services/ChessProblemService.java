package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.ChessProblemModel;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessProblemService {
    List<ChessProblemModel> getAll();

    ChessProblemModel getProblemOfTheDay();

    @Transactional
    void markAsProblemOfTheDay(long id);

    @Transactional
    void unmarkAsProblemOfTheDay(long id);

    ChessProblemModel getById(long id);

    @Transactional
    void delete(long id);
}
