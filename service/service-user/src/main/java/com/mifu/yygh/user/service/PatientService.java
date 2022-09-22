package com.mifu.yygh.user.service;


import com.mifu.yygh.model.user.Patient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 就诊人表 服务类
 * </p>
 *
 * @author mifu
 * @since 2022-09-16
 */
public interface PatientService extends IService<Patient> {

    List<Patient> findAll(String token);

    Patient detail(Long id);

    List<Patient> selectList(QueryWrapper<Patient> queryWrapper);
}
