package com.mifu.yygh.cmn.controller;


import com.mifu.yygh.cmn.service.DictService;
import com.mifu.yygh.common.result.R;
import com.mifu.yygh.model.cmn.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 组织架构表 前端控制器
 * </p>
 *
 * @author mifu
 * @since 2022-08-23
 */
@RestController
@RequestMapping("/admin/cmn")
public class DictController {


    @Autowired
    private DictService dictService;



    @PostMapping("/upload")
    public R upload(MultipartFile file) throws IOException {
        dictService.upload(file);
        return R.ok();
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        dictService.download(response);
    }

    @GetMapping("/childList/{pid}")
    public R getChildListByPid(@PathVariable Long pid){
        List<Dict> list=dictService.getChildListByPid(pid);
        return R.ok().data("items",list);
    }

    //根据医院所属的省市区编号获取省市区文字
    @GetMapping("/{value}")
    public String getNameByValue(@PathVariable("value") Long value){
       return dictService.getNameByValue(value);
    }

    //根据医院的等级编号获取医院等级信息
    @GetMapping("/{dictCode}/{value}")
    public String getNameByDictCodeAndValue(@PathVariable("dictCode") String dictCode,
                                            @PathVariable("value") Long value){
      return dictService.getNameByDictCodeAndValue(dictCode,value);
    }

}

