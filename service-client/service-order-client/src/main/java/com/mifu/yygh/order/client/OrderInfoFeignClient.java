package com.mifu.yygh.order.client;

import com.mifu.yygh.vo.order.OrderCountQueryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(value = "service-order")
public interface OrderInfoFeignClient {

    @PostMapping("/api/order/orderInfo/statistics")
    public Map<String, Object> statistics(@RequestBody OrderCountQueryVo orderCountQueryVo);

}
