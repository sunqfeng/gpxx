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
                          width: 100
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
                          title: "股票天数",
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
          }
      },
      methods: {
          //读取表格数据
          // readMasterUser() {
          //     //根据实际情况，自己改下啊 
          //     app.gpxx.data.map(i => {
          //         i.id = generateId.get();//模拟后台插入成功后有了id
          //         i.isSet=false;//给后台返回数据添加`isSet`标识
          //         return i;
          //     });
          // },
          //添加账号
          addMasterUser() {
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
                          $.ajax({
                              type: "POST",
                              contentType: "application/json; charset=utf-8",
                              url: "./sel_gpxxzb_gpxxid",
                              data: JSON.stringify(data),
                              success: function (stGpxxzb) {
                                  console.log("lenght"+stGpxxzb.length);
                                  if (stGpxxzb.length >= 1) { //查询出来数据,说明存在进行update操作
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

                                      return;
                                  } else if (stGpxxzb.length == 0) { //说明以前没有gpxx，进行inser操作
                                      console.log("insert sqf " + data.gpxxid);
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

                                  }
                              }
                          });
                      }

                      //   $.ajax({
                      //       type: "POST",
                      //       contentType: "application/json; charset=utf-8",
                      //       //   dataType: "dataType",
                      //       url: "./insert_gpxxzb",
                      //       data: JSON.stringify(data),
                      //       success: function (list_gpxxzb) {
                      //           if (list_gpxxzb.length == 0) {
                      //               app.$message({
                      //                   type: 'error',
                      //                   message: "保存失败!"
                      //               });
                      //               return;
                      //           }
                      //           app.gpxx.data = [];
                      //           for (var i = 0; i < list_gpxxzb.length; i++) {
                      //               app.gpxx.data.push(list_gpxxzb[i]);
                      //           }
                      //       }
                      //   });
                      //   for (let k in data) row[k] = data[k];
                      //然后这边重新读取表格数据
                      //   app.readMasterUser();
                      row.isSet = false;
                  })();
              } else {
                  app.gpxx.sel = JSON.parse(JSON.stringify(row));
                  row.isSet = true;
              }
          }
      }
  });