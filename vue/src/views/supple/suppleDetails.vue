<template>
  <div>
    <el-card class="col box-card">
      <div slot="header" class="clearfix text-center">
        <h2>供应商<b>{{user.name }}</b></h2>
      </div>
      <div class="row">
        <div class="col">
          <label>邮箱</label>
          <div>{{user.mail}}</div>
        </div>
        <div class="col">
          <label>联系方式</label>
          <div>{{user.phone}}</div>
        </div>
        <div class="col">
          <label>积分</label>
          <div>{{user.integral}}</div>
        </div>
        <div class="col">
          <label>权限等级</label>
          <div>{{user.roleId}}</div>
        </div>
        <div class="col">
          <label>创建时间</label>
          <div>{{user.createTime}}</div>
        </div>
        <div class="col">
          <label>创建者</label>
          <div>{{user.creator}}</div>
        </div>
        <div class="col">
          <label>更新时间</label>
          <div>{{user.updateTime}}</div>
        </div>
        <div class="col">
          <label>更改者</label>
          <div>{{user.updater}}</div>
        </div>
      </div>
    </el-card>
    <br/>
    <div class="row">
      <div v-for="address in addressList" class="text item">
        <el-card class="col box-card">
          <div slot="header" class="clearfix text-center">
            <span>地址: <b>{{address.id}}</b></span>
          </div>
          <el-form label-position="left" :model="goods" label-width="80px" class="buser-radius">
            <el-form-item label="ID" prop="ID">
              <el-input v-model="address.id" disabled/>
            </el-form-item>
            <el-form-item label="城市邮编" prop="areaId">
              <el-input v-model.number="address.areaId" disabled/>
            </el-form-item>
            <el-form-item label="详细地址" prop="address">
              <el-input v-model="address.address" maxLength="120" disabled/>
            </el-form-item>
            <el-form-item label="联系方式" prop="phone">
              <el-input v-model="address.phone" maxLength="20" disabled/>
            </el-form-item>
            <el-form-item label="地址类型" prop="ownerType">
              <el-radio-group v-model="address.ownerType.toString()">
                <el-radio v-if="address.ownerType==1" label="1">用户地址</el-radio>
                <el-radio v-if="address.ownerType==2" label="2">商家地址</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
  import {getSuppleDetails} from '@/api/user'
  import { getToken } from '@/utils/auth'

  export default {
    name: "SuppleDetails",
    data() {
      return {
        user: {},
        addressList: []
      }
    },
    methods: {},
    mounted: function () {
      let uid = this.$route.query.id;
      console.log("取得参数" + uid);
      let params = { id: uid }
      getSuppleDetails(params).then( (response) => {
        const {data} = response;
        this.user = data.supple;
        this.addressList = data.addressList.concat();
      }).catch( (err) => {
        console.log(err)
      });
      // this.$store.dispatch('user/getDetails', uid).then((data) => {
      //   this.user = data.supple;
      //   this.addressList = data.addressList.concat();
      // }).catch((err) => {
      //   console.log(err)
      // })
    }
  }
</script>

<style scoped>
</style>
