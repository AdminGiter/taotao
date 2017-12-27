package com.taotao.service;

import com.taotao.common.bean.TaotaoResult;

public interface LoginService {

    TaotaoResult selectCheckUser(String timeStamep, String userNmae, String passWord);
}
