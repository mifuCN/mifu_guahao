package com.mifu.yygh.statistic.controller;

import com.mifu.yygh.common.result.R;
import com.mifu.yygh.statistic.service.StatisticsService;
import com.mifu.yygh.vo.order.OrderCountQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin/statistic")
public class StatisticsController {


    @Autowired
    private StatisticsService statisticsService;



    @GetMapping("/countByDate")
    public R statistics(OrderCountQueryVo orderCountQueryVo){
        Map<String,Object> map=statisticsService.statistics(orderCountQueryVo);
        return R.ok().data(map);
    }
}
