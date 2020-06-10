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
    <link rel="stylesheet" href="/gpxx/css/index.css">
    <link rel="shortcut icon" href="#"/>
</head>

<body>
    <div id="app">
        <!--搜索界面 -->
        <h1>股票监控界面</h1>
        <!--查询界面-->
        <el-form :inline="true" :model="searchObj" ref="searchObj"  class="demo-form-inline">
            <el-form-item label="">
                <el-input v-model="searchObj.gpid" placeholder="股票id"></el-input>
            </el-form-item>
            <el-form-item label="">
                <el-input v-model="searchObj.gpmc" placeholder="股票名称"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit(searchObj)">查询</el-button>
                <el-button type="primary" @click="addGpxx()">新增股票信息</el-button>
            </el-form-item>
        </el-form>


        <div class="addbtn">
            <!--新增按钮-->
            <!-- <el-button type="primary" @click="addGpxx()">新增股票信息</el-button> -->
        </div>
        <div class="body">
            <!--显示界面-->
            <template>
                <el-table :data="tableData" stripe style="width: 100%">
                    <!-- <el-table-column prop="date" type="index" label="序号" width="180"> -->
                    <el-table-column prop="date" label="序号" width="180">
                        <template slot-scope="scope">
                            {{scope.$index+1}}
                        </template>
                    </el-table-column>
                    <el-table-column prop="gpid" label="股票id" width="180">
                    </el-table-column>
                    <el-table-column prop="gpmc" label="股票名称" width="180">
                    </el-table-column>
                    <el-table-column prop="dqjg" label="当前价格">
                    </el-table-column>
                    <el-table-column prop="jkjg" label="监控价格">
                    </el-table-column>
                    <el-table-column prop="sfjk" label="是否监控">
                    </el-table-column>
                    <el-table-column prop="jkcs" label="监控次数">
                    </el-table-column>
                    <el-table-column prop="objemail" label="邮箱地址">
                    </el-table-column>

                    <el-table-column prop="edit_gpxx" label="操作">
                        <template slot-scope="scope">
                            <!--增加信息按钮-->
                            <!-- <el-button type="info" icon="el-icon-message" @click="addGpxx()" circle></el-button> -->

                            <!--编辑按钮-->
                            <el-button type="primary" icon="el-icon-edit" @click="editGpxx(scope.row,scope.$index)"
                                circle>
                            </el-button>
                            <el-button type="danger" icon="el-icon-delete" @click="delUser(scope.row,scope.$index)" circle>
                            </el-button>
                            <!--删除按钮-->
                        </template>
                    </el-table-column>

                </el-table>
            </template>
        </div>
        <el-dialog title="编辑用户信息" :visible.sync="edit_dialogVisible" width="30%" :before-close="handleClose">
            <div>
                <el-form ref="form" :model="editObj" label-width="80px">
                    <el-form-item label="股票id">
                        <el-input :disabled="eidt_input_gpid" v-model="editObj.gpid"></el-input>
                    </el-form-item>
                    <el-form-item label="股票名称">
                        <el-input v-model="editObj.gpmc"></el-input>
                    </el-form-item>
                    <el-form-item label="监控价格">
                        <el-input v-model="editObj.jkjg"></el-input>
                    </el-form-item>

                    <el-form-item label="是否监控">
                        <el-input v-model="editObj.sfjk"></el-input>
                    </el-form-item>

                    <el-form-item label="监控次数">
                        <el-input v-model="editObj.jkcs"></el-input>
                    </el-form-item>

                    <el-form-item label="邮箱地址">
                        <el-input v-model="editObj.objemail"></el-input>
                    </el-form-item>

                    <!-- <el-form-item label="出生日期">
                        <el-date-picker v-model="editObj.birthday" type="date" formate="yyyy 年 MM月 dd日"
                            value-format="yyyy-MM-dd" placeholder="选择出生日期">
                        </el-date-picker>
                    </el-form-item> -->
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
                <!-- <el-button @click="dialogVisible = false">取 消</el-button> -->
                <el-button @click="editgpxxcancel()">取 消</el-button>
                <el-button type="primary" @click="editgpxxconfirm(editObj)">确 定</el-button>
            </span>
        </el-dialog>

        <el-dialog title="新增股票信息" :visible.sync="adddialogVisible" width="30%" :before-close="handleClose">
            <div>
                <el-form ref="form" :model="addObj" label-width="80px">
                    <el-form-item label="股票id">
                        <el-input v-model="addObj.gpid"></el-input>
                    </el-form-item>
                    <el-form-item label="股票名称">
                        <el-input v-model="addObj.gpmc" placeholder="可以不用输入股票名称"></el-input>
                    </el-form-item>
                    <el-form-item label="监控价格">
                        <el-input v-model="addObj.jkjg"></el-input>
                    </el-form-item>

                    <el-form-item label="是否监控">
                        <el-input v-model="addObj.sfjk"></el-input>
                    </el-form-item>

                    <el-form-item label="监控次数">
                        <el-input v-model="addObj.jkcs"></el-input>
                    </el-form-item>

                    <el-form-item label="邮箱地址">
                        <el-input v-model="addObj.objemail"></el-input>
                    </el-form-item>


                    <!-- <el-form-item label="出生日期">
                        <el-date-picker v-model="editObj.birthday" type="date" formate="yyyy 年 MM月 dd日"
                            value-format="yyyy-MM-dd" placeholder="选择出生日期">
                        </el-date-picker>
                    </el-form-item> -->
                </el-form>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="adddialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="addconfirm()">确 定</el-button>
            </span>
        </el-dialog>

    </div>

    <!-- import Vue before Element -->
    <!-- <script src="https://unpkg.com/vue/dist/vue.js"></script> -->
    <script src="/gpxx/js/vue.js"></script>
    <script src="/gpxx/js/jquery-3.3.1.min.js"></script>
    <!-- import JavaScript -->
    <!-- <script src="https://unpkg.com/element-ui/lib/index.js"></script> -->
    <script src="/gpxx/js/element.js"></script>
    <script src="/gpxx/js/index.js"></script>
</body>

</html>