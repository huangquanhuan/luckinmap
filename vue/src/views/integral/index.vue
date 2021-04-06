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
               data-filter-control="true">
          <thead>
          <tr>
            <th></th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="seller" data-sortable="true">供应商ID</th>
            <th data-field="behavior">行为</th>
            <th data-field="buyer" data-sortable="true">用户ID</th>
            <th data-field="changedNumber" data-sortable="true">交易积分</th>
            <th data-field="createTime">交易时间</th>
            <th data-field="creator" data-visible="false">下单者</th>
            <th data-field="updateTime" data-visible="false">更新时间</th>
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
              <el-form-item v-if="viewModal.modalTitle" inline="true" label="ID" prop="ID">
                <el-input v-model="viewModal.id" disabled/>
              </el-form-item>
              <el-form-item v-if="!viewModal.modalTitle" label="供应商" prop="seller">
                <el-input v-model="viewModal.seller" clearable/>
              </el-form-item>
              <el-form-item v-if="!viewModal.modalTitle" label="用户" prop="buyer">
                <el-input v-model="viewModal.buyer" clearable/>
              </el-form-item>
              <el-form-item v-if="!viewModal.modalTitle" label="交易积分" prop="changedNumber">
                <el-input v-model.number="viewModal.changedNumber" clearable/>
              </el-form-item>
              <el-form-item label="行为" prop="behavior">
                <el-input type="textarea" v-model="viewModal.behavior" maxLength="50" show-word-limit clearable/>
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
  import {validEmail, validName, validPassword, validSex} from '@/utils/validate'
  import { getToken } from '@/utils/auth'

  export default {
    name: 'Integral',
    data() {
      return {
        viewModal: {
          modalTitle: "",
          id: "",
          behavior: "",
          seller: "",
          buyer: "",
          changedNumber: ""
        },
        rules: {
          seller: [{required: true, message: "请选择供应商", trigger: 'blur'}],
          buyer: [{required: true, message: '请选择用户', trigger: 'change'}],
          behavior: [{required: true, max: 127, message: "请填入行为"}],
          changedNumber: [{required: true, max: 20, message: "请填入交易积分", trigger: 'blur'}]
        }
      }
    },
    methods: {
      /**
       * 新建按钮事件,清空模态框
       */
      addButton() {
        this.viewModal.modalTitle = this.viewModal.id = this.viewModal.behavior = this.viewModal.seller = this.viewModal.buyer = this.viewModal.changedNumber = "";
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
          this.viewModal.behavior = row.behavior;
          this.viewModal.seller = row.seller;
          this.viewModal.buyer = row.buyer;
          this.viewModal.changedNumber = row.changedNumber;
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
            this.$axios.post("/api/integral/removeByIds?ids=" + ids)
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
            let api = this.viewModal.modalTitle ? '/api/integral/updateIntegral' : '/api/integral/setIntegral'
            let params = {
              id: this.viewModal.id,
              name: this.viewModal.name,
              sex: this.viewModal.sex,
              phone: this.viewModal.phone,
              mail: this.viewModal.mail
            }
            console.log("api = " + api + " params = " + params.toString() + params.sex)
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
    },
    mounted: function () {
      this.$nextTick(function () {
        console.log("页面渲染完成，开始渲染表格");
        $('#viewTable').bootstrapTable({
          url: "/api/integral/getList",
          dataType: "json",
          contentType: 'application/json,charset=utf-8',
          //exportDataType:"selected", //basic'导出当前页, 'all'导出全部, 'selected'导出选中项.
          //showFullscreen: true,                //全屏显示开关
          exportDataType: this.exportType,
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
          columns: [
            {
              checkbox: true
            }],
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
