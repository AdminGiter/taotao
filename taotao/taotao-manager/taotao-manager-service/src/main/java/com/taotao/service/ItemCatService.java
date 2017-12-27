package com.taotao.service;

import com.taotao.common.bean.TreeBean;

import java.util.List;

public interface ItemCatService {

    List<TreeBean> getTreeListByParentId(String timeStamep, Long id);

    List<TreeBean>  getTreeList(String timeStamep);
}
