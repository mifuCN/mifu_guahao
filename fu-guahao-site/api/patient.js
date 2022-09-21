import request from '@/utils/request'

export default {
    getPatientList() {
        return request({
          url: `/user/userinfo/patient/all`,
          method: 'get'
        })
    },
    save(obj) {
        return request({
          url: `/user/userinfo/patient/save`,
          method: 'post',
          data: obj
        })
    },
    detail(id) {
      return request({
        url: `/user/userinfo/patient/detail/${id}`,
        method: 'get'
      })
    },
    removeById(id) {
      return request({
        url: `/user/userinfo/patient/delete/${id}`,
        method: 'delete'
      })
    },
    updateById(obj) {
      return request({
        url: `/user/userinfo/patient/update`,
        method: 'put',
        data:obj
      })
    }

      
}
