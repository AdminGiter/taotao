package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PictureService {
     Map uploadPicture(String timeStamep, MultipartFile multipartFile);

}
