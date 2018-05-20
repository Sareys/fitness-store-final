import Vue from 'vue'
import Router from 'vue-router'
import index from '@/sections/index'
import cart from '@/sections/cart'
import MenApparel from '@/sections/MenApparel'
import WomenApparel from '@/sections/WomenApparel'
import Supplements from '@/sections/Supplements'
import Accessories from '@/sections/Accessories'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/cart',
      name: 'cart',
      component: cart
    },
    {
      path: '/menApparel',
      name: 'menApparel',
      component: MenApparel
    },
    {
      path: '/womenApparel',
      name: 'womenApparel',
      component: WomenApparel
    }
    ,
    {
      path: '/accessories',
      name: 'accessories',
      component: Accessories
    },
    {
      path: '/supplements',
      name: 'supplements',
      component: Supplements
    }
  ]
})
