package com.taotao.service.impl;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.PictureUtil;
import com.taotao.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
@Service
public class PictureServiceImpl  implements PictureService {
    private static Logger logger=Logger.getLogger(PictureServiceImpl.class);

    @Value("${FTP_ADDRESS}")
    private String  FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private int  FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String  FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String  FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String  FTP_BASE_PATH;

    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture(String timeStamep, MultipartFile multipartFile) {
        logger.info(timeStamep+"图片上传service开始");
        Map<String,Object> map=new HashMap<>();
        map.put("error", 1);
        try {
            String oldName=multipartFile.getOriginalFilename();
            logger.info(timeStamep+"原图片名称："+oldName);
            String imageName= PictureUtil.genImageName()+oldName.substring(oldName.lastIndexOf("."));
            logger.info(timeStamep+"新图片名称："+imageName);
            String imagePath=PictureUtil.genImagePath();
            logger.info(timeStamep+"图片FTP上传开始");
            FtpUtil.uploadFile(FTP_ADDRESS,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FTP_BASE_PATH,imagePath,imageName,multipartFile.getInputStream());
            logger.info(timeStamep+"图片FTP上传结束");
            map.put("url",IMAGE_BASE_URL+"/"+imagePath+"/"+imageName);
            map.put("error", 0);;
        } catch (Exception e) {
            logger.info(timeStamep+"图片上传异常："+e.getMessage());
        }

        return map;
    }
}
