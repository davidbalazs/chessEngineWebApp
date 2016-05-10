package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.LatestNewsDao;
import com.davidbalazs.chess.models.LatestNewsEntityModel;
import com.davidbalazs.chess.services.LatestNewsService;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by David on 4/5/2016.
 */
public class DefaultLatestNewsService implements LatestNewsService {
    private LatestNewsDao latestNewsDao;

    public List<LatestNewsEntityModel> getLatestNews() {
        return latestNewsDao.getAll();
    }

    public LatestNewsEntityModel getById(long latestNewsEntityId) {
        return latestNewsDao.getById(latestNewsEntityId);
    }

    public void create(LatestNewsEntityModel latestNewsEntity) {
        latestNewsDao.create(latestNewsEntity);
    }

    @Transactional
    public void update(LatestNewsEntityModel latestNewsEntity) {
        latestNewsDao.update(latestNewsEntity);
    }

    @Transactional
    public void delete(long latestNewsEntityId) {
        latestNewsDao.delete(latestNewsEntityId);
    }

    @Required
    public void setLatestNewsDao(LatestNewsDao latestNewsDao) {
        this.latestNewsDao = latestNewsDao;
    }
}
