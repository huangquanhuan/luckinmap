<template>
  <div>
    <el-card class="col box-card">
      <div slot="header" class="clearfix text-center">
        <h2>订单ID: <b>{{order.orderedId }}</b></h2>
      </div>
      <div class="row">
        <div class="col">
          <label>用户</label>
          <div>{{order.userId}}</div>
        </div>
        <div class="col">
          <label>订单状态</label>
          <div>
            <el-radio-group v-model="order.orderType">
              <el-radio v-if=" order.orderType=='SHOPCAR' " label="SHOPCAR">购物车态</el-radio>
              <el-radio v-if=" order.orderType=='WAIT' " label="WAIT">等待激活</el-radio>
              <el-radio v-if=" order.orderType=='SLOW' " label="SLOW">暂缓处理</el-radio>
              <el-radio v-if=" order.orderType=='QUICK' " label="QUICK">加急处理</el-radio>
              <el-radio v-if=" order.orderType=='DEAD' " label="DEAD">订单死亡</el-radio>
            </el-radio-group>
          </div>
        </div>

        <div class="col">
          <label>下单时间</label>
          <div>{{order.createTime}}</div>
        </div>
        <div class="col">
          <label>下单者</label>
          <div>{{order.creator}}</div>
        </div>
        <div class="col">
          <label>更新时间</label>
          <div>{{order.updateTime}}</div>
        </div>
        <div class="col">
          <label>更改者</label>
          <div>{{order.updater}}</div>
        </div>
        <div class="col">
          <label>订单备注</label>
          <div>{{order.note}}</div>
        </div>
      </div>
    </el-card>
    <br/>
    <div class="row">
      <div v-for="goods in orderGoods" class="text item">
        <el-card class="col box-card">
          <div slot="header" class="clearfix text-center">
            <span>下属商品: <b>{{goods.goodsId}}</b></span>
          </div>
          <el-form label-position="left" :model="goods" label-width="80px" class="border-radius">
            <el-form-item label="订单状态" prop="status">
              <el-radio-group v-model="goods.status" disabled>
                <el-radio v-if="goods.status=='OTHER'" label="OTHER">异常情况</el-radio>
                <el-radio v-else-if="goods.status=='UNPAID'" label="UNPAID">未付款</el-radio>
                <el-radio v-else-if="goods.status=='SENDING'" label="SENDING">已付款未发货</el-radio>
                <el-radio v-else-if="goods.status=='ARRIVED'" label="ARRIVED">已发货未送达</el-radio>
                <el-radio v-else-if="goods.status=='DEAD'" label="DEAD">已送达</el-radio>
                <el-radio v-else-if="goods.status=='SUCCESS'" label="SUCCESS">已确认收货</el-radio>
                <el-radio v-else-if="goods.status=='RETURNING'" label="RETURNING">退货中</el-radio>
                <el-radio v-else-if="goods.status=='RETURNED'" label="RETURNED">退货完成</el-radio>
              </el-radio-group>
            </el-form-item>

            <el-form-item label="手机号" prop="userPhone">
              <el-input placeholder="请输入手机号" v-model="goods.userPhone" disabled/>
            </el-form-item>
            <el-form-item label="用户昵称" prop="userName">
              <el-input placeholder="请输入用户昵称" v-model="goods.userName" disabled/>
            </el-form-item>
            <el-form-item label="价格" prop="nowPrice">
              <el-input v-model.number="goods.nowPrice" disabled></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="userAddress">
              <el-input placeholder="请输入地址" v-model="goods.userAddress" disabled/>
            </el-form-item>
            <el-form-item label="备注" prop="note">
              <el-input type="textarea" v-model="goods.note" disabled/>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
  import { getToken } from '@/utils/auth'

  export default {
    name: "OrderDetails",
    data() {
      return {
        order: {},
        orderGoods: []
      }
    },
    methods: {},
    created: function () {
      let oid = this.$route.query.id;
      console.log("取得参数" + oid);
      this.$store.dispatch('order/getDetails', oid).then((data) => {
        this.order = data.order;
        this.orderGoods = data.orderGoodsList.concat();
        console.log("取参");
        console.log(this.order.id);
        console.log(this.orderGoods[0].id);
      }).catch((err) => {
        console.log(err)
      })
    }
  }
</script>

<style scoped>
  el-label {
    width: 80px;
  }
</style>
