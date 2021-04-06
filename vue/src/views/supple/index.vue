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
            <th data-field="operator">操作</th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="name" data-sortable="true">姓名</th>
            <th data-field="mail">邮箱</th>
            <th data-field="phone">电话</th>
            <th data-field="integral">积分</th>
            <th data-field="description" >商家介绍</th>
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
              <el-form-item label="姓名" prop="supplename">
                <el-input v-model="viewModal.suppleName" clearable/>
              </el-form-item>
              <el-form-item label="邮箱" prop="mail">
                <el-input v-model="viewModal.mail" maxlength="60" show-word-limit clearable/>
              </el-form-item>
              <el-form-item label="手机" prop="phone">
                <el-input v-model="viewModal.phone" maxlength="18" show-word-limit clearable/>
              </el-form-item>
              <el-form-item label="商家描述" prop="description">
                <el-input type="textarea" v-model="viewModal.description" maxlength="120" show-word-limit/>
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
  import qs from 'qs'
  import md5 from 'js-md5'
  import { getToken } from '@/utils/auth'
  export default {
    name: 'Supple',
    data() {
      var validateEmail = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入邮箱'));
        } else if (!validEmail(value)) {
          callback(new Error('无效邮箱'));
        } else {
          callback();
        }
      };
      var validateName = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入用户名'));
        } else if (!validName(value)) {
          callback(new Error('用户名不得出现 .`~"?*<>/\\|'));
        } else {
          callback();
        }
      };
      var validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else if (!validPassword(value)) {
          callback(new Error('无效密码'));
        } else {
          callback();
        }
      };
      return {
        viewModal: {
          modalTitle: "",
          id: "",
          suppleName: "",
          description: "",
          mail: "",
          phone: ""
        },
        rules: {
          suppleName: [{required: true, min: 3, max: 32, message: "请填入正确的名称", trigger: 'blur'}],
          password: [{required: true, max: 127, message: "请填入密码"},
            {validator: validatePassword, trigger: 'blur'}],
          mail: [{required: true, validator: validateEmail, trigger: 'blur'}],
          phone: [{required: true, min: 6, max: 20, message: "请填入正确的手机号", trigger: 'blur'}]
        }
      }
    },
    methods: {

      /**
       * 新建按钮事件,清空模态框
       */
      addButton() {
        this.viewModal.modalTitle = this.viewModal.id = this.viewModal.suppleName = this.viewModal.description = this.viewModal.phone = this.viewModal.mail = ""
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
          this.viewModal.suppleName = row.name;
          this.viewModal.description = row.description;
          this.viewModal.phone = row.phone;
          this.viewModal.mail = row.mail;
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
            this.$axios.post("/api/supple/removeByIds?ids="+ids)
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
            let api = this.viewModal.modalTitle ? '/api/supple/updateSupple' : '/api/supple/setSupple'
            let params = {
              id: this.viewModal.id,
              name: this.viewModal.suppleName,
              description: this.viewModal.description,
              phone: this.viewModal.phone,
              mail: this.viewModal.mail
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
      },

      /**
       * 重置密码
       * @param e 按钮事件
       * @param value table值
       * @param row 一行的值
       * @param index 行在表中的下标
       */
      resetPassword(e, value, row, index) {
        console.log(md5("123456"));
        console.log(validSex('男'));
        let params = qs.stringify({
          ids: row.id
          // token: this.store.token
        })
        this.$axios.post('/api/supple/resetPassword' + "?" + params)
          .then((response) =>{
            this.$message({
              type: 'success',
              message: '密码重置为123456'
            });
            console.log(response)
          }).catch(error => {
          console.log(error.message)
        })
      }
    },
    mounted: function () {
      this.$nextTick(function () {
        console.log("页面渲染完成，开始渲染表格");
        $('#viewTable').bootstrapTable({
          url: "/api/supple/getList",
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
          // icons: {
          //   paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
          //   paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
          //   refresh: 'glyphicon-refresh icon-refresh',
          //   toggle: 'glyphicon-list-alt icon-list-alt',
          //   columns: 'glyphicon-th icon-th',
          //   detailOpen: 'glyphicon-plus icon-plus',
          //   detailClose: 'glyphicon-minus icon-minus'
          // },
          columns: [
            {
              checkbox: true
            }, {
              title: '操作',
              field: 'operator',
              align: "center",
              events: window.operatEvents = {
                'click .resetPassword': this.resetPassword
              },
              formatter: (value, row, index) => {
                return '<button class="resetPassword btn btn-primary btn-sm">重置密码</button>'
              }
            },{
              title: '供应商ID',
              field: 'id',
              align: "center",
              formatter: (value, row, index) => {
                return '<a href="/#/supple/SuppleDetails?id=' + row.id + '">' + row.id + '</a>'
              }
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
