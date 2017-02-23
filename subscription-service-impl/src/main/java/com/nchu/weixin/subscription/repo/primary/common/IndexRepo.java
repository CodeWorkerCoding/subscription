package com.nchu.weixin.subscription.repo.primary.common;

import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * index 类的Repo
 * Created by fujianjian on 2017/2/23.
 */
public interface IndexRepo extends JpaRepository<Index, Integer> {

    @Query("from Index i where i.flagDate = :flagDate and i.type = :type")
    Index findByFlagDateAndType(@Param("flagDate") String flagDate, @Param("type") IndexTypeEnum type);

    @Query("from Index i where i.flagDate = :flagDate")
    List<Index> findByFlagDate(@Param("flagDate") String flagDate);
}
