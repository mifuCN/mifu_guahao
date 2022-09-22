package com.mifu.yygh.order.mapper;


import com.mifu.yygh.model.order.OrderInfo;
import com.mifu.yygh.vo.order.OrderCountQueryVo;
import com.mifu.yygh.vo.order.OrderCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author mifu
 * @since 2022-09-18
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    List<OrderCountVo> statistics(OrderCountQueryVo orderCountQueryVo);
}
