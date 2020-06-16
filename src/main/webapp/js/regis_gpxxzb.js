  //主要内容
  var app = new Vue({
      el: "#app",
      data: function () {
          return {
              gpxx: {
                  sel: null, //选中行   
                  columns: [{
                          field: "gpxxid",
                          title: "股票id",
                          width: 120
                      },
                      {
                          field: "gpmc",
                          title: "股票名称",
                          width: 150
                      },
                      {
                          field: "mrsj",
                          title: "买入时间",
                          width: 120
                      },
                      {
                          field: "mrjg",
                          title: "买入价",
                          width: 100
                      },
                      {
                          field: "mcsj",
                          title: "卖出时间",
                          width: 120
                      },
                      {
                          field: "mcjg",
                          title: "卖出价",
                          width: 100
                      },
                      {
                          field: "gpsl",
                          title: "股票数量",
                          width: 100
                      },
                      {
                          field: "gpje",
                          title: "总股票金额",
                          width: 100
                      },
                      {
                          field: "gpts",
                          title: "持有股票天数",
                          width: 100
                      },
                      {
                          field: "gpsy",
                          title: "股票收益",
                          width: 100
                      }
                  ],
                  data: [],
              },

              isflag: '0',
              sear_gpxxid: '',
              sear_gpmc: '',
          }
      },
      methods: {

          search(sear_gpxxid, sear_gpmc) { //按股票id号与股票名称进行gxxzb的信息搜索
              app.gpxx.data = [];
              app.sear_gpxxid = "";
              app.sear_gpmc = "";
              console.log("serach sqf" + sear_gpxxid + "|" + sear_gpmc);
              if (!sear_gpxxid && !sear_gpmc) {
                  app.$message({
                      type: 'warning',
                      message: '请输入股票id号或者股票名称',
                  })
              }
              var numReg = /^[0-9]*$/
              var numRe = new RegExp(numReg)
              if (!numRe.test(sear_gpxxid)) {
                  this.$message({
                      type: 'warning',
                      message: '请输入数字 ',
                  })
                  return false
              }

              data = {
                  gpxxid: sear_gpxxid,
                  gpmc: sear_gpmc,
              };
              if (sear_gpxxid) { //按股票id查询股票交易信息
                  $.ajax({
                      type: "POST",
                      contentType: "application/json; charset=utf-8",
                      //   dataType: "dataType",
                      url: "sel_gpxxzb_gpxxid",
                      data: JSON.stringify(data),
                      success: function (stGpxxzb) {

                          if (stGpxxzb.length == 0) {
                              app.$message({
                                  type: 'waring',
                                  message: "查询不到该股票信息!"
                              });
                              return;
                          }

                          for (var i = 0; i < stGpxxzb.length; i++) {
                              app.gpxx.data.push(stGpxxzb[i]);
                          }
                      }
                  });
              } else {

              }

          },

          //添加账号
          addMasterUser() {
              app.isflag = '1';
              for (let i of app.gpxx.data) {
                  if (i.isSet) return app.$message.warning("请先保存当前编辑项");
              }
              let j = {
                  "id": 0,
                  "gpid": "",
                  "gpmc": "",
                  "mrsj": "",
                  "mrjg": "",
                  "mcsj": "",
                  "mcjg": "",
                  "gpsl": "",
                  "gpje": "",
                  "gpts": "",
                  "gpsy": "",
                  "isSet": true,
                  "_temporary": true
              };
              app.gpxx.data.push(j);
              app.gpxx.sel = JSON.parse(JSON.stringify(j));
          },
          //修改
          pwdChange(row, index, cg) {
              //点击修改 判断是否已经保存所有操作
              for (let i of app.gpxx.data) {
                  if (i.isSet && i.id != row.id) {
                      app.$message.warning("请先保存当前编辑项");
                      return false;
                  }
              }
              //是否是取消操作
              if (!cg) {
                  if (!app.gpxx.sel.id) app.gpxx.data.splice(index, 1);
                  return row.isSet = !row.isSet;
              }
              //提交数据
              if (row.isSet) {
                  //项目是模拟请求操作  自己修改下
                  (function () {
                      let data = JSON.parse(JSON.stringify(app.gpxx.sel));
                      console.log("sqf ri" + data.gpxxid);
                      //首先按gpxxid号进行查询，如果数据库本就存在，那么进行update操作，否则进行insert操作
                      if (!data.gpxxid) {
                          app.$message({
                              type: 'error',
                              message: "请输入股票id号"
                          });
                          return;
                      } else //进行gpid信息查询
                      {

                          if (app.isflag == 1) //执行insert操作
                          {

                              console.log("insert sqf 000");

                              $.ajax({
                                  type: "POST",
                                  contentType: "application/json; charset=utf-8",
                                  //   dataType: "dataType",
                                  url: "./insert_gpxxzb",
                                  data: JSON.stringify(data),
                                  success: function (list_gpxxzb) {
                                      if (list_gpxxzb.length == 0) {
                                          app.$message({
                                              type: 'error',
                                              message: "保存失败!"
                                          });
                                          return;
                                      }
                                      app.gpxx.data = [];
                                      for (var i = 0; i < list_gpxxzb.length; i++) {
                                          app.gpxx.data.push(list_gpxxzb[i]);
                                      }
                                  }
                              });
                          } else { //执行update操作

                              console.log("sqf update caozuo");

                              $.ajax({
                                  type: "POST",
                                  contentType: "application/json; charset=utf-8",
                                  //   dataType: "dataType",
                                  url: "./upd_gpxxzb_gpid",
                                  data: JSON.stringify(data),
                                  success: function (list_Gpxxzb) {
                                      if (list_Gpxxzb.length == 0) {
                                          app.$message({
                                              type: 'error',
                                              message: "更新失败!"
                                          });
                                          return;
                                      }
                                      app.gpxx.data = [];
                                      for (var i = 0; i < list_Gpxxzb.length; i++) {
                                          app.gpxx.data.push(list_Gpxxzb[i]);
                                      }

                                  }
                              });
                          }
                      }
                      row.isSet = false;
                  })();
                 app.isflag = '0';
              } else {
                  app.gpxx.sel = JSON.parse(JSON.stringify(row));
                  row.isSet = true;
              }
          }
      }
  });