
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
    <link rel="stylesheet" href="/gpxx/css/register.css">
    <link rel="shortcut icon" href="#" />
</head>

<body>
    <!-- 登录框 -->
    <div id="login">
        <el-form ref="loginForm" :model="user_register" label-width="80px" class="login-box">
            <h3 class="login-title">欢迎注册</h3>
            <el-form-item label="账号" prop="username">
                <el-input type="text" placeholder="请输入账号" v-model="user_register.username" @blur="register_blur(user_register.username)"  />
            </el-form-item>
            <el-form-item label="密码" prop="passwd">
                <el-input type="password" placeholder="请输入密码" v-model="user_register.passwd" />
            </el-form-item>

            <el-form-item label="确认密码" prop="repassword">
                <el-input type="password" placeholder="请再次输入密码"  @blur="inputblur(user_register,repassword)" v-model="repassword" />
            </el-form-item>

            <el-form-item label="邮箱" prop="email">
                <el-input type="text" placeholder="请输入邮箱" v-model="user_register.email" />
            </el-form-item>
            <el-form-item label="用户电话" prop="telephone">
                <el-input type="text" placeholder="请输入电话" v-model="user_register.telephone" />
            </el-form-item>
            <el-form-item label="地址" prop="address">
                <el-input type="text" placeholder="请输入地址" v-model="user_register.address" />
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="register_onSubmit(user_register,repassword)">提交</el-button>
                <!-- <el-button type="primary" @click="userlogin_register(userlogin)">注册</el-button> -->
            </el-form-item>
        </el-form>
    </div>

    <!-- import Vue before Element -->
    <!-- <script src="https://unpkg.com/vue/dist/vue.js"></script> -->
    <script src="/gpxx/js/vue.js"></script>
    <script src="/gpxx/js/jquery-3.3.1.min.js"></script>
    <!-- import JavaScript -->
    <!-- <script src="https://unpkg.com/element-ui/lib/index.js"></script> -->
    <script src="/gpxx/js/element.js"></script>
    <script src="/gpxx/js/register.js"></script>

</body>

</html>