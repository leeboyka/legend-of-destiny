import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import store from './store'
import i18n from './i18n/i18n'

import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { FontAwesomeIcon, FontAwesomeLayers, FontAwesomeLayersText } from '@fortawesome/vue-fontawesome'

library.add(fas, far, fab)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.component('font-awesome-layers', FontAwesomeLayers)
Vue.component('font-awesome-layers-text', FontAwesomeLayersText)

Vue.config.productionTip = false

Vue.use(ElementUI)

//  获取角色信息，根据用户权限动态加载路由
router.beforeEach((to, from, next) => {
  console.log(store.getters.token)
  console.log(to.path, from.path)
  if (store.getters.token) {
    store.dispatch('setToken', store.getters.token)
    if (to.path === '/login') {
      next({ path: '/' })
    } else {
      if (!store.getters.info.role) {
        // const role = ['/markdown', '/erji', '/erji2', '/siji', '/wuji']
        // eslint-disable-next-line no-unused-expressions
        !(async function getAddRouters () {
          // 省略 axios 请求代码 通过 token 向后台请求用户权限等信息，这里用假数据赋值
          await store.dispatch('getInfo', {
            role: 'superAdmin',
            permissions: '超级管理员'
          })
          await store.dispatch('newRoutes', store.getters.info.role)
          console.log(store.getters.addRouters)
          await router.addRoutes(store.getters.addRouters)
          next({ path: '/index' })
        }())
      } else {
        // let is404 = to.matched.some(record => {
        //   if (record.meta.role) {
        //     return record.meta.role.indexOf(store.getters.info.role) === -1
        //   }
        // })
        // if (is404) {
        //   next({ path: '/404' })
        //   return false
        // }
        next()
      }
    }
  } else {
    if (to.path === '/login') {
      next()
    }
    next({ path: '/login' })
  }
})

new Vue({
  router,
  store,
  i18n,
  render: h => h(App)
}).$mount('#app')
