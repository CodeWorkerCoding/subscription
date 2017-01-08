package com.nchu.weixin.subscription.action.manage;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.enums.GoodsStatusEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.service.common.GoodsService;
import com.nchu.weixin.subscription.tools.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品管理 控制器
 * Created by fujianjian on 2016/12/12.
 */
@Controller
@RequestMapping("/manage/goods")
@Slf4j
public class GoodsManageAction {

    private static final Integer PAGE_MIN = 1;
    private static final Integer PAGE_MAX = 20;

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/list",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String manageList(@RequestParam Map paramMap,
                             @RequestParam(name = "pageNo", defaultValue = "1", required = false) Integer pageNo,
                             @RequestParam(name = "pageSize",defaultValue = "20", required = false) Integer pageSize,
                             Map model){
        log.info("hint this goods manage list method");
        Map retMap = this.goodsService.searcher(paramMap,
                new PageRequest(pageNo < PAGE_MIN ? 0 : pageNo -1 ,
                        pageSize > PAGE_MAX ? PAGE_MAX : pageSize ,
                        new Sort(Sort.Direction.DESC, "createdTime")));
        model.putAll(retMap);
        model.putAll(paramMap);
        return "manage/goods/list";
    }


    @RequestMapping(value = "/create", method = {RequestMethod.GET})
    public String create(){
        return "manage/goods/create";
    }

    @RequestMapping(value = "/{id}/info", method = {RequestMethod.GET})
    public String getGoodsInfo(@PathVariable String id, Map model){
        Goods goods = this.goodsService.get(id);
        model.put("gs", goods);
        return "manage/goods/info";
    }

    @RequestMapping(value = "/{id}/modify", method = {RequestMethod.GET})
    public String modifyGoodsInfo(@PathVariable String id, Map model){
        Goods goods = this.goodsService.get(id);
        model.put("gs", goods);
        return "manage/goods/modify";
    }

    /**
     * 创建一个商品信息
     * @param goods
     * @return
     */
    @RequestMapping(value = "/create", method = { RequestMethod.POST })
    public String handleAdd(@RequestParam MultipartFile iconImg, Goods goods) throws Exception {
        goodsService.create(goods, iconImg);
        return "redirect:/manage/goods/list";
    }

    @RequestMapping(value = "/operate", method = {RequestMethod.GET})
    public @ResponseBody Map operate(@RequestParam String goodsId, @RequestParam String operate){
        log.info("商品【{}】收到【{}】操作", goodsId, operate);
        Goods gs = this.goodsService.get(goodsId);
        Map ret = new HashMap<>();
        if (gs != null){
            if (StringHelper.isNotEmpty(operate)){
                if (OperateEnum.RELEASE.getValue().equals(operate)){ //上架
                    gs.setStatus(GoodsStatusEnum.IN_SALE);
                    this.goodsService.modify(gs);
                    ret.put("code", 200);
                    ret.put("msg", "上架成功");
                } else if (OperateEnum.REBACK.getValue().equals(operate)){ //召回
                    gs.setStatus(GoodsStatusEnum.REBACK);
                    this.goodsService.modify(gs);
                    ret.put("code", 200);
                    ret.put("msg", "召回成功");
                } else if (OperateEnum.UNSHELVE.getValue().equals(operate)){ //下架
                    gs.setStatus(GoodsStatusEnum.UN_SHELVE);
                    this.goodsService.modify(gs);
                    ret.put("code", 200);
                    ret.put("msg", "下架成功");
                } else { //未知操作
                    ret.put("code", 503);
                    ret.put("msg", "未知操作");
                }
            } else {
                ret.put("code", 504);
                ret.put("msg", "没有任何操作");
            }
        } else {
            ret.put("code", 404);
            ret.put("msg", "商品信息不存在！");
        }
        return ret;
    }
}
