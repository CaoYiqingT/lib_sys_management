<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>学生管理系统</title>
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
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body layui-anim layui-anim-up">
		<form id="mycheck" class="layui-form">
			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>学号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="studentID" name="studentID" required=""
						value="${student.studentID} " lay-verify="required"
						autocomplete="off" class="layui-input" readonly>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="studentName" name="studentName"
						value="${student.studentName}" required="" lay-verify="required"
						autocomplete="off" class="layui-input" readonly>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="L_pass" class="layui-form-label"> <span
					class="x-red">*</span>宿舍号
				</label>
				<div class="layui-input-inline">
					<input type="text" id="dormNumber" name="dormNumber"
						value="${student.dormNumber}" required="" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
	</div>


	<div class="layui-form-item">
		<label for="L_repass" class="layui-form-label"> </label>
		<button class="layui-btn" id="bt1">完成</button>
	</div>
	</form>
	</div>
	<script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          
          $(function(){
        	    $("#bt1").click(function(){
        	    	var newUrl = '<%=request.getContextPath() %>/dormManage/checkUpdate';    //设置新提交地址
        	        $("#mycheck").attr('action',newUrl);
        	        $("#mycheck").submit();    //提交ID为myform的表单
        	        /*layer.alert("增加成功", {icon: 6},function () {
                        // 获得frame索引*/
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    /*})*/
        	    })
        	});
        });
    </script>
	<script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</body>

</html>