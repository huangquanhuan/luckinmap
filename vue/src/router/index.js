import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: {title: '主页', icon: 'dashboard'}
    }]
  },

  {
    path: '/order',
    component: Layout,
    redirect: '/order/index',
    name: '订单',
    meta: {
      title: '订单',
      icon: 'tree'
    },
    children: [
      {
        path: 'index',
        name: 'Order',
        component: () => import('@/views/order/index'),
        meta: {title: '订单管理', icon: 'form'}
      },
      {
        path: 'Order',
        name: 'OrderDetail',
        component: () => import('@/views/order/orderDetails'),
        meta: {title: '订单详情', icon: 'form'},
        hidden: true
      },

      {
        path: 'OrderGoodsTab',
        name: 'OrderGoodsTab',
        component: () => import('@/views/order/orderGoodsTab'),
        meta: {title: '订单细则', icon: 'form'}
      }

    ]
  },

  {
    path: '/goods',
    component: Layout,
    redirect: '/goods/index',
    name: '商品',
    meta: {
      title: '商品',
      icon: 'nested'
    },
    children: [
      {
        path: 'index',
        name: 'Goods',
        component: () => import('@/views/goods/index'),
        meta: {title: '商品管理', icon: 'form'}
      },
      {
        path: 'GoodsType',
        name: 'GoodsType',
        component: () => import('@/views/goods/goodsType'),
        meta: {title: '商品类别', icon: 'form'}
      },
      {
        path: 'SuppleGoods',
        name: 'SuppleGoods',
        component: () => import('@/views/goods/suppleGoods'),
        meta: {title: '分销管理', icon: 'form'}
      },
    ]
  },

  {
    path: '/integral',
    component: Layout,
    redirect: '/integral/index',
    name: '积分',
    meta: {
      title: '积分',
      icon: 'link'
    },
    children: [
      {
        path: '/index',
        name: 'Integral',
        component: () => import('@/views/integral/index'),
        meta: {title: '积分管理', icon: 'eye'}
      }
    ]
  }
]


/**
 * 异步路由
 * 需要根据用户角色动态加载的路由
 */
export const asyncRoutes = [

  {
    path: '/user',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'User',
        component: () => import('@/views/user/index'),
        meta: {title: '人员管理', icon: 'form', roles: ['3']}
      }, {
        path: 'UserDetails',
        name: 'UserDetails',
        component: () => import('@/views/user/userDetails'),
        meta: {title: '人员详情', icon: 'form', roles: ['3']},
        hidden: true
      }
    ]
  },

  // 404 page must be placed at the end !!!
  {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
  // require service support
  mode: 'history',
  base: 'luckinmap',
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
