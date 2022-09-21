package com.mifu.yygh.user.client;

import com.mifu.yygh.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-user")
public interface PatientFeignClient {

    @GetMapping("/user/userinfo/patient/{patientId}")
    public Patient getPatientById(@PathVariable("patientId") Long patientId);
}
