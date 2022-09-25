package com.mifu.yygh.sms.service.impl;

import com.mifu.yygh.sms.service.SmsService;
import com.mifu.yygh.sms.utils.HttpUtils;
import com.mifu.yygh.sms.utils.RandomUtil;
import com.mifu.yygh.vo.msm.MsmVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean sendCode(String phone) {
        String redisCode = (String) redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(redisCode)) {
            return true;
        }
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "38c3a98dfc8d4d51a1ffd3c820bffbc3";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);

        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);

        String fourBitRandom = RandomUtil.getFourBitRandom();
        querys.put("param", "code:" + fourBitRandom);

        querys.put("tpl_id", "TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));

            //把验证码保存redis中一份
            log.info("code = {}", fourBitRandom);
            redisTemplate.opsForValue().set(phone, fourBitRandom, 1, TimeUnit.MINUTES);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void sendMessage(MsmVo msmVo) {
        String phone = msmVo.getPhone();
        //阿里云发送短信提示：个人用户
        //模板 //模板参数
        System.out.println("给就诊人发送短信提示成功");
    }


}
