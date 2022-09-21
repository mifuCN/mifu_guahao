import request from '@/utils/request'

export default {
    login(obj) {
        return request({
          url: `/user/userinfo/login`,
          method: 'post',
          data:obj
        })
    },
    getUserInfo() {
      return request({
        url: `/user/userinfo/info`,
        method: 'get'
      })
   },
  saveUserAuah(obj){
    return request({
      url: `/user/userinfo/update`,
      method: 'put',
      params:obj
    })
  }
      
}
