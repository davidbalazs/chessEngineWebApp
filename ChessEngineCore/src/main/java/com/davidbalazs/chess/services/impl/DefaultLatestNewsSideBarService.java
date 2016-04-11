package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.LatestNewsSideBarDao;
import com.davidbalazs.chess.models.LatestNewsEntityModel;
import com.davidbalazs.chess.services.LatestNewsSideBarService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * Created by David on 4/5/2016.
 */
public class DefaultLatestNewsSideBarService implements LatestNewsSideBarService {
    private LatestNewsSideBarDao latestNewsSideBarDao;

    public List<LatestNewsEntityModel> getLatestNews() {
        return latestNewsSideBarDao.getAll();
    }

    public LatestNewsEntityModel getById(long latestNewsEntityId) {
        return latestNewsSideBarDao.getById(latestNewsEntityId);
    }

    public void create(LatestNewsEntityModel latestNewsEntity) {
        latestNewsSideBarDao.create(latestNewsEntity);
    }

    public void update(LatestNewsEntityModel latestNewsEntity) {
        latestNewsSideBarDao.update(latestNewsEntity);
    }

    public void delete(long latestNewsEntityId) {
        latestNewsSideBarDao.delete(latestNewsEntityId);
    }

    @Required
    public void setLatestNewsSideBarDao(LatestNewsSideBarDao latestNewsSideBarDao) {
        this.latestNewsSideBarDao = latestNewsSideBarDao;
    }
}
