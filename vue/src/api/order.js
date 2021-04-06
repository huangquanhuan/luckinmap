import request from '@/utils/request'


/**
 * 获取订单详情
 * @param id 订单id
 */
export function getDetails(id) {
  return request({
    url: '/order/getDetails',
    baseURL: '/api',
    method: 'get',
    params: id
  })
}

/**
 * 根据商品状态获取订单细则
 * @param status 商品状态
 */
export function getGoodsByStatus(status) {
  return request({
    url: '/order/getByStatusForSupple',
    baseURL: '/api',
    method: 'get',
    params: status
  })
}

/**
 * 更改订单为下一状态
 * @param ids 商品id集合字符串
 */
export function updateStatus(ids) {
  return request({
    url: '/order/updateStatus',
    baseURL: '/api',
    method: 'post',
    params: {ids}
  })
}

