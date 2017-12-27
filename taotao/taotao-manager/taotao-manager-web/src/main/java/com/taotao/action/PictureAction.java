package com.taotao.action;

import com.taotao.common.utils.CurrentTimeUtil;
import com.taotao.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping("/pic")
public class PictureAction {
    private static Logger logger=Logger.getLogger(PictureAction.class);
    @Autowired
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping("/upload")
    public Map pictureUpload(MultipartFile uploadFile) {
        String timeStamep= CurrentTimeUtil.getCurrwntTime();
        logger.info(timeStamep+"上传图片开始");
        Map map = pictureService.uploadPicture(timeStamep,uploadFile);
        logger.info(timeStamep+"上传图片结束：Map:"+map);
        return map;
    }
}
