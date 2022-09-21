import request from '@/utils/request'

export default {
    getHospitalList(searchObj) {
        return request({
          url: '/user/hosp/hospital/list',
          method: 'get',
          params:searchObj
        })
    },
   
    findByName(name) {
        return request({
          url: `/user/hosp/hospital/${name}`,
          method: 'get'
        })
    },
    show(hoscode) {
      return request({
        url: `/user/hosp/hospital/detail/${hoscode}`,
        method: 'get'
      })
  },
  findDepartment(hoscode){
    return request({
      url: `/user/hosp/department/all/${hoscode}`,
      method: 'get'
    })
  }
      
}
