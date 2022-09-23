package com.mifu.yygh.order.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mifu.yygh.model.order.OrderInfo;
import com.mifu.yygh.vo.order.OrderCountQueryVo;
import com.mifu.yygh.vo.order.OrderCountVo;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderCountVo> statistics(OrderCountQueryVo orderCountQueryVo);
}
