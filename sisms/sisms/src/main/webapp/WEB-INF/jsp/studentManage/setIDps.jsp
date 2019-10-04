<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>学生综合服务管理系统</title>
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
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="L_qian" class="layui-form-label"> <span
					class="x-red">*</span>学号前缀
				</label>
				<div class="layui-input-inline">
					<input type="text" id="prefix" name="prefix" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button id="btn" class="layui-btn" onclick="submit_perfix()">
					一键编制</button>
			</div>
		</form>
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
      function submit_perfix(){
    	  var info = document.getElementById("prefix").value;
    	  //alert(info);
    	  var Data = {
    			  "prefix" : info
    			 
    	  }
    	  $.ajax({
    		  type : 'POST',
    		  url : '<%=request.getContextPath() %>/studentManage/setStuIdPre',
    		  dataType : 'JSON',
    		  data : Data,
    		  success : function(){},
    		  error : function(){
    			  
    		  }
    	  });
    	  var index = parent.layer.getFrameIndex(window.name);
          //关闭当前frame
          parent.layer.close(index);
          alert("编制成功！")
      }
    </script>
	<script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</body>

</html>