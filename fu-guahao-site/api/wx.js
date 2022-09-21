import request from '@/utils/request'

export default {
    getWeixinParam() {
        return request({
          url: `/user/userinfo/wx/param`,
          method: 'get'
        })
    },
    createNative(orderId) {
      return request({
        url: `/user/order/weixin/${orderId}`,
        method: 'get'
      })
  },
  queryPayStatus(orderId){
    return request({
      url: `/user/order/weixin/status/${orderId}`,
      method: 'get'
    })
  }
      
}
