var vmm = new Vue({
    el: '#login',
    data: function () {
        return {

            // userinfo_dialogVisible:false, //密码或用户名输入错误提醒项
            name: '',
            repassword: '',
            user_register: {
                username: '',
                passwd: '',
                email: '',
                telephone: '',
                address: '',
            },
        }

    },
    methods: {
        register_onSubmit(user_register, repassword) {
            console.log(user_register);
            console.log(repassword);

            if (!user_register.username) {
                this.$message({
                    message: '请输入用户名!!',
                    type: 'warning'
                });
                return;
            }
            if (!user_register.passwd) {
                this.$message({
                    message: '请输入密码!!',
                    type: 'warning'
                });
                return;
            }

            if (!user_register.telephone) {
                this.$message({
                    message: '请输入电话!!!!',
                    type: 'warning'
                });
                return;
            }

            $.ajax({
                type: "POST",
                url: "./insert_userinfo", //注册用户信息
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(user_register),
                success: function (msg) {
                    console.log(msg);

                    if (msg['code'] == 000) {
                        vmm.$message({
                            message: '注册成功,即将跳转到登录界面',
                            type: 'success',

                        });
                        setTimeout(function () { //用户注册成功以后停顿几秒然后进行登录界面
                            $.ajax({
                                type: "POST",
                                url: "./userlogin",
                                data: "codes",
                                success: function (response) {
                                    console.log("tiaozhuang111111");
                                    window.location.href = './userlogin';
                                }
                            });
                        }, 4000)
                    } else {
                        vmm.$message({
                            message: '注册失败，请重新注册',
                            type: 'error',
                        });
                        return;
                    }
                }
            });

        },

        inputblur(user_register, repassword) { //当再次输入密码时(失去焦点触发)

            if (user_register.passwd != repassword) {
                this.$message({
                    message: "密码确认有误，请重新输入",
                    tyep: 'warning',
                })
                return;
            }
        },

        register_blur(regis_name) {

            console.log("sqf re" + regis_name);
            if (!regis_name) {
                this.$message({
                    message: '请输入用户名!!',
                    type: 'warning'
                });
                return;
            }

            $.ajax({
                type: "POST",
                url: "./check_name",
                data: {
                    name: regis_name,
                },
                success: function (msg) {
                    if(msg['code']==120 || msg['code']== 130 ) {
                        vmm.$message({
                            message: '该用户已经存在，请重新输入!!',
                            type: 'warning'
                        });
                        return;
                    }
                }
            });
        }



    }

})