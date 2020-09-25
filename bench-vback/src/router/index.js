import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import element from 'element-ui'
// 导入自己编写的组件
import Login from "../components/Login";
import Appindex from "../components/home/Appindex";
import Home from "../components/Home";

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      //暂不需要访问Home页面
      redirect:'/index',
      children: [
        {
          path: '/index',
          name: 'Appindex',
          component: Appindex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
  ]
})
