var vmm = new Vue({
    el: '#login',
    data: function () {
        return {

            // userinfo_dialogVisible:false, //密码或用户名输入错误提醒项
            userlogin: {
                userid: '',
                username: '',
                passwd: '',
            },
        }

    },
    methods: {
        userlogin_onSubmit(userinfo) {
            if (!userinfo.username) {
                this.$message({
                    message: '请输入用户名!!',
                    type: 'warning'
                });
                return;
            }
            if (!userinfo.passwd) {
                this.$message({
                    message: '请输入密码!!',
                    type: 'warning'
                });
                return;
            }

            $.ajax({
                type: "POST",
                url: "./sel_userinfo_username", //
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(userinfo),
                success: function (msg) {
                    console.log(msg);

                    if (msg['code'] == 110) {
                        vmm.$message({
                            message: '该用户不存在或密码错误',
                            type: 'error'
                        });
                    } else { //登录成功以后进行股票监控界面
                        $.ajax({
                            type: "GET",
                            url: "./jkgpxx_index",
                            data: "data",
                            success: function (response) {
                                window.location.href = './jkgpxx_index';
                            }
                        });

                    }
                }
            });

        },
        userlogin_register() {
            // vmm.$router.push("./register")
            $.ajax({
                type: "POST",
                url: "./register",
                data: "codes",
                success: function (response) {
                    console.log("tiaozhuang111111");
                    window.location.href = './register';
                }
            });

        }

    }

})