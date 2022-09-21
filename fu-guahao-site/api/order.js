import request from '@/utils/request'

export default {
    submitOrder(scheduleId,patientId) {
        return request({
          url: `/api/order/orderInfo/${scheduleId}/${patientId}`,
          method: 'post'
        })
    },
    getPageList(pageNum,pageSize,searchObj) {
      return request({
        url: `/api/order/orderInfo/${pageNum}/${pageSize}`,
        method: 'get',
        params:searchObj
      })
    },
    getStatusList() {
      return request({
        url: `/api/order/orderInfo/list`,
        method: 'get'
      })
    },
    detail(orderId) {
      return request({
        url: `/api/order/orderInfo/${orderId}`,
        method: 'get'
      })
    },
    cancelOrder(orderId) {
      return request({
        url: `/api/order/orderInfo/cancel/${orderId}`,
        method: 'get'
      })
    }
      
}
