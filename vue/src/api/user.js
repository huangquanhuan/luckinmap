import request from '@/utils/request'

export function login(username,password  ) {
  return request({
    url: '/supple/login',
    baseURL: '/api',
    method: 'get',
    params: {username, password}
  })
}

export function getInfo(token) {
  return request({
    url: '/supple/getInfo',
    baseURL: '/api',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/supple/logout',
    baseURL: '/api',
    method: 'post'
  })
}

export function getDetails(id) {
  return request({
    url: '/user/getDetails',
    baseURL: '/api',
    method: 'get',
    params: id
  })
}

export function getSuppleDetails(id) {
  return request({
    url: '/supple/getDetails',
    baseURL: '/api',
    method: 'get',
    params: id
  })
}

