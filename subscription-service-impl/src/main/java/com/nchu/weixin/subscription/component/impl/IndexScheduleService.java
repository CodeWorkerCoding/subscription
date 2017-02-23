package com.nchu.weixin.subscription.component.impl;

import com.nchu.weixin.subscription.component.RootScheduleService;
import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import com.nchu.weixin.subscription.service.common.IndexService;
import com.nchu.weixin.subscription.tools.DateHepler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * index 创建任务
 * Created by fujianjian on 2017/2/23.
 */
@Service("indexScheduleService")
@Slf4j
public class IndexScheduleService implements RootScheduleService {

    @Autowired
    private IndexService indexService;

    @Override
    public void execute() {
        String date = DateHepler.convertDateToDisplayStr(new Date(), DateHepler.DF_YYYY_MM_DD);
        List<Index> list = indexService.getByDate(date);
        if (null == list || list.size()==0){
            for (IndexTypeEnum type : IndexTypeEnum.values()) {
                Index index = new Index(date, type);
                index.setIndexCount(0);
                this.indexService.create(index);
                log.info("创建【{}】日的【{}】标记记录一条", date, type.getDesc());
            }
        } else {
            //LinkedHashMap保持插入顺序
            Map<IndexTypeEnum, List<Index>> map = new LinkedHashMap<>();
            list.forEach(item -> {
                if (null == map.get(item.getType())){
                    List<Index> idxs = new LinkedList<Index>();
                    idxs.add(item);
                    map.put(item.getType(), idxs);
                } else {
                    List<Index> idxs = map.get(item.getType());
                    idxs.add(item);
                }
            });
            for (IndexTypeEnum type : IndexTypeEnum.values()) {
                if (null == map.get(type)){
                    Index index = new Index(date, type);
                    index.setIndexCount(0);
                    indexService.create(index);
                    log.info("创建【{}】日的【{}】标记记录一条", date, type.getDesc());
                } else {
                    List<Index> indexs = map.get(type);
                    //只保留定第一记录
                    if (indexs.size() > 1){
                        indexs.forEach(i -> {
                            this.indexService.delete(i.getId());
                            log.info("删除【{}】日的【{}】标记记录[id:{} count:{}]一条",
                                    date, type.getDesc(), i.getId(), i.getIndexCount());
                        });
                    }
                }
            }
        }

    }
}
