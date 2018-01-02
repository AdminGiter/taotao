package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemParamServiceImpl implements ItemParamService {

    private static Logger logger=Logger.getLogger(ItemParamServiceImpl.class);

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public PageInfo<TbItem> getList(String timeStamep, Integer page, Integer rows) {
        logger.info(timeStamep+"查询规格参数信息列表service开始：page："+page+",rows"+rows);
        PageHelper.startPage(page,rows);
        logger.info(timeStamep+"查询规格参数信息列表数据库查询开始");
        List<TbItem> list=tbItemParamMapper.selectList();
        logger.info(timeStamep+"查询规格参数信息列表数据库查询结束");
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        logger.info(timeStamep+"查询规格参数信息列表service结束");
        return pageInfo;
    }

    @Override
    public TaotaoResult getItemParamByCid(String timeStamep, String itemCatId) {
        return null;
    }

    @Override
    public TaotaoResult insertItemParam(String timeStamep, TbItemParam itemParam) {
        return null;
    }
}
