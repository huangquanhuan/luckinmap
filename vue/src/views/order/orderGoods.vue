<template>
  <div class="app-container">
    <div class="panel panel-default">
      <div class="panel-body">
        <div id="toolbar" class="btn-group">
          <!--<button id="btn_add" class="btn btn-info btn-sm rightSize"
                  @click="addButton" data-toggle="modal" data-target="#viewModal">
            <i class="el-icon-plus"></i>&nbsp;新增
          </button>-->
          <button class="btn btn-info btn-sm rightSize"
                  @click="updateButton" data-toggle="modal" data-target="#viewModal">
            <i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;修改
          </button>
          <button @click="removeButton" class="btn btn-info btn-sm rightSize">
            <i class="el-icon-delete"></i>&nbsp;删除
          </button>
        </div>
        <table id="viewTable"
               class="table table-striped table-bordered">
          <thead>
          <tr>
            <th data-checkbox="true"></th>
            <th data-field="id">ID</th>
            <th data-field="goodsId">商品ID</th>
            <th data-field="suppleId" data-visible="false">供应商ID</th>
            <th data-field="userId" data-visible="false">用户ID</th>
            <th data-field="statusString" data-sortable="true">订单状态</th>
            <th data-field="nowPrice" data-sortable="true">购买时价格</th>
            <th data-field="userName">购买人名称</th>
            <th data-field="nowPrice">购买时价格</th>
            <th data-field="userPhone">购买时电话</th>
            <th data-field="userAddress">购买时地址</th>
            <th data-field="note" data-editable="true">备注</th>
            <th data-field="remarks">评论</th>
            <th data-field="createTime" data-sortable="true">下单时间</th>
            <th data-field="creator" data-visible="false">下单者</th>
            <th data-field="updateTime" data-sortable="true">状态更新时间</th>
            <th data-field="updater" data-visible="false">更改者</th>
          </tr>
          </thead>
        </table>
      </div>
    </div>
    <!-- 弹窗 -->
    <div v-if="viewModal.modalTitle != 'hide' " class="modal fade" id="viewModal" tabindex="-1" role="dialog">
      <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
          <!-- element-ui ：rules引入data()中的规则 -->
          <el-form label-position="left" ref="viewModal" :model="viewModal" :rules="rules" autocomplete="off"
                   label-width="80px">
            <div class="modal-header">
              <h3 class="modal-title">{{ viewModal.modalTitle ? "修改" : "新建" }}</h3>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
              <!-- element-ui 中prop设置需要验证的字段名 -->
              <el-form-item v-if="viewModal.modalTitle" inline="true" label="ID" prop="ID">
                <el-input v-model="viewModal.id" disabled/>
              </el-form-item>
              <el-form-item label="订单状态" prop="status">
                <el-radio-group v-model="viewModal.status">
                  <el-radio label="OTHER">异常情况</el-radio>
                  <el-radio label="UNPAID">未付款</el-radio>
                  <el-radio label="SENDING">已付款未发货</el-radio>
                  <el-radio label="ARRIVED">已发货未送达</el-radio>
                  <el-radio label="DEAD">已送达</el-radio>
                  <el-radio label="SUCCESS">已确认收货</el-radio>
                  <el-radio label="RETURNING">退货中</el-radio>
                  <el-radio label="RETURNED">退货完成</el-radio>
                </el-radio-group>
              </el-form-item>

              <el-form-item label="手机号" prop="userPhone">
                <el-input placeholder="请输入手机号" v-model="viewModal.userPhone"/>
              </el-form-item>
              <el-form-item label="用户昵称" prop="userName">
                <el-input placeholder="请输入用户昵称" v-model="viewModal.userName"/>
              </el-form-item>
              <el-form-item label="价格" prop="nowPrice">
                <el-input v-model.number="viewModal.nowPrice" disabled></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="userAddress">
                <el-input placeholder="请输入地址" v-model="viewModal.userAddress" maxlength="120" show-word-limit/>
              </el-form-item>
              <el-form-item label="备注" prop="note">
                <el-input type="textarea" v-model="viewModal.note" maxlength="120" show-word-limit/>
              </el-form-item>
              <el-form-item label="评论" prop="remarks">
                <el-input type="textarea" v-model="viewModal.remarks" maxlength="120" show-word-limit/>
              </el-form-item>
            </div>
            <div class="modal-footer">
              <el-form-item>
                <el-button @click.native.prevent="submitForm('viewModal')" class="btn btn-primary">提交</el-button>
              </el-form-item>
            </div>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import $ from 'jquery'
  import {validEmail, validUsername, validPassword, validSex} from '@/utils/validate'
  import { getGoodsByStatus } from '@/api/order'
  import { getToken } from '@/utils/auth'
  export default {
    name: 'OrderGoods',
    data() {
      return {
        viewModal: {
          modalTitle: '',
          id: '',
          userAddress: '',
          userPhone: '',
          userName: '',
          nowPrice: '',
          status: '',
          note: '',
          remarks: ''
        },
        rules: {
          userAddress: [{required: true, min: 3, max: 32, message: "请填入正确的地址", trigger: 'blur'}],
          userPhone: [{required: true, min: 5, max: 18, message: "请填入正确的手机号", trigger: 'blur'}],
          userName: [{required: true, min: 3, max: 32, message: "请填入正确的用户名", trigger: 'blur'}],
          status: [{required: true, message: '请选择订单状态', trigger: 'change'}]
        }
      }
    },
    methods: {

      /**
       * 修改模态框事件
       */
      updateButton: function () {
        let rows = $("#viewTable").bootstrapTable('getSelections');
        if (rows.length != 1) {
          this.$alert("请指定一行进行修改，您可能未选择或多选", "tip");
          //取消模态框的展开
          this.viewModal.modalTitle = "hide"
          return false;
        }
        else {
          let row = rows[0];
          this.viewModal.modalTitle = "1";
          this.viewModal.id = row.id;
          this.viewModal.userAddress = row.userAddress;
          this.viewModal.userPhone = row.userPhone;
          this.viewModal.userName = row.userName;
          this.viewModal.nowPrice = row.nowPrice;
          this.viewModal.status = row.status;
          this.viewModal.note = row.note;
          this.viewModal.remarks = row.remarks;
        }
      },

      /**
       * 删除按钮事件
       */
      removeButton() {
        let rows = $('#viewTable').bootstrapTable('getSelections');
        // rows 主要是为了判断是否选中，下面的else内容才是主要
        if (rows.length <= 0) {
          this.$alert("请先选择要删除的记录!")
        } else {
          this.$confirm('此操作将永久删除该信息, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            let ids = "";
            // 遍历
            $(rows).each(function () {
              ids += this.id + " ";
            });
            // 去除空格并拼接成id串
            ids = ids.trim().replace(/ /g, ",");
            console.log(ids);
            this.$axios.post("/api/order/removeByGoodsIds?ids=" + ids)
              .then(() => {
                this.$message({
                  type: 'success',
                  message: '成功删除数据!'
                });
              })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '未删除'
            })
          })
        }
      },

      /**
       * 提交模态框事件
       */
      submitForm() {
        this.$refs.viewModal.validate((valid) => {
          if (valid) {
            let api = this.viewModal.modalTitle ? '/api/order/updateOrderGoods' : '/api/order/setOrderGoods'
            let params = {
              id: this.viewModal.id,
              userAddress: this.viewModal.userAddress,
              userPhone: this.viewModal.userPhone,
              userName: this.viewModal.userName,
              status: this.viewModal.status,
              note: this.viewModal.note,
              remarks: this.viewModal.remarks
          }
            console.log("api = " + api + " params = " + params)
            this.$axios.post(api, params, { headers: { 'Token': getToken() }})
              .then(function (response) {
                console.log(response);
              })
              .catch(function (error) {
                console.log(error)
              })
            $("#viewModal").modal('hide');
          } else {
            console.log('error submit!!');
            return false
          }
        });
      },
      getGoods(status) {
        return new Promise((resolve, reject) => {
          getGoodsByStatus(status).then(response => {
            const { data } = response;
            resolve(data)
          }).catch(error => {
            reject(error)
          })
        })
      }
    },
    mounted: function () {
      this.$nextTick(function () {
        console.log("页面渲染完成，开始渲染表格");
        $('#viewTable').bootstrapTable({
          url: "/api/order/getGoodsList",
          dataType: "json",
          contentType: 'application/json,charset=utf-8',

          showFullscreen: true,                //全屏显示开关
          showExport: true,                    //导出表格按钮
          //showPaginationSwitch:true,        //显示/隐藏分页
          toolbar: "#toolbar",                //一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
          cache: false,                       // 不缓存
          striped: true,                      // 隔行加亮
          queryParamsType: "undefined",       //设置为"undefined",可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                                              //设置为"limit",符合 RESTFul 格式的参数,可以获取limit, offset, search, sort, order
          sidePagination: 'server',           //分页方式：client客户端分页  | server服务端分页（*）
          sortable: true,                     //是否启用排序;意味着整个表格都会排序
          sortOrder: "asc",                   //排序方式
          pagination: true,                   //是否显示分页（*）
          search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
          strictSearch: false,				        //严格匹配|模糊匹配
          showColumns: true,                //是否显示所有的列
          showRefresh: true,                  //是否显示刷新按钮
          showToggle: true,                   //是否显示详细视图和列表视图
          clickToSelect: true,                //是否启用点击选中行
          minimumCountColumns: 2,          //最少允许的列数 clickToSelect: true, //是否启用点击选中行
          pageNumber: 1,                   //初始化加载第一页，默认第一页
          pageSize: 5,                    //每页的记录行数（*）
          pageList: [5, 10, 25, 50, 100, 'all'],     //可供选择的每页的行数（*）
          paginationPreText: "上一页",
          paginationNextText: "下一页",
          paginationFirstText: "首页",
          paginationLastText: "尾页",
          //下列全是危险操作     注意排查逗号，括号的缺漏和多余
          //uniqueId: "id",                    		//每一行的唯一标识，一般为主键列 影响搜索框
          //sortName: 'id',                    		// 设置默认排序为 name 如果绑定不正确，则表格不显示
          //height: document.body.clientHeight,     //动态获取高度值，可以使表格自适应页面 部分不显示
          //responseHandler: responseHandler,		//响应
          //columns: columns 					    //覆盖
          //queryParams: queryParams,				//后端分页时让其承接函数
          onLoadSuccess: function (data) {          //加载成功时执行
            console.log(data);
          },
          onLoadError: function (res) {             //加载失败时执行
            console.log(res);
          }
        });

        console.log("页面渲染结束，结束渲染表格")
      })
    }
  }
</script>

<style scoped>
</style>
