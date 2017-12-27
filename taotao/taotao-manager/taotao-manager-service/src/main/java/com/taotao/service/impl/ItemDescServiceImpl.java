package com.taotao.service.impl;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemDescService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDescServiceImpl implements ItemDescService{

    private static Logger logger=Logger.getLogger(ItemDescServiceImpl.class);

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TaotaoResult getByItemId(String timeStamep, long itemId) {
        TaotaoResult taotaoResult=new TaotaoResult();
        logger.info(timeStamep+"查询商品描述信息service开始:itemId:"+itemId);
        taotaoResult.setStatus(TaotaoResult.SUSSCESS);
        TbItemDesc tbItemDesc=tbItemDescMapper.selectByPrimaryKey(itemId);
        taotaoResult.setData(tbItemDesc);
        logger.info(timeStamep+"查询商品描述信息service结束");
        return taotaoResult;
    }
}
