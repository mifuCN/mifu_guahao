//根据芾医疗管理员后端复制过来的
import axios from 'axios'
import { MessageBox, Message, ColorPicker } from 'element-ui'
//引入js-cookie
import cookie from 'js-cookie'
// 创建axios实例
const service = axios.create({
    baseURL: 'http://localhost:8222',
    timeout: 15000 // 请求超时时间
})
// http 前端请求 拦截器
service.interceptors.request.use(
    config => {
    // token 先不处理，后续使用时在完善
    if(cookie.get('token')){
        //cookie本身不可以跨域处理的
        config.headers['token']= cookie.get('token');
    }
    return config
},
  err => {
    return Promise.reject(err)
})
// http 后端响应 拦截器
service.interceptors.response.use(
    response => {
        if (response.data.code !== 20000) {
            Message({
                message: response.data.message,
                type: 'error',
                duration: 5 * 1000
            })
            return Promise.reject(response.data)
        } else {
            return response.data
        }
    },
    error => {
        return Promise.reject(error.response)
})
export default service
