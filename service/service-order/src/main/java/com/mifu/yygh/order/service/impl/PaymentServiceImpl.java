package com.mifu.yygh.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifu.yygh.enums.PaymentStatusEnum;
import com.mifu.yygh.model.order.OrderInfo;
import com.mifu.yygh.model.order.PaymentInfo;
import com.mifu.yygh.order.mapper.PaymentMapper;
import com.mifu.yygh.order.service.PaymentService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, PaymentInfo> implements PaymentService {

    @Override
    public void savePaymentInfo(OrderInfo order, Integer paymentType) {
        QueryWrapper<PaymentInfo> queryWrapper = new QueryWrapper<PaymentInfo>();
        queryWrapper.eq("order_id", order.getId());
        PaymentInfo paymentInfo1 = baseMapper.selectOne(queryWrapper);
        if (paymentInfo1 != null) {
            return;
        }

        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setOutTradeNo(order.getOutTradeNo());
        paymentInfo.setOrderId(order.getId());
        paymentInfo.setPaymentType(paymentType);
        paymentInfo.setTotalAmount(order.getAmount());

        String subject = new DateTime(order.getReserveDate()).toString("yyyy-MM-dd") + "|" + order.getHosname() + "|" + order.getDepname() + "|" + order.getTitle();
        paymentInfo.setSubject(subject);
        paymentInfo.setPaymentStatus(PaymentStatusEnum.UNPAID.getStatus()); //支付状态
        baseMapper.insert(paymentInfo);
    }
}