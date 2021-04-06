import { getDetails } from '@/api/order'
import qs from 'qs'



const actions = {

  // 获取用户信息
  getDetails( { commit }, oid ) {
    return new Promise((resolve, reject) => {
      let params= {
        id: oid
      }
      getDetails(params).then(response => {
        const { data} = response
        if (!data) {
          reject('验证失败，请再次登录。')
        }
        console.log("返回数据成功"+data);
        // this.$router.push({path: '/order/details'})
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },



}

export default {
  namespaced: true,
  actions
}

