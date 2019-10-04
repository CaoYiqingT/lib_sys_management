<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<xblock>
		<button class="layui-btn" onclick="email()">
			<i class="icon iconfont"></i>批量提醒
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：${size }条</span>
		</xblock>
		<table class="layui-table layui-form">
			<thead>
				<tr>
					<th width="20">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th width="100">离校学生姓名</th>
					<th width="90">学号</th>
					<th>借书信息</th>
			</thead>
			<tbody class="x-cate">
				<c:forEach items="${stuList }" var="list">
					<tr cate-id='1' fid='0'>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='${list.studentID }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${list.studentName }</td>
						<td>${list.studentID }</td>
						<td><c:forEach items="${list.borrowBook }" var="list1">
            		《${list1.borrowName}》
            	</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
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
      
      function email() {
    	  
    	  var selectdata = tableCheck.getData();
    	  //alert(selectdata);
    	  layer.confirm('确认要发送邮件给'+selectdata+'?',function(index){
              //捉到所有被选中的，发异步进行删除
              var postData= { //（2）传递参数到后台，注意后台接收方式 
  	       		"param1":selectdata,
                  //areaId:2,
                  //deleteId:3,
                  //"ids" : selectData + ""
  	    	  }

  	    	  $.ajax({
  	              async : false,
  	              cache : false,
  	              type : 'POST',
  	              url : '<%=request.getContextPath() %>/leaveManage/email',
  	              dataType : "JSON",
  	              data : postData,  
  	              traditional:true,
  	              error : function() {
  	                  //alert('请求失败 ');
  	              },
  	              success : function() {
  	                  alert(data);
  	              }
  	          });
  	            layer.msg('发送成功', {icon: 1});
  	            //$(".layui-form-checked").not('.header').parents('tr').remove();
  	        });
      }
      
      /*用户-查询*/
      function member_query(){
    	  var info = document.getElementById("query").value;
    	  var queryData = {
    			  "info" : info,
    			  "flag" : 2
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