package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.LatestNewsDao;
import com.davidbalazs.chess.models.LatestNewsItemModel;
import com.davidbalazs.chess.services.LatestNewsService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Created by David on 4/5/2016.
 */
public class DefaultLatestNewsService implements LatestNewsService {
    private LatestNewsDao latestNewsDao;

    public List<LatestNewsItemModel> getAll() {
        return latestNewsDao.getAll();
    }

    public LatestNewsItemModel getById(long id) {
        return latestNewsDao.getById(id);
    }

    public void create(LatestNewsItemModel latestNewsItem) {
        latestNewsDao.create(latestNewsItem);
    }

    public void update(LatestNewsItemModel latestNewsItem) {
        latestNewsDao.update(latestNewsItem);
    }

    public void delete(long id) {
        latestNewsDao.delete(id);
    }

    @Required
    public void setLatestNewsDao(LatestNewsDao latestNewsDao) {
        this.latestNewsDao = latestNewsDao;
    }
}
