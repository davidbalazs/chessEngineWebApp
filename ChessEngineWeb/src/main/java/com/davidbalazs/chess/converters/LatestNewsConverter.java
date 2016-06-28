package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.LatestNewsItemData;
import com.davidbalazs.chess.models.LatestNewsItemModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class LatestNewsConverter {
    public LatestNewsItemData convert(LatestNewsItemModel latestNewsItemModel) {
        LatestNewsItemData latestNewsItemData = new LatestNewsItemData();
        latestNewsItemData.setId(latestNewsItemModel.getId());
        latestNewsItemData.setTitle(latestNewsItemModel.getTitle());
        latestNewsItemData.setText(latestNewsItemModel.getText());
        latestNewsItemData.setDate(latestNewsItemModel.getDate());

        return latestNewsItemData;
    }

    public List<LatestNewsItemData> convertAll(List<LatestNewsItemModel> latestNewsItemModelList) {
        List<LatestNewsItemData> latestNewsItemDataList = new ArrayList<>();
        for (LatestNewsItemModel latestNewsItemModel : latestNewsItemModelList) {
            LatestNewsItemData latestNewsItemData = convert(latestNewsItemModel);
            latestNewsItemDataList.add(latestNewsItemData);
        }

        return latestNewsItemDataList;
    }

    public LatestNewsItemModel convertReverse(LatestNewsItemData latestNewsItemData) {
        LatestNewsItemModel latestNewsItemModel = new LatestNewsItemModel();
        latestNewsItemModel.setId(latestNewsItemData.getId());
        latestNewsItemModel.setTitle(latestNewsItemData.getTitle());
        latestNewsItemModel.setText(latestNewsItemData.getText());
        latestNewsItemModel.setDate(new Date());

        return latestNewsItemModel;
    }
}
