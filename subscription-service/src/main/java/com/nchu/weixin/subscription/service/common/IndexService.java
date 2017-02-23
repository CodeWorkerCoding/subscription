package com.nchu.weixin.subscription.service.common;

import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;

import java.util.List;

/**
 * index 服务
 * Created by fujjianjian on 2017/2/23.
 */
public interface IndexService extends BaseService<Index, Integer> {

    /**
     * 通过日期和类型获取索引
     * @param date
     * @param type
     * @return
     */
    Index getByDateAndType(String date, IndexTypeEnum type);

    /**
     * 通过日期获取记录列表
     * @param date
     * @return
     */
    List<Index> getByDate(String date);
}
