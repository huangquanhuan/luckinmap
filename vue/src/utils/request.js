import axios from 'axios'
import { MessageBox, Message } from 'element-ui'
import store from '@/store'
import { getToken } from '@/utils/auth'

// axios实例化
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url 在api处重写baseURL=/api分类跨域
  // withCredentials: true, // 在跨域请求时发送cookie
  timeout: 5000 // request timeout
})

// 请求拦截器
service.interceptors.request.use(
  config => {
    // 在发送请求之前

    if (store.getters.token) {
      // 让每个请求携带令牌
      // ['X-Token'] 是自定义标头密钥
      // 请根据实际情况进行修改
      config.headers['Token'] = getToken()
    }
    return config
  },
  error => {
    // 请求若是错误
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * 如果您想获取诸如标题或状态之类的http信息
   * 请返回response => response
  */

  /**
   * 通过自定义代码确定请求状态
   * 这只是一个示例
   * 您还可以通过HTTP状态代码判断状态
   */
  response => {
    const res = response.data

    // if the custom code is not 20000, it is judged as an error.
    if (res.status === false) {
      Message({
        message: res.message || 'Error',
        type: 'error',
        duration: 800
      })

      // 50008: token 错误; 50012: 其他客户端已登录 ; 50014: token 过期
      if (res.code === 50008 || res.code === 50012 || res.code === 50014) {
        // to re-login
        MessageBox.confirm('您已退出，可以取消此页面，或者重新登录', '确认注销', {
          confirmButtonText: '重新登录',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          store.dispatch('user/resetToken').then(() => {
            location.reload()
          })
        })
      }
      return Promise.reject(new Error(res.message || 'Error'))
    } else {
      return res
    }
  },
  error => {
    console.log('response拦截错误' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 800
    })
    return Promise.reject(error)
  }
)

export default service
