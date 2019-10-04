<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台登录-X-admin2.0</title>
	<script type = "text/javascript" src = "<%=request.getContextPath()%>/static/js/main.js"></script>
	<script src="https://cdn.staticfile.org/angular.js/1.4.6/angular.min.js"></script>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="static/css/font.css">
	<link rel="stylesheet" href="static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="static/js/xadmin.js"></script>

</head>
<body class="login-pf">
    <pre>  
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">  
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">  
    <META HTTP-EQUIV="expires" CONTENT="0">  
    </pre> 
    <div class="login layui-anim layui-anim-up">
        <div class="message">Mandarin安全中心|找回密码</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form">
            <input id="userName" name="userName" placeholder="请输入用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
             <input type="text" id="VerificationCode" name="VerificationCode"  placeholder="请输入验证码" class="verify" style="width:200px">
            <a href="javascript:void(0);" onclick="VerificationCode()">
                <img id="randCodeImage" alt="验证码"  src="VerificationCode/generate.action" width="100" height="40"/>
            </a>
            <hr class="hr15">
        </form>
        <button value="登录" class="layui-btn" style="width:100%;height:50px;" type="submit" onclick="email()">发送邮箱</button>
        <hr class="hr20" >
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
        /*$(function  () {
            layui.use('form', function(){
              var form = layui.form;
              // layer.msg('玩命卖萌中', function(){
              //   //关闭后的操作
              //   });
              //监听提交
              form.on('submit(login)', function(data){
                // alert(888)
                layer.msg(JSON.stringify(data.field),function(){
                    location.href='index.html'
                });
                return false;
              });
            });
        })
        */
        
        function email() {
      	  
      	  var selectdata = tableCheck.getData();
      	  //alert(selectdata);
      	  layer.confirm('确认要发送邮件'+selectdata+'？',function(index){
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
        

        
        function VerificationCode(){
            var rad = Math.floor(Math.random() * Math.pow(10, 8));
            //uuuy是随便写的一个参数名称，后端不会做处理，作用是避免浏览器读取缓存的链接
            $("#randCodeImage").attr("src", "VerificationCode/generate.action?uuuy="+rad);
        }

        
    </script>

    
    <!-- 底部结束 -->
    <script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
    </script>
</body>
</html>