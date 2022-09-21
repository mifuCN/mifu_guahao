package com.mifu.yygh.order.service;

import com.mifu.yygh.model.order.PaymentInfo;
import com.mifu.yygh.model.order.RefundInfo;
import com.baomidou.mybatisplus.extension.service.IService;

//RefundInfoService
public interface RefundInfoService extends IService<RefundInfo> {
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}