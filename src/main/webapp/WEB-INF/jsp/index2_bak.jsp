
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"  rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap-editable.css"  rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>

</head>
<body>
            
		<table  class="table table-hover table table-striped" id="myTable">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addLayer">
				     <span class="glyphicon glyphicon-plus">新增数据</span> <!--添加记录-->
				</button>
				
				<!-- 			查询记录  -->
					 <form id="search_form" action="http://localhost:8080/gpxx/sqf1/" method="post">
			           <div class="row">
			                 <div class="col-md-2">
			                       <input type="text" id="search_item_name" class="form-control input-sm" placeholder="输入用户名" name="username" value="">
			                 </div>                
			                 <div class="col-md-9">
			                    
			                    <button id="search_btn" type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> 查询</button>&nbsp;&nbsp;
			                 </div>
			            </div> 
		             </form>
		             
				<thead>
					    <th>股票号</th>
						<th>股票名称</th>
						<th>买入时间</th>
						<th>买入价</th>
						<th>卖出时间</th>
						<th>卖出价</th>
						<th>股票数量</th>
						<th>股票金额</th>
						<th>股票天数</th>
						<th>股票收益</th>
				</thead>
				<tbody>
					<c:forEach items="${gpxxzb}" var="gpxxzb">
						 <tr>
						    <td>   ${gpxxzb.gpid}
						    </td>
						    <td>${gpxxzb.gpmc}</td>
						    <td>${gpxxzb.mrsj}</td>
						    <td>${gpxxzb.mrjg}</td>
						    <td>${gpxxzb.mcsj}</td>
						    <td>${gpxxzb.mcjg}</td>
						    <td>${gpxxzb.gpsl}</td>
						    <td>${gpxxzb.gpje}</td>
						    <td>${gpxxzb.gpts}</td>
						    <td>${gpxxzb.gpsy}</td>
						    <td>
						    	<!--  <button class="btn btn-success btn-xs"  data-toggle="modal" data-target="#editLayer" οnclick="editItems(${gpxxzb.gpid})"> <span class="glyphicon glyphicon-pencil"></span>修改</button> -->
						    	<input type="button" class="btn btn-primary input-small" value="修改" onclick="editItems()" />
						    	<!--<button class="btn btn-danger btn-xs" οnclick="deleteItem()"><span class="glyphicon glyphicon-remove"></span>删除</button> -->
						    	<input type="button" class="btn btn-primary input-small" value="删除" onclick="deleteItem(${gpxxzb.gpid})" />
						    </td>
		
						</tr>
						
					</c:forEach>
		
				</tbody>
				
	</table>
 
<!-- 			记录添加弹出层 -->
			<div class="modal fade" id="addLayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
			        <div class="modal-content">
			          <div class="modal-header">
			          
			            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			            <h4 class="modal-title">添加记录</h4>
			            
			          </div>
			            <div class="modal-body">
				            <form id="add_items_form" class="form-horizontal" enctype="multipart/form-data">
								<input type="text" class="form-control" placeholder="股票号"  name="gpid"> <br>
								<input type="text" class="form-control" placeholder="股票名称" name="gpmc"> <br>
								<input type="text" class="form-control" placeholder="买入时间" name="mrsj"> <br>
								<input type="text" class="form-control" placeholder="买入价" name="mrjg"> <br>
								<input type="text" class="form-control" placeholder="卖出时间" name="mcsj"> <br>
								<input type="text" class="form-control" placeholder="卖出价"  name="mcjg"> <br>
								<input type="text" class="form-control" placeholder="股票数量" name="gpsl"> <br>
								<input type="text" class="form-control" placeholder="股票金额" name="gpje"> <br>
								<input type="text" class="form-control" placeholder="股票天数" name="gpts"> <br>
								<input type="text" class="form-control" placeholder="股票收益" name="gpsy"> <br>
	                        </form>
				        </div>
			          
			          
			          <div class="modal-footer">
			            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
			           <!--  <button class="btn btn-primary" type="submit" οnclick="add_Item()">确认</button> -->
			          <input type="button" class="btn btn-primary" value="确认提交" onclick="add_Item()" />
			          </div>
			          
			        </div>
			      </div>
			</div>
			 <!-- <div style="height:200px"></div> -->
			            
             
  			<!--	记录修改弹出层 -->
			<div class="modal fade" id="editLayer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog">
			        <div class="modal-content">
			          <div class="modal-header">
			          
			            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			            <h4 class="modal-title">修改记录</h4>
			            
			          </div>
			            <div class="modal-body">
				            <form id="edit_items_form" class="form-horizontal">
				            	<input type="text" class="form-control" placeholder="股票号"  name="gpid"> <br>
								<input type="text" class="form-control" placeholder="股票名称" name="gpmc"> <br>
								<input type="text" class="form-control" placeholder="买入时间" name="mrsj"> <br>
								<input type="text" class="form-control" placeholder="买入价" name="mrjg"> <br>
								<input type="text" class="form-control" placeholder="卖出时间" name="mcsj"> <br>
								<input type="text" class="form-control" placeholder="卖出价"  name="mcjg"> <br>
								<input type="text" class="form-control" placeholder="股票数量" name="gpsl"> <br>
								<input type="text" class="form-control" placeholder="股票金额" name="gpje"> <br>
								<input type="text" class="form-control" placeholder="股票天数" name="gpts"> <br>
								<input type="text" class="form-control" placeholder="股票收益" name="gpsy"> <br>
	                        </form>
				        </div>
			          
			          
			          <div class="modal-footer">
			            <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
			            <button class="btn btn-primary" type="button" οnclick="updateItem()">确认修改</button>
			          </div>
			          
			        </div>
			      </div>
			</div>
			 <!-- <div style="height:200px"></div> -->
</body>
<script type="text/javascript">
  $(function(){
	  init();
  });
  function init(){
//	  alert("初始化界面...");
  }
  
	//删除记录
	function deleteItem(gpid){
		var formObject = {"gpid":gpid};
		$.ajax({
			type:"POST",
			data:JSON.stringify(formObject),
			//data:JSON.stringify(formData),
			url:"http://localhost:8080/gpxx/del/",
			
			dataTpye:"json",
			contentType: "application/json; charset=utf-8",
			processData:false,
			success:function(data){
				console.log(data);
				alert("删除成功!");
				window.location.reload();
			}
		});
	}

  
	//添加记录
	function add_Item(){
		var formObject = {};
        var formArray =$("#add_items_form").serializeArray();
        $.each(formArray,function(i,item){
            formObject[item.name] = item.value;
        });
		$.ajax({
			type:"POST",
			data:JSON.stringify(formObject),
			url:"http://localhost:8080/gpxx/insert/",
			
			dataTpye:"json",
			contentType: "application/json; charset=utf-8",
			processData:false,
			success:function(data){
				console.log(data);
				alert("记录添加成功!");
				window.location.reload();
			}
		});
	}
	
// 	“确认修改”按钮的点击事件
	function updateItem(){
		$.ajax({
			type:"POST",
			data:"wo",
			url:"${pageContext.request.contextPath }/admin/items/update.do",
			
			cache:false,
			contentType:"application/x-www-form-urlencoded",
			processData:false,
			success:function(){
				alert("修改成功!");
				window.location.reload();
			}
		});
	}
	
	//点击“修改”按钮，打开编辑窗口，回显数据
	
	
</script>
</html>