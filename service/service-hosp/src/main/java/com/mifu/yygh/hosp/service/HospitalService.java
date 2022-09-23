package com.mifu.yygh.hosp.service;

import com.mifu.yygh.model.hosp.Hospital;
import com.mifu.yygh.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface HospitalService {
    void saveHospital(Map<String, Object> resultMap);

    String getSignKeyWithHoscode(String requestHoscode);

    Hospital getHospitalByHoscode(String hoscode);

    Page<Hospital> getHospitalPage(Integer pageNum, Integer pageSize, HospitalQueryVo hospitalQueryVo);

    void updateStatus(String id, Integer status);

    Hospital detail(String id);

    List<Hospital> findByNameLike(String name);

    Hospital getHospitalDetail(String hoscode);
}
