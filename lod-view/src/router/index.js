import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/home/Home.vue'
import BlogHome from '../views/blog/BlogHome.vue'
import StoryHome from '../views/story/StoryHome.vue'
import ReadView from '../views/story/read/ReadView.vue'

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
        component: StoryHome
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
