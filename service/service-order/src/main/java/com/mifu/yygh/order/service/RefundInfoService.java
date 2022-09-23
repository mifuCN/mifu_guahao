package com.mifu.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mifu.yygh.model.order.PaymentInfo;
import com.mifu.yygh.model.order.RefundInfo;

//RefundInfoService
public interface RefundInfoService extends IService<RefundInfo> {
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}