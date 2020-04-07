import axios from 'axios'
import qs from 'qs'
import { Message, Loading } from 'element-ui'

/** **** 创建axios实例 ******/
const service = axios.create({
  baseURL: window.global.HOST, // api的base_url
  timeout: 5000, // 请求超时时间
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
  }
})

// 定义loading变量
let loading
// 定义loadingRequestCount变量,记录当前页面总共请求的次数
let loadingRequestCount = 0

/** **显示loading的函数 并且记录请求次数***/
const showLoading = () => {
  if (loadingRequestCount === 0) {
    loading = Loading.service({
      lock: true,
      text: '加载中……',
      background: 'rgba(0, 0, 0, 0.7)'
    })
  }
  loadingRequestCount++
}

/** *隐藏loading的函数，并且记录请求次数***/
const hideLoading = () => {
  if (loadingRequestCount <= 0) return
  loadingRequestCount--
  if (loadingRequestCount === 0) {
    loading.close()
  }
}

/** **** request拦截器==>对请求参数做处理 ******/
service.interceptors.request.use(config => {
  showLoading(config)

  config.method === 'post'
    ? config.data = qs.stringify({ ...config.data })
    : config.params = { ...config.params }
  config.headers['Content-Type'] = 'application/x-www-form-urlencoded'
  return config
}, error => { // 请求错误处理
  Promise.reject(error)
})

/** **** response拦截器==>对响应做处理 ******/
service.interceptors.response.use(response => { // 成功请求到数据
  // 响应拦截进来隐藏loading效果
  setTimeout(() => {
    // 此处采用延时处理是合并loading请求效果，避免loading闪烁
    hideLoading()
  }, 200)
  return response.data
  // 这里根据后端提供的数据进行对应的处理，需要后台提供标准的数据返回结构
  // if (response.data.code === 'TRUE') {
  //   return response.data;
  // } else {
  //   Message({
  //     showClose: true,
  //     message: response.data.message,
  //     type: "error"
  //   });
  // }
}, error => {
  setTimeout(() => {
    hideLoading()
  }, 200)
  // 响应错误处理
  if (error.response.status === 403) {
    Message({
      showClose: true,
      message: '403 Forbidden：禁止访问',
      type: 'error'
    })
  } else if (error.response.status === 404) {
    Message({
      showClose: true,
      message: '404 Not Found：未找到相关页面资源',
      type: 'error'
    })
  } else if (error.response.status === 500) {
    Message({
      showClose: true,
      message: '500 Internal Server Error：服务器内部有异常错误，无法完成请求',
      type: 'error'
    })
  } else if (error.response.status === 502) {
    Message({
      showClose: true,
      message: '502 BadGateway：请求因HTTP状态502失败',
      type: 'error'
    })
  }
  return Promise.reject(error)
})

export default service
