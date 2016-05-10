package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.LatestNewsEntityModel;

import java.util.List;

/**
 * Created by David on 4/5/2016.
 */
public interface LatestNewsService {
    List<LatestNewsEntityModel> getLatestNews();

    LatestNewsEntityModel getById(long latestNewsEntityId);

    void create(LatestNewsEntityModel latestNewsEntity);

    void update(LatestNewsEntityModel latestNewsEntity);

    void delete(long latestNewsEntityId);
}
