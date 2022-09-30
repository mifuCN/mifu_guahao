package com.mifu.yygh.hosp.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mifu.yygh.common.result.R;
import com.mifu.yygh.common.utils.MD5;
import com.mifu.yygh.hosp.service.HospitalSetService;
import com.mifu.yygh.model.hosp.HospitalSet;
import com.mifu.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * 医院设置表 前端控制器
 */
@RestController
@Api(tags = "芾医疗管理端,医院信息相关接口")
@RequestMapping("/admin/hosp/hospitalSet")
@Slf4j
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

//    方式一
//    这个是mp的一种方式 传什么就设置什么
    @ApiOperation(value = "医院启停状态修改")
    @PutMapping("/status/{id}/{status}")
    public R updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        HospitalSet hospitalSet = new HospitalSet();
        hospitalSet.setId(id);
        hospitalSet.setStatus(status);
        hospitalSetService.updateById(hospitalSet);
        return R.ok();
    }
//    方式二 能体现乐观锁 要用MP的@Version注解
//    @ApiOperation(value = "医院启停状态修改")
//    @PutMapping("/status/{id}/{status}")
//    public R updateStatus(@PathVariable Integer id, @PathVariable Integer status) {
//        HospitalSet hospital = hospitalSetService.getById(id);
//        hospital.setStatus(status);
//        hospitalSetService.updateById(hospital);
//        return R.ok();
//    }

    //批量删除
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/delete")
    public R batchDelete(@RequestBody List<Integer> ids) {
        hospitalSetService.removeByIds(ids);
        return R.ok();
    }

    //修改之回显数据
    @ApiOperation(value = "数据回显")
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable Integer id) {
        return R.ok().data("item", hospitalSetService.getById(id));
    }

    //修改之修改数据
    @ApiOperation(value = "修改医院信息")
    @PutMapping("/update")
    public R update(@RequestBody HospitalSet hospitalSet) {
        hospitalSetService.updateById(hospitalSet);
        return R.ok();
    }

    @ApiOperation(value = "添加医院")
    @PostMapping("/save")
    public R save(@RequestBody HospitalSet hospitalSet) {
        //设置医院能否使用  1 启用   0 不启用  默认不启用
        hospitalSet.setStatus(0);
        //当前时间戳+随机数+MD5加密来生成sign_key
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000)));
        hospitalSetService.save(hospitalSet);
        return R.ok();
    }

    @ApiOperation(value = "分页查询")
    @PostMapping(value = "/page/{pageNum}/{size}")
    public R getPageInfo(@ApiParam(name = "pageNum", value = "当前页") @PathVariable Integer pageNum,
                         @ApiParam(name = "size", value = "每页显示多少条") @PathVariable Integer size,
                         @RequestBody HospitalSetQueryVo hospitalSetQueryVo) {

        Page<HospitalSet> page = new Page<HospitalSet>(pageNum, size);

        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<HospitalSet>();
        if (!StringUtils.isEmpty(hospitalSetQueryVo.getHosname())) {
            queryWrapper.like("hosname", hospitalSetQueryVo.getHosname());
        }
        if (!StringUtils.isEmpty(hospitalSetQueryVo.getHoscode())) {
            queryWrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }

        hospitalSetService.page(page, queryWrapper);
        return R.ok().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    @ApiOperation(value = "查询所有医院")
    @GetMapping(value = "/findAll")
    public R findAll() {
        List<HospitalSet> list = hospitalSetService.list();
        return R.ok().data("items", list);
    }

    //根据id删除医院设置信息(逻辑删除)  有MP的@TableLogic注解
    @ApiOperation(value = "根据id删除医院(逻辑删除)")
    @DeleteMapping(value = "/deleteById/{id}")
    public R deleteById(@PathVariable Integer id) {
        hospitalSetService.removeById(id);
        return R.ok();
    }
    //List<>
    /*=============================================
          @Api(tags=""):标记在接口类上
          @ApiOperation(value=""):标记在方法上
          @ApiParam(value=""):标记在参数上

          @ApiModel(description=")：对POJO类做说明
          @ApiModelProperty(value=")：对POJO类属性做说明
      ============================================*/
}

