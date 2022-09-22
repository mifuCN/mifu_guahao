package com.mifu.yygh.user.controller.user;


import com.mifu.yygh.common.result.R;
import com.mifu.yygh.common.utils.JwtHelper;
import com.mifu.yygh.enums.AuthStatusEnum;
import com.mifu.yygh.model.user.UserInfo;
import com.mifu.yygh.user.service.UserInfoService;
import com.mifu.yygh.vo.user.LoginVo;
import com.mifu.yygh.vo.user.UserAuthVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author mifu
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/user/userinfo")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;


    //save 只能做添加 | save添加|修改

    @PutMapping("/update")
    public R update(@RequestHeader String token,UserAuthVo userAuthVo){
        Long userId = JwtHelper.getUserId(token);
        UserInfo userInfo=new UserInfo();
        userInfo.setId(userId);
        userInfo.setName(userAuthVo.getName());
        userInfo.setCertificatesType(userAuthVo.getCertificatesType());
        userInfo.setCertificatesNo(userAuthVo.getCertificatesNo());
        userInfo.setCertificatesUrl(userAuthVo.getCertificatesUrl());
        userInfo.setAuthStatus(AuthStatusEnum.AUTH_RUN.getStatus());
        userInfoService.updateById(userInfo);

        return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo){
       Map<String,Object> map = userInfoService.login(loginVo);
       return R.ok().data(map);
    }

    @GetMapping("/info")
    public R getUserInfo(@RequestHeader String token ){
        Long userId = JwtHelper.getUserId(token);
        UserInfo byId = userInfoService.getUserInfo(userId);
        return R.ok().data("user",byId);
    }

}

