package com.mifu.yygh.oss.controller;

import com.mifu.yygh.common.result.R;
import com.mifu.yygh.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/oss/file")
public class OssController {

    @Autowired
    private OssService ossService;


    @PostMapping("/upload")
    public R upload(MultipartFile file){
       String url= ossService.upload(file);
       return R.ok().data("url",url);
    }
}
