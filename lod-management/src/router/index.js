import en from '../i18n/lang/en'
import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import Layout from '@/views/layout/Layout'
import Menu from '@/views/privilege/Menu'
import Permission from '@/views/privilege/Permission'
import Home from '@/views/home/Home'
import Member from '@/views/user/Member'
import GroupRole from '@/views/user/GroupRole'

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
    iconNameAwesome: 'users', // 图标样式class
    name: routeName.user,
    component: Layout,
    children: [
      {
        path: '/member',
        iconNameAwesome: 'user-plus', // 图标样式class
        name: routeName.member,
        component: Member,
        children: []
      },
      {
        path: '/groupRole',
        iconNameAwesome: 'user-secret', // 图标样式class
        name: routeName.groupRole,
        component: GroupRole,
        children: []
      }
    ]
  },
  {
    path: '/',
    iconNameAwesome: 'users-cog', // 图标样式class
    name: routeName.privilege,
    component: Layout,
    children: [
      {
        path: '/menu',
        iconNameAwesome: 'th-large', // 图标样式class
        name: routeName.menu,
        component: Menu,
        children: []
      },
      {
        path: '/permission',
        iconNameAwesome: 'user-cog', // 图标样式class
        name: routeName.permission,
        component: Permission,
        children: []
      }
    ]
  },
  {
    path: '/',
    iconNameAwesome: 'cogs', // 图标样式class
    name: routeName.systemSettings,
    component: Layout,
    children: [
      {
        path: '/menu',
        iconNameAwesome: 'th-large', // 图标样式class
        name: routeName.menu,
        component: Menu,
        children: []
      },
      {
        path: '/permission',
        iconNameAwesome: 'user-cog', // 图标样式class
        name: routeName.permission,
        component: Permission,
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
