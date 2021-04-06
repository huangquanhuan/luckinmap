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
            <th data-field="id" data-sortable="true">商品ID</th>
            <th data-field="goodsTypeId" data-sortable="true">商品类型ID</th>
            <th data-field="name" data-sortable="true">商品名称</th>
            <th data-field="stock" data-sortable="true">库存</th>
            <th data-field="buyPrice">原价</th>
            <th data-field="sellPrice">现售价</th>
            <th data-field="awardIntegral" data-sortable="true">奖励积分</th>
            <th data-field="penaltyIntegral" data-sortable="true">抵扣积分上限</th>
            <th data-field="description" data-editable="true">商品描述</th>
            <th data-field="status">当前状态</th>
            <th data-field="createTime" data-sortable="false">创建时间</th>
            <th data-field="creator" data-visible="false">创建者</th>
            <th data-field="updateTime" data-sortable="false">更新时间</th>
            <th data-field="updater" data-visible="false">更改者</th>
          </tr>
          </thead>
        </table>
      </div>
    </div>
    <!-- 弹窗 -->
    <div v-if="viewModal.modalTitle != 'hide' " class="modal fade" id="viewModal" tabindex="-1" role="dialog">
      <div class="modal-dialog modal-lg">
        <!-- Modal content -->
        <div class="modal-content">
          <!-- element-ui ：rules引入data()中的规则 -->
          <el-form label-position="left" ref="viewModal" :model="viewModal" :rules="rules" autocomplete="off"
                   label-width="80px">
            <div class="modal-header">
              <h3 class="modal-title">修改</h3>
              <el-button type="button" class="close" data-dismiss="modal">&times;</el-button>
            </div>
            <div class="modal-body">
              <!-- element-ui 中prop设置需要验证的字段名 -->
              <el-form-item v-if="viewModal.modalTitle" label="商品ID" prop="ID">
                <el-input v-model="viewModal.id" disabled/>
              </el-form-item>

              <el-form-item label="商品名称" prop="name">
                <el-input v-model="viewModal.name" />
              </el-form-item>
              <div class="row">
              <el-form-item label="类型ID" prop="goodsTypeId" class="col">
                <el-input v-model="viewModal.goodsTypeId" />
              </el-form-item>
              <el-form-item label="库存" prop="stock" class="col">
                <el-input-number v-model="viewModal.stock" min="1" max="9999999"/>
              </el-form-item>
              </div>
              <div class="row">
                <el-form-item label="原价" prop="buyPrice" class="col">
                  <el-input-number  v-model="viewModal.buyPrice" :min="1" :max="9999999"/>
                </el-form-item>
                <el-form-item label="现售价" prop="sellPrice" class="col">
                  <el-input-number v-model="viewModal.sellPrice" :min="1" :max="9999999"/>
                </el-form-item>
              </div>
              <div class="row">
              <el-form-item label="奖励积分" prop="awardIntegral" class="col">
                <el-input-number v-model="viewModal.awardIntegral" :min="0" :max="9999999"/>
              </el-form-item>
              <el-form-item label="抵扣上限" prop="penaltyIntegral" class="col">
                <el-input-number v-model="viewModal.penaltyIntegral" :min="0" :max="9999999"/>
              </el-form-item>
              </div>
              <el-form-item label="商品状态" prop="status">
                <el-radio-group v-model="viewModal.status">
                  <el-radio label="0">正常</el-radio>
                  <el-radio label="1" name="1">冻结</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="商品描述" prop="description">
                <el-input type="textarea" placeholder="请输入商品描述" v-model="viewModal.description" maxlength="120" show-word-limit/>
              </el-form-item>
              <el-upload prop="fileList"
                         class="upload-demo"
                         action="/api/file/upload"
                         :data="viewModal"
                         :on-preview="handlePreview"
                         :on-remove="handleRemove"
                         :onError="uploadError"
                         :onSuccess="uploadSuccess"
                         :file-list="viewModal.fileList"
                         list-type="picture">
                <el-button size="small" type="primary">点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
              </el-upload>
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
  import { getToken } from '@/utils/auth'
  import {validEmail, validUsername, validPassword, validSex} from '@/utils/validate'

  export default {
    name: 'Order',
    data() {
      return {
        viewModal: {
          modalTitle: '',
          id: '',
          name: '',
          stock: '',
          buyPrice: '',
          sellPrice: '',
          description: '',
          awardIntegral: '',
          penaltyIntegral: '',
          goodsTypeId: '',
          status: '',
          fileList: []
        },
        rules: {
          name: [{required: true, message: '请选择商品名称', trigger: 'change'}],
          stock: [{required: true,  message: '请选择商品库存', trigger: 'change'}],
          buyPrice: [{required: true,  message: '请输入原价', trigger: 'change'}],
          sellPrice: [{required: true, message: '请输入售价', trigger: 'change'}],
          awardIntegral: [{required: true,  message: '请输入奖励积分', trigger: 'change'}],
          penaltyIntegral: [{required: true,message: '请输入抵扣积分上限', trigger: 'change'}],
          goodsTypeId: [{required: true, message: '请选择商品类型', trigger: 'change'}],
          status: [{required: true, message: '请选择商品状态', trigger: 'change'}]
        }
      }
    },
    methods: {
      // 上传成功后的回调
      uploadSuccess(response, file, fileList) {
        console.log('上传文件', file);
        fileList.push({name: file.name, url: response.data})
      },
      // 上传错误
      uploadError(response, file, fileList) {
        console.log('上传失败，请重试！', response);
      },
      //
      handleRemove(file, fileList) {
        console.log(file, fileList);
        fileList.remove(file);
      },
      //上传之前
      handlePreview(file) {
        console.log(file);
      },
      /**
       * 新建按钮事件,清空模态框
       */
      addButton() {
        this.viewModal.modalTitle = this.viewModal.id = this.viewModal.name =
          this.viewModal.buyPrice = this.viewModal.sellPrice = this.viewModal.description =
            this.viewModal.awardIntegral = this.viewModal.penaltyIntegral =
              this.viewModal.goodsTypeId = this.viewModal.stock = '';
        this.viewModal.status = 1
      },
      /**
       * 修改模态框事件
       */
      updateButton: function () {
        let rows = $("#viewTable").bootstrapTable('getSelections');
        if (rows.length != 1) {
          this.$alert("请指定一行进行修改，您可能未选择或多选", "tip");
          //取消模态框的展开
          this.viewModal.modalTitle = "hide";
          return false;
        }
        else {
          let row = rows[0];
          this.viewModal.modalTitle = "1";
          this.viewModal.id = row.id;
          this.viewModal.name = row.name;
          this.viewModal.stock = row.stock;
          this.viewModal.buyPrice = row.buyPrice;
          this.viewModal.sellPrice = row.sellPrice;
          this.viewModal.description = row.description;
          this.viewModal.awardIntegral = row.awardIntegral;
          this.viewModal.penaltyIntegral = row.penaltyIntegral;
          this.viewModal.goodsTypeId = row.goodsTypeId;
          this.viewModal.status = row.status;
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
            this.$axios.post("/api/goods/removeByIds?ids=" + ids)
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
            let map = {'SECRET': 0, 'MAN': 1, 'WOMAN': 2};
            let map2 = {'SECRET': 0, 'MAN': 1, 'WOMAN': 2};
            let api = this.viewModal.modalTitle ? '/api/goods/updateGoods' : '/api/goods/setGoods'
            let params = {
              id: this.viewModal.id,
              name: this.viewModal.name,
              stock: this.viewModal.stock,
              buyPrice: this.viewModal.buyPrice,
              sellPrice: this.viewModal.sellPrice,
              description: this.viewModal.description,
              awardIntegral: this.viewModal.awardIntegral,
              penaltyIntegral: this.viewModal.penaltyIntegral,
              goodsTypeId: this.viewModal.goodsTypeId,
              status: this.viewModal.status,
              goodsImgs: this.viewModal.fileList.toString()
            }
            this.$axios.post(api, params, { headers: { 'Token': getToken() }})
              .then(function (response) {
                console.log(response);
              })
              .catch(function (error) {
                console.log(error)
              });
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
          url: "/api/goods/getList",
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
