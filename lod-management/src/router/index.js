import en from '../i18n/lang/en'
import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import Layout from '@/views/layout/Layout'
import Home from '@/views/home/Home'

// 不是必须加载的组件使用懒加载
Vue.use(Router)
const routeName = en.routeName
const defaultRouter = [
  {
    path: '/',
    redirect: '/index',
    hidden: true,
    children: []
  },
  {
    path: '/login',
    component: Login,
    name: '',
    hidden: true,
    children: []
  },
  {
    path: '/index',
    iconNameAwesome: 'home', // 图标样式class
    name: routeName.home,
    component: Layout,
    alone: true,
    children: [
      {
        path: '/index',
        iconNameAwesome: 'home', // 图标样式class
        name: '主页',
        component: Home,
        children: []
      }
    ]
  }
  // {
  //   path: '/404',
  //   component: '',
  //   name: '404',
  //   hidden: true,
  //   children: []
  // }
]

const addRouter = [
  {
    path: '/',
    iconNameAwesome: 'file-signature', // 图标样式class
    name: routeName.article,
    component: Layout,
    children: [
      {
        path: '/addArticle',
        iconNameAwesome: 'file-signature', // 图标样式class
        name: routeName.publishArticle,
        component: Login,
        children: []
      },
      {
        path: '/addArticleEditor',
        iconNameAwesome: 'file-signature', // 图标样式class
        name: routeName.publishArticleEditor,
        component: Layout,
        children: []
      }
    ]
  },
  {
    path: '/',
    iconNameAwesome: 'user-cog', // 图标样式class
    name: routeName.permissions,
    component: Layout,
    children: [
      {
        path: '/pagePermissions',
        iconNameAwesome: 'home', // 图标样式class
        name: routeName.pageControl,
        component: Login,
        children: []
      },
      {
        path: '/btnPermissions',
        iconNameAwesome: 'fa fa-toggle-on', // 图标样式class
        name: routeName.btnControl,
        component: Login,
        children: []
      }
    ]
  },
  {
    path: '/',
    iconNameAwesome: 'th-list', // 图标样式class
    name: routeName.table,
    component: Layout,
    children: [
      {
        path: '/dataTable',
        iconNameAwesome: 'fa fa-sliders', // 图标样式class
        name: routeName.multiDataTable,
        component: Login,
        children: []
      },
      {
        path: '/filterTable',
        iconNameAwesome: 'fa fa-sort-amount-asc', // 图标样式class
        name: routeName.filterTable,
        component: Login,
        children: []
      },
      {
        path: '/dragTabe',
        iconNameAwesome: 'fa fa-hand-stop-o', // 图标样式class
        name: routeName.dragSort,
        component: Login,
        children: []
      }
    ]
  },
  {
    path: '*',
    redirect: '/404',
    hidden: true,
    children: []
  }

]
export default new Router({
  routes: defaultRouter
})
export { defaultRouter, addRouter }
