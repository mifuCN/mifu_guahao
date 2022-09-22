package com.mifu.yygh.order.service;


import com.mifu.yygh.model.order.OrderInfo;
import com.mifu.yygh.vo.order.OrderCountQueryVo;
import com.mifu.yygh.vo.order.OrderQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author mifu
 * @since 2022-09-18
 */
public interface OrderInfoService extends IService<OrderInfo> {

    Long submitOrder(String scheduleId, Long patientId);

    Page<OrderInfo> getOrderInfoPage(Integer pageNum, Integer pageSize, OrderQueryVo orderQueryVo);

    OrderInfo detail(Long orderId);

    void cancelOrder(Long orderId);

    void patientRemind();

    Map<String, Object> statistics(OrderCountQueryVo orderCountQueryVo);
}
