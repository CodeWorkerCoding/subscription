package com.nchu.weixin.subscription.service.common;

import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import com.nchu.weixin.subscription.service.BaseTest;
import com.nchu.weixin.subscription.tools.DateHepler;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Index 服务验证
 * Created by fujianjian on 2017/2/23.
 */
public class IndexServiceTest extends BaseTest {

    @Autowired
    private  IndexService indexService;

    @Test
    public void testCreatIdx(){
        Index index  = new Index();
        String date = DateHepler.convertDateToDisplayStr(new Date(), DateHepler.DF_YYYY_MM_DD);
        index.setFlagDate(date);
        index.setType(IndexTypeEnum.GOODS);

        this.indexService.create(index);
    }
}
