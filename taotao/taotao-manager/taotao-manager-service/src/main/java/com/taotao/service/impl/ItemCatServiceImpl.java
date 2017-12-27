package com.taotao.service.impl;

import com.taotao.common.bean.TreeBean;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

    private static Logger logger=Logger.getLogger(ItemCatServiceImpl.class);

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeBean> getTreeListByParentId(String timeStamep, Long id) {
        logger.info(timeStamep+"查询子节点开始：id:"+id);
        List<TbItemCat> tbItemCats=tbItemCatMapper.selectByParentId(id);
        logger.info(timeStamep+"查询子节点结束："+id);
        List<TreeBean> treeBeanList=new ArrayList<>();
        tbItemCats.forEach(tbItemCat -> {
            TreeBean treeBean = new TreeBean();
            treeBean.setId(tbItemCat.getId());
            treeBean.setText(tbItemCat.getName());
            String State= tbItemCat.getIsParent()?"closed":"open";
            treeBean.setState(State);
            treeBeanList.add(treeBean);
        });
        return treeBeanList;
    }
    @Override
    public List<TreeBean> getTreeList(String timeStamep) {
        logger.info(timeStamep+"查询节点开始：i");
        List<TbItemCat> tbItemCats=tbItemCatMapper.selectList();
        logger.info(timeStamep+"查询子节点结束");
        List<TreeBean> treeBeanList=new ArrayList<>();
        tbItemCats.forEach(tbItemCat ->{
            TreeBean treeBean = new TreeBean();
            treeBean.setId(tbItemCat.getId());
            treeBean.setParentId(tbItemCat.getParentId());
            treeBean.setText(tbItemCat.getName());
            treeBeanList.add(treeBean);
        });
        List<TreeBean> treeBeans=createTreeBeanList(treeBeanList,0);
        return treeBeans;
    }

    private  List<TreeBean> createTreeBeanList(List<TreeBean> treeBeanList, long parentId) {
        List<TreeBean> treeBeans=new ArrayList<>();
       for(Iterator<TreeBean> itear=treeBeanList.iterator();itear.hasNext();) {
           TreeBean treeBean = itear.next();
           if (parentId == treeBean.getParentId()) {
               treeBeans.add(treeBean);
               itear.remove();

           }
       }
           for (TreeBean treeBean : treeBeans) {
               List<TreeBean> treeList = createTreeBeanList(treeBeanList, treeBean.getId());
               treeBean.setChildren(treeList);
           }
        return  treeBeans;
    }
}
