package com.mifu.yygh.order.controller;


import com.mifu.yygh.common.result.R;
import com.mifu.yygh.common.utils.JwtHelper;
import com.mifu.yygh.enums.OrderStatusEnum;
import com.mifu.yygh.model.order.OrderInfo;
import com.mifu.yygh.order.service.OrderInfoService;
import com.mifu.yygh.vo.order.OrderCountQueryVo;
import com.mifu.yygh.vo.order.OrderQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author mifu
 * @since 2022-09-08
 */
@RestController
@RequestMapping("/api/order/orderInfo")
public class OrderInfoController {


    @Autowired
    private OrderInfoService orderInfoService;



    @PostMapping("/statistics")
    public Map<String,Object> statistics(@RequestBody OrderCountQueryVo orderCountQueryVo){
        return orderInfoService.statistics(orderCountQueryVo);
    }

    @GetMapping("/cancel/{orderId}")
    public R cancelOrder(@PathVariable Long orderId){
        orderInfoService.cancelOrder(orderId);
        return R.ok();
    }

    @GetMapping("/{orderId}")
    public R detail(@PathVariable Long orderId){
        OrderInfo orderInfo = orderInfoService.detail(orderId);
        return R.ok().data("orderInfo",orderInfo);
    }

    @GetMapping("/list")
    public R getOrderList(){
        List<Map<String, Object>> statusList = OrderStatusEnum.getStatusList();
        return R.ok().data("list",statusList);
    }


    @GetMapping("/{pageNum}/{pageSize}")
    public R getOrderInfoPage(@PathVariable Integer pageNum,
                              @PathVariable Integer pageSize,
                              OrderQueryVo orderQueryVo,
                              @RequestHeader String token){

        Long userId = JwtHelper.getUserId(token);
        orderQueryVo.setUserId(userId);
        Page<OrderInfo>  page= orderInfoService.getOrderInfoPage(pageNum,pageSize,orderQueryVo);


        return R.ok().data("page",page);
    }


    @PostMapping("/{scheduleId}/{patientId}")
    public R  submitOrder(@PathVariable String scheduleId,
                          @PathVariable Long patientId){
       Long orderId= orderInfoService.submitOrder(scheduleId,patientId);

       return R.ok().data("orderId",orderId);
    }

}

