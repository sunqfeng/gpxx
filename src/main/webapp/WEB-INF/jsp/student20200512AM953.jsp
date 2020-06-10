

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DataTable</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="/gpxx/js/jquery-3.3.1.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/gpxx/css/bootstrap.min.css" rel="stylesheet">
  <script src="/gpxx/js/bootstrap.min.js"></script>
  <script type ="text/javascript"  src="/gpxx/js/bootstrap-paginator.js"></script>
  <style>
  </style>
</head>

<body>
<div class="container" style="padding-top: 40px;"><!--整个盒子居中-->
			<table class="table table-bordered text-center">
				<tr >
					<td colspan="4">
						<div class="form-group">
							<div class="row">
								<div class="col-md-8">
									<input  type="text" class="input-small secbox" placeholder="请输入学生号" />
									<input  type="text" class="input-small secboxbyname" placeholder="输入学生姓名" />
								</div>
								
								<div class="col-md-3">
									<button class="btn btn-danger sec">搜索</button><!--搜索确定-->
									<button class="btn btn-default add" data-toggle="modal" data-target="#addModal">增加</button>
									<!--data-toggle data-target 属性插入bootstrap事件自带的模态框事件-->
								</div>
							</div>
						</div>
					</td>
				</tr>
				<tr id="sqf">
					<td>编号</td>
					<td>姓名</td>
					<td>成绩</td>
					<td>操作</td>
				</tr>
			</table>
			<!--修改模态框-->
			<div class="modal fade up" tabindex="-1" role="dialog" id="updateModal">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">修改</h4>
			      </div>
			      <div class="modal-body">
			       	<form>
			       		<div class="form-group">
			       			<input type="text" placeholder="名字" id="studentname" class="form-control" />
			       		</div>
			       		<div class="form-group">
			       			<input type="text" placeholder="成绩" class="form-control" id="studentscore"/>
			       		</div>
			       	</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        <button type="button" class="btn btn-primary que_update">确定</button><!--确定修改-->
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div>
		</div>
		<!--增加模态框-->
		<div class="modal fade addmd" tabindex="-1" role="dialog" id="addModal">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">增加</h4>
			      </div>
			      <div class="modal-body">
			       	<form>
			       		<div class="form-group">
			       			<input type="text" placeholder="名字" id="addusrname" class="form-control" />
			       		</div>
			       		<div class="form-group">
			       			<input type="text" placeholder="成绩" class="form-control" id="addscore"/>
			       		</div>
			       	</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
			        <button type="button" class="btn btn-primary que_add">确定</button><!--确定添加-->
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div>
	</div>
	<div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
</body>
<script>


//增加
$(".que_add").click(function(){//点开增加按钮弹出的模态框后的确定按钮事件
	var arr=[]
	var num=$(".table tr").length
	var str=''
	var name=$(this).parent().siblings().find("input").val()//找到input框的内容并存放在命名为name的变量中
	var score=$(this).parent().siblings().find("input:not(:first)").val()//找到input框的内容并存放在命名为score的变量中
	$(this).parent().siblings().find("input").each(function(){//将两个input的内容用each方法遍历并用push方法逐个存放到叫arr的数组中
		arr.push($(this).val())	
		$(this).val("")
	})
	if (name==0||score==0) {//判断内容是否为空，否则弹窗"请输入一点东西"
		alert("请输入一点东西")
	} else{//是则加入到table中（表格）并把模态框关闭
		str='<tr><td>'+(num-1)+'</td><td>'+arr[0]+'</td><td>'+arr[1]+'</td><td><button class="btn btn-primary btn-xs update" data-toggle = "modal" data-target = "#updateModal">修改</button> <button class="btn btn-danger btn-xs del">删除</button></td></tr>'
		$("table").append(str)
		$(".addmd").modal("hide")
	}
})

//删除
			$(document).on("click",".del",function(){//找到点击的类目为del的按钮实现删除
				$(this).parents("tr").remove()
			})


			//对象缓存
			var _this=null
			$(document).on("click",".update",function(){
				_this=$(this).parents("tr")//缓存类名为update的父级tr项
			})
			//确定修改
			$(".que_update").click(function(){//同增加事件
				var arr=[]
				$(this).parent().siblings().find("input").each(function(){
					arr.push($(this).val())
					$(this).val("")
				})
				_this.find("td:not(:first):not(:last)").each(function(i){//同增加事件，但这里因为有arr[i]所以要在function()括号加个变量i
					$(this).text(arr[i])
				})
				//弹出模态框
				$(".up").modal("hide")
			})

			//搜索
			$(".sec").click(function(){//搜索框的点击事件

				$(".table  tr:gt(1)").empty(""); //每次搜索之前清空以前的缓存的值
				var data=$(".secbox").val()
				var data_student_name=$(".secboxbyname").val()
				if (data==0 && data_student_name==0 ) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
					alert("请输入该学生的学号或者姓名!!!")
				}else{//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色
					$(".table tr:not(:first):contains("+data+")").css("background","#D9EDF7")
					$(this).blur(function(){//离开搜索框是变成默认颜色
						$(".secbox").val("")
						$(".table tr").css("background","#fff")
					})
				}
				if( data_student_name!=0 ){
					byname()	//姓名不为空，那么优先对姓名进行查询
					return true
					}
				$.ajax({
					type: "POST",
					url:"./studentscore",
					data: {
						studentid:data,  // 后台取数据的key: 前台要发送的数据
						studentname:data_student_name
				    },
					success:function(objstudent){
						//Object.keys(myObject).length
						if (objstudent.studentid==undefined){
							alert("没有该学生的信息!!!!")
							return false
						}
						var str=''
						str='<tr><td>'+objstudent.studentid+'</td><td>'+objstudent.studentname+'</td><td>'+objstudent.studentscore+'</td><td><button class="btn btn-primary btn-xs update" data-toggle = "modal" data-target = "#updateModal">修改</button> <button class="btn btn-danger btn-xs del">删除</button></td></tr>'
						//用for循环将json文件里的name和age拼接成字符串
						$(".table").append(str)
						//将刚才保存的字符串append（在被选元素的结尾（仍然在内部）插入指定内容）到我们的HTML里面
					}
				});
			})

//根据姓名查询
function byname(){
	$(".table").append("")
	var data=$(".secbox").val()
	var data_student_name=$(".secboxbyname").val()
	if (data==0 && data_student_name==0 ) {//判断搜索框是否为空，是则弹窗"请输入一点东西"
		alert("请输入一点东西")
	}else{//否则搜索内容为搜索框（.secbox）里的内容（val）的项将他的背景颜色改成淡蓝色
		$(".table tr:not(:first):contains("+data+")").css("background","#D9EDF7")
		$(this).blur(function(){//离开搜索框是变成默认颜色
			$(".secbox").val("")
			$(".table tr").css("background","#fff")
		})
	}
	$.ajax({
		type: "POST",
		url:"./studentname",
		data: {
			studentid:data,  // 后台取数据的key: 前台要发送的数据
			studentname:data_student_name
	    },
		success:function(list_student){
			//判断结构体变量是否有值
			var count = Object.keys(list_student).length
			if (count==0 ){
				alert("没有该学生的信息!!!!")
				return false
			}

			var str=''
			for (var i=0;i<list_student.length;i++){
			str+='<tr><td>'+list_student[i].studentid+'</td><td>'+list_student[i].studentname+'</td><td>'+list_student[i].studentscore+'</td><td><button class="btn btn-primary btn-xs update" data-toggle = "modal" data-target = "#updateModal">修改</button> <button class="btn btn-danger btn-xs del">删除</button></td></tr>'
			}
			//用for循环将json文件里的name和age拼接成字符串
			$(".table").append(str)
			//将刚才保存的字符串append（在被选元素的结尾（仍然在内部）插入指定内容）到我们的HTML里面
		}
	});

	$(".secbox").val("")
	$(".secboxbyname").val("")
}

$('#pageLimit').bootstrapPaginator({
	currentPage: 1,//当前的请求页面。
	totalPages: 20,//一共多少页。
	size:"normal",//应该是页眉的大小。
	bootstrapMajorVersion: 3,//bootstrap的版本要求。
	alignment:"right",
	numberOfPages:5,//一页列出多少数据。
	itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
	switch (type) {
	case "first": return "首页";
	case "prev": return "上一页";
	case "next": return "下一页";
	case "last": return "末页";
	case "page": return page;
	}
	},
	pageUrl: function(type, page, current){
        if (page==current) {
            return "javascript:void(0)";
        } else {
            return "./Articles?pageSize=15&pageIndex="+page;
        }
    }
	});

</script>

</html>