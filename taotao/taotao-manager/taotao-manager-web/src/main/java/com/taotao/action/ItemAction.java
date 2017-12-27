package com.taotao.action;

import com.github.pagehelper.PageInfo;
import com.taotao.common.utils.CurrentTimeUtil;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemAction {

    private static Logger logger=Logger.getLogger(ItemAction.class);
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/select/{itemid}")
    public TbItem getItemById(@PathVariable Long itemid){
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"查询产品信息开始："+itemid);
        TbItem tbItem=itemService.getItemById(timeStamep,itemid);
        logger.info(timeStamep+"查询产品信息结束");
        return tbItem;
    }
    @ResponseBody
    @RequestMapping("/list")
    public Object selectList( @RequestParam(required=true,defaultValue="1") Integer page,
                               @RequestParam(required=false,defaultValue="10") Integer rows){
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"查询产品信息列表开始：");
        PageInfo<TbItem> pageInfo= itemService.getList(timeStamep,page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        logger.info(timeStamep+"查询产品信息列表结束");
        return map;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Object saveTbItem(TbItem tbItem,String desc){
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"新增产品开始："+tbItem.getTitle());
        Map<String,Object> map=new HashMap<>();
        map.put("status", "error");
        boolean status = itemService.addItem(timeStamep,tbItem,desc);
        if (status){
            map.put("status", "success");
        }
        logger.info(timeStamep+"新增产品结束："+map);
        return map;

    }
    @ResponseBody
    @RequestMapping("/update")
    public Object updateTbItem(TbItem tbItem,String desc) {
        String timeStamep = CurrentTimeUtil.getCurrwntTime();
        Map<String, Object> map = new HashMap<>();
        map.put("status", "error");
        boolean status = itemService.updateItem(timeStamep, tbItem, desc);
        if (status) {
            map.put("status", "success");
        }
        return map;
    }

}
