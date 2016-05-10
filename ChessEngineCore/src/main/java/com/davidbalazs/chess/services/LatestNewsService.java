package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.LatestNewsItemModel;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by David on 4/5/2016.
 */
public interface LatestNewsService {
    List<LatestNewsItemModel> getAll();

    LatestNewsItemModel getById(long latestNewsEntityId);

    @Transactional
    void create(LatestNewsItemModel latestNewsEntity);

    void update(LatestNewsItemModel latestNewsEntity);
    @Transactional
    void delete(long latestNewsEntityId);
}
