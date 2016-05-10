package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.converters.LatestNewsConverter;
import com.davidbalazs.chess.data.LatestNewsItemData;
import com.davidbalazs.chess.facades.LatestNewsFacade;
import com.davidbalazs.chess.models.LatestNewsItemModel;
import com.davidbalazs.chess.services.LatestNewsService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultLatestNewsFacade implements LatestNewsFacade {
    private LatestNewsService latestNewsService;
    private LatestNewsConverter latestNewsConverter;

    public List<LatestNewsItemData> getAll() {
        List<LatestNewsItemModel> latestNewsItemModelList = latestNewsService.getAll();

        return latestNewsConverter.convertAll(latestNewsItemModelList);
    }

    public void add(LatestNewsItemData latestNewsItemData) {
        LatestNewsItemModel latestNewsItemModel = latestNewsConverter.convertReverse(latestNewsItemData);
        latestNewsService.create(latestNewsItemModel);
    }

    public void delete(long id) {
        latestNewsService.delete(id);
    }

    @Required
    public void setLatestNewsService(LatestNewsService latestNewsService) {
        this.latestNewsService = latestNewsService;
    }

    @Required
    public void setLatestNewsConverter(LatestNewsConverter latestNewsConverter) {
        this.latestNewsConverter = latestNewsConverter;
    }
}
