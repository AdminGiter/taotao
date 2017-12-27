package com.taotao.action;

import com.taotao.common.bean.TaotaoResult;
import com.taotao.common.utils.CurrentTimeUtil;
import com.taotao.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginAction {

    private static Logger logger=Logger.getLogger(LoginAction.class);

    @Autowired
    private LoginService loginService;
    @ResponseBody
    @RequestMapping("/do")
    public TaotaoResult doLogin(HttpServletRequest request) {
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        logger.info(timeStamep+"登陆开始：username:"+userName);
        TaotaoResult taotaoResult = loginService.selectCheckUser( timeStamep,userName, passWord);
        logger.info("登陆结束："+taotaoResult.getStatus());
        return taotaoResult;
    }
}
