package com.nchu.weixin.subscription.repo.common;

import com.nchu.weixin.subscription.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alen on 2016/12/12.
 */
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {
}
