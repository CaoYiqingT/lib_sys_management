<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>编辑</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/font.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/xadmin.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/jquery.codify.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/htmlbox.colors.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/htmlbox.styles.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/htmlbox.syntax.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/htmlbox.full.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/htmlbox.undoredomanager.js"></script>
</head>
<body>
	<div class="x-body">

		<div id="main" style="width: 100%; height: 400px;">
			<textarea id="notice"></textarea>
			<script language="Javascript" type="text/javascript">
			$("#notice").css("height","100%").css("width","100%").htmlbox({
			toolbars:[
			[
			// Cut, Copy, Paste
			"separator","cut","copy","paste",
			// Undo, Redo
			"separator","undo","redo"
			]
			],
			skin:"gray"
			});
			</script>
		</div>
		<hr class="hr15">
		<input value="发布" lay-submit lay-filter="发布" style="width: 10%;"
			type="submit" onclick="sub()">
		<hr class="hr20">
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
      
      function sub() {
    	  
    	  var context = $("#notice").val();
    	  
    	  var postData = {
    			  "context" : context
    	  }
    	  $.ajax({
    		  type : 'post',
    		  url : '<%=request.getContextPath()%>/adminManage/sub',
    		  dataType : 'json',
    		  data : postData,
    		  success : function() {
    			  
    		  },
    		  error : function() {
    			  alert("发布成功");
    		  }
    	  });
      }
    </script>
</body>
</html>