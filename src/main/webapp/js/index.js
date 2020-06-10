var vmm = new Vue({
    el: '#app',
    data: function () { //下面定义的都是该app的初始值
        return {
            input: '',
            tableData: [],
            dialogVisible: false, //彈框的顯示,弹框
            adddialogVisible: false, //新增股票信息，弹框
            edit_dialogVisible: false, //编辑界面初始值
            eidt_input_gpid: true, //编辑gpid初始值为可编辑.
            userIndex: 0, //初始化变量值
            gpxx: {
                gpid: '',
                gpmc: '',
                dqjg: '',
                jkjg: '',
                sfjk: '',
                jkcs:'', 
                objemail:'',
            },

            editObj: {
                gpid: '',
                gpmc: '',
                jkjg: '',
                sfjk: '',
                jkcs: '', 
                objemail: '',
            },

            addObj: {
                gpid: '',
                gpmc: '',
                jkjg: '',
                sfjk: '',
                jkcs: '',
                objemail: '',
            },
            searchObj: {
                gpid: '',
                gpmc: '',
            }
        }
    },
    methods: {
        addGpxx() {
            this.addObj = { //先初始化数据
                gpid: '',
                gpmc: '',
                jkjg: '',
                sfjk: '',
                jkcs: '',
                objemail: '',
            };

            this.adddialogVisible = true;
            // this.tableData.push(this.addObj); //把新增的数据push到主页面(add)中去
            // this.adddialogVisible = false;
        },
        //删除数据
        delUser(item, idx) {
            // console.log(idx);
            this.$confirm('确认删除吗？')
                .then(_ => {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        dataType: "dataType",
                        url: "./del_jkgpxxzb_gpid",
                        data: JSON.stringify(item),
                        success: function (response) {

                        }
                    });
                    this.tableData.splice(idx, 1);
                })
                .catch(_ => {});
        },

        //编辑股票信息的数据
        editGpxx(item, idx) {
            // console.log(item);
            this.userIndex = idx;
            this.editObj = { //给表格赋值
                gpid: item.gpid,
                gpmc: item.gpmc,
                jkjg: item.jkjg,
                sfjk: item.sfjk,
                jkcs: item.jkcs,
                objemail: item.objemail,
            };
            this.edit_dialogVisible = true; //上面的数据赋值过以后，把editUser的界面显示出来
            eidt_input_gpid = false; //当用户进行股票信息编辑时，股票的id是不可以编辑的
        },
        handleClose() { //editUser 界面右上面那个X的触发事件
            this.dialogVisible = false;
            this.adddialogVisible = false;
        },

        //确认按钮
        editgpxxcancel() {

            this.edit_dialogVisible = false;
            this.adddialogVisible = false;
            // Vue.set(this.tableData, this.userIndex, this.editObj);
            // this.tableData[this.userIndex] = this.editObj; //非相应式的(改过以后不会在页面上显示)
        },

        //新增股票信息-确认按钮
        addconfirm() {
            //对姓名进行判断，如果为空不允许插入
            var tabld = this.tableData;
            if (!this.addObj.gpid) {
                this.$message({
                    message: '请输入股票id',
                    type: 'warning'
                });
                return
            }

            if (!this.addObj.jkjg) {
                this.$message({
                    message: '请输入监控价格',
                    type: 'warning'
                });
                return
            }

            if (!this.addObj.sfjk) {
                this.$message({
                    message: '请输入是否监控',
                    type: 'warning'
                });
                return
            }

            if (!this.addObj.objemail) {
                this.$message({
                    message: '请输入邮箱地址',
                    type: 'warning'
                });
                return
            }


            this.adddialogVisible = false;
            var tmpgpid = this.addObj.gpid;

            $.ajax({
                type: "POST",
                url: "./insert_jkgpxxzb", //新增股票监控信息
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(this.addObj),
                success: function (addObj) {
                    $.ajax({
                        type: "POST",
                        url: "./sel_jkgpxxzb",
                        data: {
                            gpid: tmpgpid, // 后台取数据的key: 前台要发送的数据
                            gpmc: '',
                        },
                        success: function (list_jkgpxxzb) {
                            if (list_jkgpxxzb.length == 0) {
                                alert("没有插入成功")
                                return true
                            }
                            for (var i = 0; i < list_jkgpxxzb.length; i++) {
                                tabld.push(list_jkgpxxzb[i]);
                            }
                        }

                    });

                }

            });
        },
        onSubmit(searchObj) { //根据股票id查询股票信息的确认按钮

            if (!searchObj.gpid) {
                this.$message({
                    message: '请输入股票id',
                    type: 'warning'
                });
                return
            }

            this.tableData = []; //清空界面
            var tabld = this.tableData;

            $.ajax({
                type: "POST",
                url: "./sel_jkgpxxzb",
                data: {
                    gpid: searchObj.gpid, // 后台取数据的key: 前台要发送的数据
                    gpmc: searchObj.gpmc,
                },
                success: function (list_jkgpxxzb) {
                    if (list_jkgpxxzb.length == 0) {
                        // alert("没有该股票监控信息!!!")
                        vmm.$message({
                            message: "没有该股票的信息",
                            tyep: 'warning',
                        })
                        return true
                    }
                    for (var i = 0; i < list_jkgpxxzb.length; i++) {
                        tabld.push(list_jkgpxxzb[i]);
                    }
                }
            });
            //清空搜索框
            // this.$refs[searchObj].resetField();
            this.searchObj = {
                gpid: '',
                gpmc: '',
            };
        },
        //编辑股票信息界面-确认按钮
        editgpxxconfirm(editObj) {
            this.tableData = []; //清空界面
            var tabld = this.tableData;
            this.edit_dialogVisible = false; //确认以后把editUser的界面隐藏起来
            var tmpgpid = this.editObj.gpid;
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                // dataType: "dataType",
                dataType: "text",
                url: "./udp_jkgpxxzb_gpid",
                data: JSON.stringify(this.editObj),
                success: function (response) { //更新以后，进行gpid查询,看是否更新成功
                    $.ajax({
                        type: "POST",
                        url: "./sel_jkgpxxzb",
                        data: {
                            gpid: tmpgpid, // 后台取数据的key: 前台要发送的数据
                            gpmc: '',
                        },
                        success: function (list_jkgpxxzb) {
                            // tableData = []; //清空界面
                            if (list_jkgpxxzb.length == 0) {
                                alert("没有查询成功")
                                return true
                            }

                            for (var i = 0; i < list_jkgpxxzb.length; i++) {
                                tabld.push(list_jkgpxxzb[i]);
                            }
                        }

                    });

                }
            });
        }

    }
})