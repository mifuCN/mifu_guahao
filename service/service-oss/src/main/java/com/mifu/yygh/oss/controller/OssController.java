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
    public R upload(MultipartFile file) {
        String url = ossService.upload(file);
        //return R.ok().data("url", url);
        //对象存储没钱了 先自己定义一个网络的将就用着
        return R.ok().data("url", "https://img2.woyaogexing.com/2021/04/21/06d5f3ca1a1d4154b6823c62bf23055d!400x400.jpeg");
    }
}
