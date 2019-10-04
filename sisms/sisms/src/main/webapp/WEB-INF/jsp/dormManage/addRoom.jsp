<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>学生综合服务管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/font.css">
<link rel="stylesheet" type="text/css"
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

<body class="layui-anim layui-anim-up">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加宿舍','<%=request.getContextPath() %>/room-add',600,400)">
			<i class="layui-icon"></i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：${size} 条</span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>宿舍号</th>
					<th>容纳人数</th>
					<th>类型</th>
					<th>价格</th>
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${dList}" var="list">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" name="selected" data-id='${list.dormNumber }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${list.dormNumber }</td>
						<td>${list.dormKind }</td>
						<td>${list.sex }</td>
						<td>${list.dormPrice }</td>
						<td class="td-manage">
							<button class="layui-btn layui-btn layui-btn-xs"
								onclick=" member_edit('${list.dormNumber }','编辑','<%=request.getContextPath()%>/dormManage/dormEdit')">
								<i class="layui-icon">&#xe642;</i>编辑
							</button>
						</td>
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
      
      /*用户-编辑*/
  	function member_edit(dormNumber,title,url,w,h){
  		//alert(dormNumber);
  		var bookDate={
  				dormNumber:dormNumber
  	        }
  	        $.ajax({
  	      	  type:"POST",
  	      	  url:"<%=request.getContextPath() %>/dormManage/dormEditHelp",
  	      	  data:bookDate,
  	      	  success:function(data){	
  	      	  }
  	        });
  	    
  		if (title == null || title == '') {
  	        title=false;
  	    };
  	    if (url == null || url == '') {
  	        url="404.html";
  	    };
  	    if (w == null || w == '') {
  	        w=($(window).width()*0.9);
  	    };
  	    if (h == null || h == '') {
  	        h=($(window).height() - 50);
  	    };
  	    layer.open({
  	        type: 2,
  	        area: [w+'px', h +'px'],
  	        fix: false, //不固定
  	        maxmin: true,
  	        shadeClose: true,
  	        shade:0.4,
  	        title: title,
  	        content: url
  	    })
  	}

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }

      function delAll (argument) {

        var selectdata = tableCheck.getData();
        
        layer.confirm('确认要删除'+selectdata+'?',function(index){
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
	              url : '<%=request.getContextPath() %>/dormManage/deleteDorm',
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
	            layer.msg('删除成功', {icon: 1});
	            //$(".layui-form-checked").not('.header').parents('tr').remove();
	        });
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