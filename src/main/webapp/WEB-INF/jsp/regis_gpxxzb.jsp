<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>孙奇峰学习</title>
    <!-- <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"> -->
    <link rel="stylesheet" href="/gpxx/css/element.css">
    <link rel="stylesheet" href="/gpxx/css/regis_gpxxzb.css">
    <link rel="shortcut icon" href="#" />
</head>

<body>
    <div id="app">
        <!--搜索界面 -->
        <h1>登记股票买卖记录界面</h1>

        <el-row>
          <el-col :span="24">
              <el-table size="mini" :data="gpxx.data" border style="width: 100%" highlight-current-row>
                  <el-table-column type="index"></el-table-column>
                  <el-table-column v-for="(v,i) in gpxx.columns" :prop="v.field" :label="v.title" :width="v.width">
                      <template slot-scope="scope">
                          <span v-if="scope.row.isSet">
                              <el-input size="mini" placeholder="请输入内容" v-model="gpxx.sel[v.field]">
                              </el-input>
                          </span>
                          <span v-else>{{scope.row[v.field]}}</span>
                      </template>
                  </el-table-column>
                  <el-table-column label="操作" width="100">
                      <template slot-scope="scope">
                          <span class="el-tag el-tag--info el-tag--mini" style="cursor: pointer;" @click="pwdChange(scope.row,scope.$index,true)">
                              {{scope.row.isSet?'保存':"修改"}}
                          </span>
                          <span v-if="!scope.row.isSet" class="el-tag el-tag--danger el-tag--mini" style="cursor: pointer;">
                              删除
                          </span>
                          <span v-else class="el-tag  el-tag--mini" style="cursor: pointer;" @click="pwdChange(scope.row,scope.$index,false)">
                              取消
                          </span>
                      </template>
                  </el-table-column>
              </el-table>
          </el-col>
          <el-col :span="24">
              <div class="el-table-add-row" style="width: 99.2%;" @click="addMasterUser()"><span>+ 添加</span></div>
          </el-col>
      </el-row>

    </div>

    <!-- import Vue before Element -->
    <!-- <script src="https://unpkg.com/vue/dist/vue.js"></script> -->
    <script src="/gpxx/js/vue.js"></script>
    <script src="/gpxx/js/jquery-3.3.1.min.js"></script>
    <!-- import JavaScript -->
    <!-- <script src="https://unpkg.com/element-ui/lib/index.js"></script> -->
    <script src="/gpxx/js/element.js"></script>
    <script src="/gpxx/js/regis_gpxxzb.js"></script>
     <!-- 引入样式 -->
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/vxe-table/lib/index.css">
     <!-- 引入脚本 -->
     <script src="https://cdn.jsdelivr.net/npm/xe-utils"></script>
     <script src="https://cdn.jsdelivr.net/npm/vxe-table"></script>
</body>

</html>