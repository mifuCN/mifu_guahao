import request from '@/utils/request'

export default {
    getSchedulePage(hoscode,depcode,pageNum,pageSize) {
        return request({
          url: `/user/hosp/schedule/${hoscode}/${depcode}/${pageNum}/${pageSize}`,
          method: 'get'
        })
    },
    getScheduleDetail(hoscode,depcode,workdate) {
        return request({
          url: `/user/hosp/schedule/${hoscode}/${depcode}/${workdate}`,
          method: 'get'
        })
    },
    getSchedule(scheduleId) {
        return request({
          url: `/user/hosp/schedule/info/${scheduleId}`,
          method: 'get'
        })
    },
      
}
