import en from '../i18n/lang/en'
import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import Layout from '@/views/layout/Layout'

// 不是必须加载的组件使用懒加载
Vue.use(Router)
const routeName = en.routeName
const defaultRouter = [
  {
    path: '/',
    redirect: '/login',
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
    iconCls: 'fa fa-dashboard', // 图标样式class
    name: routeName.home,
    component: Layout,
    alone: true,
    children: [
      {
        path: '/index',
        iconCls: 'fa fa-dashboard', // 图标样式class
        name: '主页',
        component: Login,
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
  // {
  //   path: '/',
  //   iconCls: 'el-icon-tickets', // 图标样式class
  //   name: routeName.article,
  //   component: Layout,
  //   children: [
  //     {
  //       path: '/addArticle',
  //       iconCls: 'el-icon-edit-outline', // 图标样式class
  //       name: routeName.publishArticle,
  //       component: '',
  //       children: []
  //     },
  //     {
  //       path: '/addArticleEditor',
  //       iconCls: 'el-icon-edit-outline', // 图标样式class
  //       name: routeName.publishArticleEditor,
  //       component: '',
  //       children: []
  //     }
  //   ]
  // },
  // {
  //   path: '/',
  //   iconCls: 'fa fa-universal-access', // 图标样式class
  //   name: routeName.permissions,
  //   component: Layout,
  //   children: [
  //     {
  //       path: '/pagePermissions',
  //       iconCls: 'fa fa-expeditedssl', // 图标样式class
  //       name: routeName.pageControl,
  //       component: '',
  //       children: []
  //     },
  //     {
  //       path: '/btnPermissions',
  //       iconCls: 'fa fa-toggle-on', // 图标样式class
  //       name: routeName.btnControl,
  //       component: '',
  //       children: []
  //     }
  //   ]
  // },
  // {
  //   path: '/',
  //   iconCls: 'fa fa-newspaper-o', // 图标样式class
  //   name: routeName.table,
  //   component: Layout,
  //   children: [
  //     {
  //       path: '/dataTable',
  //       iconCls: 'fa fa-sliders', // 图标样式class
  //       name: routeName.multiDataTable,
  //       component: '',
  //       children: []
  //     },
  //     {
  //       path: '/filterTable',
  //       iconCls: 'fa fa-sort-amount-asc', // 图标样式class
  //       name: routeName.filterTable,
  //       component: '',
  //       children: []
  //     },
  //     {
  //       path: '/dragTabe',
  //       iconCls: 'fa fa-hand-stop-o', // 图标样式class
  //       name: routeName.dragSort,
  //       component: '',
  //       children: []
  //     }
  //   ]
  // },

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
