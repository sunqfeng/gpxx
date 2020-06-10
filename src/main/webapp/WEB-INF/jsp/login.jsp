
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
    <link rel="stylesheet" href="/gpxx/css/logincss.css">
    <link rel="shortcut icon" href="#" />
</head>

<body>
    <!-- 登录框 -->
    <div id="login">
        <el-form ref="loginForm" :model="userlogin" label-width="80px" class="login-box">
            <h3 class="login-title">欢迎登录</h3>
            <el-form-item label="账号" prop="username">
                <el-input type="text" placeholder="请输入账号" v-model="userlogin.username" />
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" placeholder="请输入密码" v-model="userlogin.passwd" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="userlogin_onSubmit(userlogin)">登录</el-button>
                <el-button type="primary" @click="userlogin_register(userlogin)">注册</el-button>
            </el-form-item>
        </el-form>

        <!-- <el-dialog title="温馨提示" :visible.sync="userinfo_dialogVisible" width="30%" :before-close="handleClose">
            <span>请输入账号和密码</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
        </el-dialog> -->
    </div>

    <!-- import Vue before Element -->
    <!-- <script src="https://unpkg.com/vue/dist/vue.js"></script> -->
    <script src="/gpxx/js/vue.js"></script>
    <script src="/gpxx/js/jquery-3.3.1.min.js"></script>
    <!-- import JavaScript -->
    <!-- <script src="https://unpkg.com/element-ui/lib/index.js"></script> -->
    <script src="/gpxx/js/element.js"></script>
    <script src="/gpxx/js/login.js"></script>

</body>

</html>