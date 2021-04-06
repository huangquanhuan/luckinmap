import Vue from 'vue'
// 一个流行的CSS重置的替代方案
import 'normalize.css/normalize.css'
// bootStrap-table 插件
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/extensions/filter-control/bootstrap-table-filter-control.css'
//引入jQuery
import $ from 'jquery'
window.jQuery = $
//引入bootstrap
import 'bootstrap/dist/js/bootstrap'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/dist/locale/bootstrap-table-zh-CN.min'
import '@/utils/tableExport.js'
import 'bootstrap-table/dist/extensions/export/bootstrap-table-export'
import 'bootstrap-table/dist/extensions/auto-refresh/bootstrap-table-auto-refresh'
import 'bootstrap-table/dist/extensions/filter-control/bootstrap-table-filter-control'

import Axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en' // lang i18n

import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

import '@/icons' // icon
import '@/permission' // permission control


// set ElementUI lang to EN
Vue.use(ElementUI, { locale })
// $XXX为自定义 在config中配跨域 使用this.$axios
Vue.prototype.$axios = Axios
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
