package com.taotao.action;

import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.TreeBean;
import com.taotao.common.utils.CurrentTimeUtil;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemParamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规格参数Action

 */
@Controller
@RequestMapping("/item/param")
public class ItemParamAction {

    private static Logger logger=Logger.getLogger(ItemParamAction.class);

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/list")
    public Object selectList( @RequestParam(required=true,defaultValue="1") Integer page,
                              @RequestParam(required=false,defaultValue="10") Integer rows){
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"查询规格参数信息列表开始：");
        PageInfo<TbItem> pageInfo= itemParamService.getList(timeStamep,page,rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        logger.info(timeStamep+"查询规格参数信息列表结束");
        return map;
    }
}
