package com.nchu.weixin.subscription.service.common;

import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Map;

/**
 * 基础服务 只包含 增 删 改 查 操作
 * Created by fujianjian on 2016/12/10.
 */
public interface BaseService<T extends Object, ID extends Serializable> {

    T get(ID id);

    T create(T object);

    T modify(T object);

    void delete(ID id);

    Map searcher(Map paramMap, Pageable pageRequest);

}
