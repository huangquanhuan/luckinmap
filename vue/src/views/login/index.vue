<template>
  <div class="login-container bg">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on"
             label-position="left">

      <div class="title-container">
        <h3 class="title">{{ this.pageType?'欢迎登录':'欢迎注册'}}</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user"/>
        </span>
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password"/>
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          show-password
          @keyup.enter.native="handleLogin"
        />
      </el-form-item>

      <el-button :loading="loading" type="primary" style="width:47%;margin-bottom:30px;"
                 @click.native.prevent="handleLogin">确认
      </el-button>
      <el-button :loading="loading" type="primary" style="width:47%;margin-bottom:30px;"
                 @click.native.prevent="handleLogin">{{pageType?'去注册':'已有账号去登录'}}
      </el-button>

    </el-form>
  </div>
</template>

<script>
  import {validEmail, validUsername, validPassword} from '@/utils/validate'
  import md5 from 'js-md5'
  import qs from 'qs'

  export default {
    name: 'Login',
    data() {
      const validateUsername = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入用户名'));
        } else if (value === 'admin') {
          callback();
        } else if (!validUsername('' + value)) {
          callback(new Error('用户名 不得出现 .`~"?*<>/\\|'));
        } else if (!validEmail(value)) {
          callback(new Error('无效邮箱'));
        } else {
          callback();
        }
      };
      const validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.loginForm.password) {
          callback(new Error('两次密码不一致'));
        } else {
          callback();
        }
      }
      return {
        loginForm: {
          username: '',
          password: '',
          rePassword: ''
        },
        loginRules: {
          username: [{required: true, trigger: 'blur', validator: validateUsername}],
          password: [{required: true, trigger: 'blur', message: '请填入密码'}],
          rePassword: [{required: true, trigger: 'blur', message: '请再次填入密码', validator: validatePassword}]
        },
        loading: false,
        pageType: true,
        passwordType: 'password',
        redirect: undefined
      }
    },
    watch: {
      $route: {
        handler: function (route) {
          this.redirect = route.query && route.query.redirect
        },
        immediate: true
      }
    },
    methods: {
      showPwd() {
        if (this.passwordType === 'password') {
          this.passwordType = ''
        } else {
          this.passwordType = 'password'
        }
        this.$nextTick(() => {
          this.$refs.password.focus()
        })
      },
      async handleLogin() {
        await this.$refs.loginForm.validate(valid => {
          if (valid) {
            console.log("验证成功");
            this.loading = true;
            let params = {
              username: this.loginForm.username,
              password: md5(this.loginForm.password)
            }
            this.$store.dispatch('user/login', params).then(() => {
              console.log("登录成功");
              this.$router.push({path: this.redirect || '/'})
              this.loading = false
            }).catch(() => {
              console.log('error login!')
              this.loading = false
            })
          } else {
            console.log('error submit!')
            return false
          }
        })
      }
    }
  }
</script>

<style lang="scss">
  .bg {
    background: url('../../assets/back.jpg') no-repeat center fixed;
     background-position: center 0;
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
     -webkit-background-size: cover;
     -o-background-size: cover;
     -moz-background-size: cover;
     -ms-background-size: cover;
  }

  /* 修复input 背景不协调 和光标变色 */
  /* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

  $bg: #1F3F83;
  $light_gray: #fff;
  $cursor: #fff;

  @supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login-container .el-input input {
      color: $cursor;
    }
  }

  /* reset element-ui css */
  .login-container {
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;

      input {
        background: transparent;
        border: 0px;
        -webkit-appearance: none;
        border-radius: 0px;
        padding: 12px 5px 12px 15px;
        color: $light_gray;
        height: 47px;
        caret-color: $cursor;

        &:-webkit-autofill {
          box-shadow: 0 0 0px 1000px $bg inset !important;
          -webkit-text-fill-color: $cursor !important;
        }
      }
    }

    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
  }
</style>

<style lang="scss" scoped>
  $bg: #2d3a4b;
  $dark_gray: #000;
  $light_gray: #eee;

  .login-container {
    min-height: 100%;
    width: 100%;
    background-color: $bg;
    overflow: hidden;

    .login-form {
      position: relative;
      width: 520px;
      max-width: 100%;
      padding: 160px 35px 0;
      margin: 0 auto;
      overflow: hidden;
    }

    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;

      span {
        &:first-of-type {
          margin-right: 16px;
        }
      }
    }

    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
    }

    .title-container {
      position: relative;

      .title {
        font-size: 26px;
        color: $light_gray;
        margin: 0px auto 40px auto;
        text-align: center;
        font-weight: bold;
      }
    }

    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
      user-select: none;
    }
  }
</style>
