package com.mifu.yygh.sms.service;

import com.mifu.yygh.vo.msm.MsmVo;

public interface SmsService {
    boolean sendCode(String phone);

    void sendMessage(MsmVo msmVo);
}
