<template>
  <div class="app-container">
    <div class="panel panel-default">
      <div class="panel-body">
        <div id="toolbar" class="btn-group">
          <button id="btn_add" class="btn btn-info btn-sm rightSize"
                  @click="addButton" data-toggle="modal" data-target="#viewModal">
            <i class="el-icon-plus"></i>&nbsp;新增
          </button>
          <button class="btn btn-info btn-sm rightSize"
                  @click="updateButton" data-toggle="modal" data-target="#viewModal">
            <i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;修改
          </button>
          <button @click="removeButton" class="btn btn-info btn-sm rightSize">
            <i class="el-icon-delete"></i>&nbsp;删除
          </button>
        </div>
        <table id="viewTable"
               class="table table-striped table-bordered"
               data-filter-control="true"
               data-toolbar="#toolbar"
               data-search="true"
               data-show-refresh="true"
               data-show-toggle="true"
               data-show-fullscreen="true"
               data-show-columns="true"
               data-show-export="true"
               data-click-to-select="true"
               data-minimum-count-columns="2"
               data-show-pagination-switch="true"
               data-pagination="true"
               data-id-field="id"
               data-page-list="[10, 25, 50, 100, all]"
               data-side-pagination="server"
               data-striped="true"
               data-query-params-type="undefined">
          <thead>
          <tr>
            <th></th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="areaId" data-sortable="true">邮编</th>
            <th data-field="address" data-sortable="true">详细地址</th>
            <th data-field="phone" data-sortable="true">联系方式</th>
            <th data-field="owner" data-sortable="true">所有者ID</th>
            <th data-field="ownerType" @data-formatter="ownerType">所有者类型</th>
            <th data-field="createTime" data-sortable="true" data-visible="false">创建时间</th>
            <th data-field="creator" data-visible="false">创建者</th>
            <th data-field="updateTime" data-sortable="true" data-visible="false">更新时间</th>
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
              <el-button type="button" class="close" data-dismiss="modal">&times;</el-button>
            </div>
            <div class="modal-body">
              <!-- element-ui 中prop设置需要验证的字段名 -->
              <div class="form-group">
                <div style="position: relative;">
                  <input id="city-picker3" class="form-control" readonly type="text" value="江苏省/常州市/溧阳市" data-toggle="city-picker">
                </div>
              </div>
              <el-form-item v-if="viewModal.modalTitle" label="ID" prop="ID">
                <el-input v-model="viewModal.id" disabled/>
              </el-form-item>
              <el-form-item label="城市邮编" prop="areaId">
                <el-input v-model.number="viewModal.areaId" clearable/>
              </el-form-item>
              <el-form-item label="详细地址" prop="address">
                <el-input v-model="viewModal.address" maxLength="120" clearable/>
              </el-form-item>
              <el-form-item label="联系方式" prop="phone">
                <el-input v-model="viewModal.phone" maxLength="20" clearable/>
              </el-form-item>
              <el-form-item label="地址类型" prop="ownerType">
                <el-radio-group v-model="viewModal.ownerType">
                  <el-radio label="0">用户地址</el-radio>
                  <el-radio label="1">商家地址</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="归属者ID" prop="owner">
                <el-input v-model="viewModal.owner" maxLength="120" clearable/>
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
  import {validEmail, validName, validPassword, validSex} from '@/utils/validate.js'
  import 'bootstrap/dist/js/bootstrap'
  // import '@/utils/city-picker.data.js'
  // import '@/utils/city-picker.js'

  export default {
    name: 'Supple',
    data() {
      return {
        viewModal: {
          modalTitle: "",
          id: "",
          areaId: "",
          address: "",
          phone: "",
          owner: "",
          ownerType: ""
        },
        rules: {
          areaId: [{required: true, message: "请选择城市", trigger: 'blur'}],
          address: [{required: true, message: "请填入详细地址", trigger: 'blur'}],
          phone: [{required: true, message: "请填入联系方式", trigger: 'blur'}],
          ownerType: [{required: true, max: 9, message: "请选择地址类别", trigger: 'blur'}],
          owner: [{required: true, message: "请填入地址主人", trigger: 'blur'}],
        }
      }
    },
    methods: {

      ownerType(value, row) {
        console.log("行的格式化");
        return '<span>'+(row.owner != "0" ? "用户" : "商家") + '</span>' + value;
      },

      /**
       * 新建按钮事件,清空模态框
       */
      addButton() {
        this.viewModal.modalTitle = this.viewModal.id = this.viewModal.areaId =
          this.viewModal.address = this.viewModal.phone = this.viewModal.owner =
            this.viewModal.ownerType = "";
      },

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
          this.viewModal.areaId = row.areaId;
          this.viewModal.address = row.address;
          this.viewModal.phone = row.phone;
          this.viewModal.owner = row.owner;
          this.viewModal.ownerType = row.ownerType;
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
            this.$axios.post("/api/supple/removeByIds?ids=" + ids)
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
      }
      ,
      /**
       * 提交模态框事件
       */
      submitForm() {
        this.$refs.viewModal.validate((valid) => {
          if (valid) {
            console.log("验证通过");
            let api = this.viewModal.modalTitle ? '/api/address/updateAddress' : '/api/address/setAddress'
            let params = {
              id: this.viewModal.id,
              areaId: this.viewModal.areaId,
              address: this.viewModal.address,
              phone: this.viewModal.phone,
              owner: this.viewModal.owner,
              ownerType: this.viewModal.ownerType
            }
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
      }
    },
    mounted: function () {
      this.$nextTick(function () {
        console.log("页面渲染完成，开始渲染表格");
        $('#viewTable').bootstrapTable({
          url: "/api/address/getList",
          dataType: "json",
          contentType: 'application/json,charset=utf-8',
          // detailView: true, // 前面显示个加号
          paginationPreText: "上一页",
          paginationNextText: "下一页",
          paginationFirstText: "首页",
          paginationLastText: "尾页",
          columns: [{
            checkbox: true
          }],
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
