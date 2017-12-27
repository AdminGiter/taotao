package com.taotao.action;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.CurrentTimeUtil;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemDescService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/desc")
public class ItemDescAction {

    private static Logger logger=Logger.getLogger(ItemDescAction.class);

    @Autowired
    private ItemDescService itemDescService;
    @ResponseBody
    @RequestMapping("/{itemid}")
    public TaotaoResult getItemDescById(@PathVariable Long itemid){
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"查询商品描述信息开始："+itemid);
        TaotaoResult taotaoResult=itemDescService.getByItemId(timeStamep,itemid);
        logger.info(timeStamep+"查询商品描述结束");
        return taotaoResult;
    }
}
