package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.constance.ItemConstance;
import com.taotao.common.utils.IdUtil;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private static Logger logger=Logger.getLogger(ItemServiceImpl.class);
    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    public TbItem getItemById(String timeStamep,Long id) {
        logger.info(timeStamep+"查询产品信息service开始:id:"+id);
        TbItem tbItem=tbItemMapper.selectByPrimaryKey(id);
        logger.info(timeStamep+"查询产品信息service结束");
        return tbItem;
    }

    @Override
    public PageInfo<TbItem> getList(String timeStamep, Integer page, Integer rows) {
        logger.info(timeStamep+"查询产品信息列表service开始：page："+page+",rows"+rows);
        PageHelper.startPage(page,rows);
        logger.info(timeStamep+"查询产品信息列表数据库查询开始");
        List<TbItem> list=tbItemMapper.selectList();
        logger.info(timeStamep+"查询产品信息列表数据库查询结束");
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        logger.info(timeStamep+"查询产品信息列表service结束");
        return pageInfo;
    }

    @Override
    public TaotaoResult addItem(String timeStamep, TbItem tbItem, String desc) {
        logger.info(timeStamep+"新增产品servcie开始");
        TaotaoResult taotaoResult=new TaotaoResult();
        taotaoResult.setStatus(TaotaoResult.ERROR);
        try {
            long id=IdUtil.getItemId();
            tbItem.setId(id);
            tbItem.setStatus(new Byte(ItemConstance.ITEM_STAUS_NORMAIL));
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            logger.info(timeStamep+"新增产品插库开始");
            int i=tbItemMapper.insert(tbItem);
            //添加产品描述
            String insertDescResult=insertItemDesc(id,desc);
            if(!TaotaoResult.SUSSCESS.equals(insertDescResult)){
                throw new Exception("新增产品描述异常");
            }
            logger.info(timeStamep+"新增产品插库结束：i:"+i);
            if (i==1){
                taotaoResult.setStatus(TaotaoResult.SUSSCESS);
            }
        }catch(Exception e){
            logger.info(timeStamep+"新增产品异常："+e.getMessage());
        }
        logger.info(timeStamep+"新增产品servcie结束:status:"+taotaoResult.getStatus());
        return taotaoResult;
    }

    /**
     * 添加商品描述
     */
    private String insertItemDesc(Long itemId, String desc) {
        String result= TaotaoResult.ERROR;
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        int i=tbItemDescMapper.insert(itemDesc);
        if (1==i){
            result= TaotaoResult.SUSSCESS;
        }
        return result;
    }

    @Override
    public TaotaoResult updateItem(String timeStamep, TbItem tbItem,String desc) {
        logger.info(timeStamep+"修改产品servcie开始id:"+tbItem.getId());
        TaotaoResult taotaoResult=new TaotaoResult();
        taotaoResult.setStatus(TaotaoResult.ERROR);
        try {
            logger.info(timeStamep+"修改产品更新开始");
            TbItem item=tbItemMapper.selectByPrimaryKey(tbItem.getId());
            tbItem.setUpdated(new Date());
            tbItem.setCreated(item.getCreated());
            int i=tbItemMapper.updateByPrimaryKey(tbItem);
            //添加产品描述
            String insertDescResult=updateItemDesc(tbItem.getId(),desc);
            if(!TaotaoResult.SUSSCESS.equals(insertDescResult)){
                throw new Exception("修改产品描述异常");
            }
            logger.info(timeStamep+"修改产品更新结束：i:"+i);
            if (i==1){
                taotaoResult.setStatus(TaotaoResult.SUSSCESS);
            }
        }catch(Exception e){
            logger.info(timeStamep+"修改产品更新异常："+e.getMessage());
        }
        logger.info(timeStamep+"修改产品servcie结束:status:"+taotaoResult.getStatus());
        return taotaoResult;
    }

    /**
     * 更新商品描述
     */
    private String updateItemDesc(Long itemId, String desc) {
        String result= TaotaoResult.ERROR;
        TbItemDesc itemDesc=tbItemDescMapper.selectByPrimaryKey(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        int i=tbItemDescMapper.updateByPrimaryKey(itemDesc);
        if (1==i){
            result= TaotaoResult.SUSSCESS;
        }
        return result;
    }


}
