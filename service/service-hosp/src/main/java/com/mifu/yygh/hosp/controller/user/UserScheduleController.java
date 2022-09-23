package com.mifu.yygh.hosp.controller.user;

import com.mifu.yygh.common.result.R;
import com.mifu.yygh.hosp.service.ScheduleService;
import com.mifu.yygh.model.hosp.Schedule;
import com.mifu.yygh.vo.hosp.ScheduleOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/hosp/schedule")
public class UserScheduleController {


    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/{scheduleId}")
    public ScheduleOrderVo getScheduleById(@PathVariable(value = "scheduleId") String scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }

    //根据排班id获取排班信息
    @GetMapping("/info/{scheduleId}")
    public R getScheduleInfo(@PathVariable String scheduleId) {
        Schedule schedule = scheduleService.getScheduleInfo(scheduleId);
        return R.ok().data("schedule", schedule);
    }


    @GetMapping("/{hoscode}/{depcode}/{pageNum}/{pageSize}")
    public R getSchedulePage(@PathVariable String hoscode,
                             @PathVariable String depcode,
                             @PathVariable Integer pageNum,
                             @PathVariable Integer pageSize) {

        Map<String, Object> map = scheduleService.getSchedulePageByCondition(hoscode, depcode, pageNum, pageSize);
        return R.ok().data(map);
    }


    @GetMapping("/{hoscode}/{depcode}/{workdate}")
    public R getScheduleDetail(@PathVariable String hoscode,
                               @PathVariable String depcode,
                               @PathVariable String workdate) {

        List<Schedule> details = scheduleService.detail(hoscode, depcode, workdate);

        return R.ok().data("details", details);
    }
}
