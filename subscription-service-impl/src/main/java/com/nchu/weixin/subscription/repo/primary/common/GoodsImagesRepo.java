package com.nchu.weixin.subscription.repo.primary.common;

import com.nchu.weixin.subscription.domain.GoodsImages;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alen on 2016/12/12.
 */
public interface GoodsImagesRepo extends JpaRepository<GoodsImages, String> {
}
