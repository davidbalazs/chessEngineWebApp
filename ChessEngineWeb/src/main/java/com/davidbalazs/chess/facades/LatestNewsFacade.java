package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.LatestNewsItemData;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface LatestNewsFacade {
    List<LatestNewsItemData> getAll();

    void add(LatestNewsItemData latestNewsItemData);

    void delete(long id);
}
