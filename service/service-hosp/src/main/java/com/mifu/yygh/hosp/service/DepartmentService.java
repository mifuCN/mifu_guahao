package com.mifu.yygh.hosp.service;

import com.mifu.yygh.model.hosp.Department;
import com.mifu.yygh.vo.hosp.DepartmentVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    void saveDepartment(Map<String, Object> stringObjectMap);

    Page<Department> getDepartmentPage(Map<String, Object> stringObjectMap);

    void remove(Map<String, Object> stringObjectMap);

    List<DepartmentVo> getDepartmentList(String hoscode);

    String getDepName(String hoscode, String depcode);

    Department getDepartment(String hoscode, String depcode);
}
