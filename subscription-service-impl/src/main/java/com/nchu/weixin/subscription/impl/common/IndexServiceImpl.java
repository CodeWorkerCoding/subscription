package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import com.nchu.weixin.subscription.repo.primary.common.IndexRepo;
import com.nchu.weixin.subscription.service.common.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * index 服务实现
 * Created by fujianjian on 2017/2/23.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexRepo indexRepo;

    @Override
    public Index get(Integer integer) {
        return indexRepo.getOne(integer);
    }

    @Override
    public Index create(Index object) {
        return indexRepo.save(object);
    }

    @Override
    public Index modify(Index object) {
        return indexRepo.saveAndFlush(object);
    }

    @Override
    public void delete(Integer integer) {
        indexRepo.delete(integer);
    }

    @Override
    public Map searcher(Map paramMap, Pageable pageRequest) {
        throw new RuntimeException("Index 服务的Searcher()方法暂未实现");
    }

    /**
     * 通过日期和类型获取索引
     *
     * @param date
     * @param type
     * @return
     */
    @Override
    public Index getByDateAndType(String date, IndexTypeEnum type) {
        return this.indexRepo.findByFlagDateAndType(date, type);
    }

    /**
     * 通过日期获取记录列表
     *
     * @param date
     * @return
     */
    @Override
    public List<Index> getByDate(String date) {
        return this.indexRepo.findByFlagDate(date);
    }
}
