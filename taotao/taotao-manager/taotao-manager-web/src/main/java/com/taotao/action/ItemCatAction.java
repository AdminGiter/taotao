package com.taotao.action;

import com.taotao.common.bean.TreeBean;
import com.taotao.service.ItemCatService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.common.utils.CurrentTimeUtil;
import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class ItemCatAction {

    private static Logger logger=Logger.getLogger(ItemCatAction.class);
    @Autowired
    private ItemCatService itemCatService;


    @ResponseBody
    @RequestMapping("/list")
    public Object selectListByid( @RequestParam(required=false,defaultValue="0")Long id){
        String timeStamep=CurrentTimeUtil .getCurrwntTime();
        logger.info(timeStamep+"查询商品分类列表开始：id:"+id);
        List<TreeBean> treeBeanList= itemCatService.getTreeListByParentId(timeStamep,id);
        logger.info(timeStamep+"查询产品信息列表结束");
        return treeBeanList;
    }
    @ResponseBody
    @RequestMapping("/selectlist")
    public Object selectList(){
        String timeStamep=CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"查询商品分类全部列表开始");
        List<TreeBean> treeBeanList= itemCatService.getTreeList(timeStamep);
        logger.info(timeStamep+"查询商品分类全部列表开始");
        return treeBeanList;
    }
}
