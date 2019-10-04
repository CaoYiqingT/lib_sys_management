<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta charset="UTF-8">
<title>Student management system </title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/font.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/xadmin.js"></script>
</head>

<body>

	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so layui-form-pane">
				<input type="text" name="username" placeholder="请输入查询信息"
					autocomplete="off" class="layui-input" id="query">
				<button class="layui-btn" onclick="member_query()">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock> <span class="x-right" style="line-height: 40px">共有数据：${size }条</span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>姓名</th>
					<th>学号</th>
					<th>性别</th>
					<th>宿舍号</th>
					<th>培养方案</th>
					<th>毕业时间</th>
			</thead>
			<tbody>
				<c:forEach items="${stuList}" var="list">
					<tr>
						<td>${list.studentName }</td>
						<td>${list.studentID }</td>
						<td>${list.sex }</td>
						<td>${list.dormNumber }</td>
						<td>${list.projectKind }</td>
						<td>${list.leaveDate }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
    layui.use(['form'], function(){
        form = layui.form;
        
      });
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
      
  	/*用户-查询*/
      function member_query(){
    	  var info = document.getElementById("query").value;
    	  var queryData = {
    			  "info" : info,
    			  "flag" : 1
    	  }
    	  
    	  $.ajax({
    		  type : 'POST',
    		  url : '<%=request.getContextPath() %>/leaveManage/QueryHelp',
    		  dataType : 'JSON',
    		  data : queryData,
    		  success : function(){},
    		  error : function(){
    			  window.location.href = "/sisms/leaveManage/Query"
    			  window.event.returnValue=false;
    		  }
    	  });
    	  
      }
  	
      </script>
</body>

</html>