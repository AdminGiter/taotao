package com.taotao.service;

import com.github.pagehelper.PageInfo;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem  getItemById(String timeStamep,Long id);
	PageInfo<TbItem> getList(String timeStamep,Integer page, Integer rows);
	boolean addItem(String timeStamep, TbItem tbItem,String desc);
    boolean updateItem(String timeStamep, TbItem tbItem,String desc);
}
