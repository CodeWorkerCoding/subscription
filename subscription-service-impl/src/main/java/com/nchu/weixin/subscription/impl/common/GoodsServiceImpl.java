package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.domain.Index;
import com.nchu.weixin.subscription.enums.GoodsStatusEnum;
import com.nchu.weixin.subscription.enums.IndexTypeEnum;
import com.nchu.weixin.subscription.repo.primary.common.GoodsRepo;
import com.nchu.weixin.subscription.service.common.GoodsService;
import com.nchu.weixin.subscription.service.common.IndexService;
import com.nchu.weixin.subscription.tools.DateHepler;
import com.nchu.weixin.subscription.tools.UUidUtil;
import com.nchu.weixin.subscription.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BaseService baseService;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private IndexService indexService;

    @Autowired
    private JedisUtil jedisUtil;

//    private String goodsImageUploadPath = System.getProperty("user.dir");
    private String goodsImageUploadPath = "E:\\Code\\JetBrain\\java\\github\\subscription\\subscription-web";

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
        StringBuilder relative = new StringBuilder(goodsImageUploadPath)
                .append(File.separator).append("src/main/webapp/static/images/goods/")
                .append(goods.getGoodsName()).append("/");
        String targetName = UUidUtil.generateShortUUid() + iconImgSubffix;
        relative.append(targetName);
        log.info("商品【{}】图片保存路径:{}", goods.getGoodsName(), relative.toString());
        File file = null;
        try {
            file = new File(relative.toString());
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            iconImg.transferTo(file);
            //Long goodNum = jedisUtil.incr(GOODS_COUNT_NUM_KEY);
            String date = DateHepler.convertDateToDisplayStr(new Date(), DateHepler.DF_YYYY_MM_DD);
            synchronized (date.intern()){
                Index index = this.indexService.getByDateAndType(date, IndexTypeEnum.GOODS);
                if (index == null){
                    index = new Index(date, IndexTypeEnum.GOODS);
                }
                int goodNum = null == index.getIndexCount() ? 1 : index.getIndexCount() + 1;
                String temp = DateHepler.convertDateToDisplayStr(new Date(), DateHepler.DF_YYYYMMDDHH);
                goods.setStatus(GoodsStatusEnum.WAIT_SHELVE);
                goods.setGoodsNo(temp+goodNum);
                goods.setSaleCount(0);
                goods.setGoodsImgPath(relative.toString());
                goods = create(goods);
                index.setIndexCount(goodNum);
                this.indexService.modify(index);
                return goods;
            }
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
