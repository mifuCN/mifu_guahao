package com.mifu.yygh.hosp.controller.admin;

import com.mifu.yygh.common.result.R;
import com.mifu.yygh.model.acl.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "芾医疗后台登录相关")
@RequestMapping(value = "/admin/user")
public class UserController {
    // 测试vue-admin-template脚手架登录时请求了两个他自己的接口,按照它的接口返回的数据类型写的return
    @ApiOperation("登录接口")
    @PostMapping(value = "/login")
    public R login(@RequestBody User user) {
        //暂时不去数据库查:用户系统再去 TODO 后期可以完善

        // 前端需要 {"code":20000,"data":{"token":"admin-token"}}
        return R.ok().data("token", "admin-token");
    }

    @ApiOperation("显示相关信息")
    @GetMapping(value = "/info")
    public R info(String token) {
        return R.ok().data("roles", "[admin]")
                .data("introduction", "I am a super administrator")
                .data("avatar", "https://s.nmxc.ltd/sakurairo_vision/@2.5/basic/iloli.gif")
                .data("name", "Super Admin");
    }


}
