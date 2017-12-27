package com.taotao.service.impl;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.mapper.TUserMapper;
import com.taotao.pojo.TUser;
import com.taotao.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    private static Logger logger=Logger.getLogger(LoginServiceImpl.class);
    @Autowired
    private TUserMapper tUserMapper;
    /*
    * 校验用户名和密码的正确性
    * */
    @Override
    public TaotaoResult selectCheckUser(String timeStamep, String userName, String passWord) {
        logger.info(timeStamep+"校验用户名service开始：userName："+userName);
        TaotaoResult taotaoResult=new TaotaoResult();
        taotaoResult.setStatus(TaotaoResult.ERROR);
        logger.info(timeStamep+"校验用户名数据库查询开始");
        List<TUser> tUserList=tUserMapper.selectByUserName(userName);
        logger.info(timeStamep+"校验用户名数据库查询结束");
        logger.info(timeStamep+"校验用户名数据库查询结果列表："+tUserList.size());
        if (tUserList.size()>0){
            TUser tUser=tUserList.get(0);
            if (StringUtils.equals(userName,tUser.getUsername())&&StringUtils.equals(passWord,tUser.getPassword())){
                taotaoResult.setStatus(TaotaoResult.SUSSCESS);
            }
        }
        logger.info(timeStamep+"校验用户名service结束：status:"+taotaoResult.getStatus());
        return taotaoResult;
    }
}
