import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/home/Home.vue'
import ReadView from '../views/story/ReadView.vue'
import BlogHome from '../views/blog/BlogHome.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    children: [
      {
        path: '/story',
        name: 'story',
        component: ReadView
      },
      {
        path: '/blog',
        name: 'blog',
        component: BlogHome
      },
      {
        path: '/game',
        name: 'game',
        component: ReadView
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
