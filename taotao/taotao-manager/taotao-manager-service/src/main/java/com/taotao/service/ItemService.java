package com.taotao.service;

import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem  getItemById(String timeStamep,Long id);
	PageInfo<TbItem> getList(String timeStamep,Integer page, Integer rows);
	TaotaoResult addItem(String timeStamep, TbItem tbItem, String desc);
	TaotaoResult updateItem(String timeStamep, TbItem tbItem,String desc);
}
