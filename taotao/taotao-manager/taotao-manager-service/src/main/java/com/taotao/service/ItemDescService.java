package com.taotao.service;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.pojo.TbItemDesc;

public interface ItemDescService {

    TaotaoResult getByItemId(String timeStamep, long itemId);
}
