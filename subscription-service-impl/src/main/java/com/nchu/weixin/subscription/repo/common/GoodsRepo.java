package com.nchu.weixin.subscription.repo.common;

import com.nchu.weixin.subscription.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fujianjian on 2016/12/12.
 */
public interface GoodsRepo extends JpaRepository<Goods, String> {
}
