/**
 * 是否是有效连接
 * @param {string} path 路径
 * @returns {Boolean} true 是|false 否
 */
export function isExternal(path) {
  const reg = /^(https?:|mailto:|tel:)/;
  return reg.test(path)
}

/**
 * 是否是规定的用户名 不得出现 .`~"?*<>/\|
 * @param {string} str 用户名
 * @returns {Boolean} true 有效 |false 非法
 */
export function validUsername (str) {
  const reg = /^[.`~"?*<>/\|]+/;
  return !reg.test(str)
}

/**
 * 是否是规定的密码 出现数字和字母，不得小于6位
 * @param {string} str 密码
 * @returns {Boolean} true 是|false 否
 */
export function validPassword(str) {
  return str.length >= 6 & /^[a-zA-Z]+/.test(str) || /^[0-9]+/.test(str)
}

/**
 * 是否是性别
 * @param {string} sex 性别
 * @returns {Boolean} true 是|false 否
 */
export function validSex(sex) {
  return sex == '男' || sex == '女' || sex == 'man' || sex == 'woman' || sex == "MAN" || sex == "WOMAN";
}

/**
 * 是否是邮件地址
 * @param {string} email 邮件地址
 * @returns {Boolean} true 是|false 否
 */
export function validEmail(email) {
  const reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return reg.test(email)
}

/**
 * 是否为网络连接
 * @param {string} url 网络连接
 * @returns {Boolean} true 是|false 否
 */
export function validURL(url) {
  const reg = /^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/;
  return reg.test(url)
}

/**
 * 是否全小写字母
 * @param {string} str 字符串
 * @returns {Boolean} true 是|false 否
 */
export function validLowerCase(str) {
  const reg = /^[a-z]+$/;
  return reg.test(str)
}

/**
 * 是否全大写字母
 * @param {string} str 字符串
 * @returns {Boolean} true 是|false 否
 */
export function validUpperCase(str) {
  const reg = /^[A-Z]+$/;
  return reg.test(str)
}

/**
 * 是否全英文
 * @param {string} str 字符串
 * @returns {Boolean} true 是|false 否
 */
export function validAlphabets(str) {
  const reg = /^[A-Za-z]+$/;
  return reg.test(str)
}


/**
 * 是否是字符串
 * @param {string} str 字符串
 * @returns {Boolean} true 是|false 否
 */
export function isString(str) {
  return typeof str === 'string' || str instanceof String;
}


/**
 * 是否是数组
 * @param {Array} arg 传入参数
 * @returns {Boolean} true 是|false 否
 */
export function isArray(arg) {
  if (typeof Array.isArray === 'undefined') {
    return Object.prototype.toString.call(arg) === '[object Array]'
  }
  return Array.isArray(arg)
}


