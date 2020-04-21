import axios from 'axios'

const viewService = axios.create({
  baseURL: 'http://localhost:8080/', // api的base_url
  timeout: 5000, // 请求超时时间
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
  }
})

export const getChapterContent = params => {
  return viewService({
    url: '/static/story/' + params,
    method: 'get'
  })
}
