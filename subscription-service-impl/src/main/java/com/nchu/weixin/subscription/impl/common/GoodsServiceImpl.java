package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.enums.GoodsStatusEnum;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.repo.common.GoodsRepo;
import com.nchu.weixin.subscription.service.common.GoodsService;
import com.nchu.weixin.subscription.tools.DateHepler;
import com.nchu.weixin.subscription.tools.UUidUtil;
import com.nchu.weixin.subscription.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品服务实现类
 * Created by fujianjian on 2016/12/10.
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    private final static String GOODS_COUNT_NUM_KEY = "GOODS_COUNT_NUM_KEY";

    @Autowired
    BaseService baseService;

    @Autowired
    GoodsRepo goodsRepo;

    @Autowired
    JedisUtil jedisUtil;

    @Value("${weixin.goods.image.base.path}")
    private String goodsImageUploadPath;

    public Goods get(String id) {
        return goodsRepo.getOne(id);
    }

    public Goods create(Goods object) {
        object = this.goodsRepo.save(object);
//        baseService.sendMail(MailTypeEnum.GOODS, OperateEnum.ADD);
        return object;
    }

    public Goods modify(Goods object) {
        return this.goodsRepo.saveAndFlush(object);
    }

    public void delete(String id) {
        this.goodsRepo.delete(id);
    }

    /**
     * 带图表的添加一个商品
     * @param goods
     * @param iconImg
     * @return
     */
    @Override
    public Goods create(Goods goods, MultipartFile iconImg) throws Exception {
        String originalName = iconImg.getOriginalFilename();
        String iconImgSubffix = originalName.substring(originalName.lastIndexOf("."), originalName.length());
        StringBuilder relative = new StringBuilder("static/images/goods/")
                .append(goods.getGoodsName()).append("/");
        String targetName = UUidUtil.generateShortUUid() + iconImgSubffix;
        File file = null;
        try {
            File filePath = new File(goodsImageUploadPath + relative.toString());
            if (!filePath.exists()) filePath.mkdirs();
            file = new File(goodsImageUploadPath + relative.append(targetName).toString());
            iconImg.transferTo(file);
            Long goodNum = jedisUtil.incr(GOODS_COUNT_NUM_KEY);
            String temp = DateHepler.convertDateToDisplayStr(new Date(), DateHepler.DF_YYYYMMDDHH);
            goods.setStatus(GoodsStatusEnum.WAIT_SHELVE);
            goods.setGoodsNo(temp+goodNum);
            goods.setSaleCount(0);
            goods.setGoodsImgPath(relative.toString());
            goods = create(goods);
            return goods;
        } catch (Exception e) {
            log.error("创建一个商品信息出错", e);
            if (file != null && file.exists()) {
                file.delete();
            }
        }
        return null;
    }

    @Override
    public Map searcher(Map paramMap, Pageable pageRequest) {
        Map retMap = new HashMap();
        Page<Goods> pages = this.goodsRepo.findAll(pageRequest);

        retMap.put("pages", pages);
        retMap.put("gds", pages.getContent());

        return retMap;
    }
}
