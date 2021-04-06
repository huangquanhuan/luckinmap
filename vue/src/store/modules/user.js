import { login, logout, getInfo, getDetails } from '@/api/user'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'

const state = {
  token: getToken(),
  name: '',
  roles: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  }
}

const actions = {
  // 用户登录
  login({ commit }, userInfo) {
    const { username, password } = userInfo;
    return new Promise((resolve, reject) => {
      console.log("返回Promise");
      login( username,password ).then(response => {
        console.log("获取登录返回值" + response);
        const { data } = response;
        commit('SET_TOKEN', data);
        setToken(data);
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // 获取用户信息
   getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      getInfo(state.token).then(response => {
        const { data} = response;
        if (!data) {
          reject('验证失败，请再次登录。')
        }
        const { name,roleId } = data;
        commit('SET_NAME', name);
        commit('SET_ROLES' +
          '', roleId);
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // 用户退出
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        commit('SET_TOKEN', '');
        removeToken();
        resetRouter();
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      commit('SET_TOKEN', '');
      removeToken()
      resolve()
    })
  },

  // 获取用户详情
  getDetails( { commit }, oid ) {
    return new Promise((resolve, reject) => {
      let params= {
        id: oid
      };
      getDetails(params).then(response => {
        const { data} = response;

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
  state,
  mutations,
  actions
}

