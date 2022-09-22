package com.mifu.yygh.user.service;


import com.mifu.yygh.model.user.UserInfo;
import com.mifu.yygh.vo.user.LoginVo;
import com.mifu.yygh.vo.user.UserInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 */
public interface UserInfoService extends IService<UserInfo> {

    Map<String, Object> login(LoginVo loginVo);

    UserInfo getUserInfo(Long userId);

    Page<UserInfo> getUserInfoPage(Integer pageNum, Integer limit, UserInfoQueryVo userInfoQueryVo);

    void updateStatus(Long id, Integer status);

    Map<String, Object> detail(Long id);
}
