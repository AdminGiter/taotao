package com.taotao.service;

import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {

    PageInfo<TbItem> getList(String timeStamep, Integer page, Integer rows);

    TaotaoResult  getItemParamByCid(String timeStamep,String itemCatId);

    TaotaoResult  insertItemParam(String timeStamep,TbItemParam itemParam);
}
