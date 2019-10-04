<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生综合服务管理系统-admin1.0</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/font.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/xadmin.js"></script>
        <script type="text/javascript">
function backspace() {
if (event.keyCode == 8 && event.srcElement.tagName != "INPUT" && event.srcElement.type != "text")
            event.returnValue = false;
     }
if (navigator.appName == "Microsoft Internet Explorer") {
         window.history.forward(1);
     }
else // if it is Mozilla than

     {
         window.history.forward(-1);
     }    
</script>
</head>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="<%=request.getContextPath() %>/adminLogin">Mandarin</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${name }</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->

					<dd>
						<a href="<%=request.getContextPath() %>/logout">退出</a>
					</dd>
				</dl></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
						<cite>读者信息管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/studentManage/newStuInfo">
								<i class="iconfont">&#xe6a7;</i> <cite>读者信息</cite>
						</a></li>

						<li><a
							_href="<%=request.getContextPath() %>/studentManage/setStuID">
								<i class="iconfont">&#xe6a7;</i> <cite>新注册读者管理</cite>

						</a></li>
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont">&#xe699;</i>
						<cite>收费系统</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/static/paymentManage_admin/list">
								<i class="iconfont">&#xe6a7;</i> <cite>查询罚金记录</cite>
						</a></li>
						<li><a
							_href="<%=request.getContextPath() %>/static/paymentManage_admin/other">
								<i class="iconfont">&#xe6a7;</i> <cite>发布罚金</cite>
						</a></li>
						<li>
                        <a _href="<%=request.getContextPath() %>/leaveManage/fycate">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>费用结算</cite>
                        </a>
                    </li > 
					</ul></li>
				<li><a href="javascript:;"> <i class="icon iconfont"></i>
						<cite>借书管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<!-- 		<li><a
							_href="<%=request.getContextPath() %>/dormManage/addRoom"> <i
								class="iconfont">&#xe6a7;</i> <cite>房间信息管理</cite>
						</a></li>
						<li><a
							_href="<%=request.getContextPath() %>/dormManage/checkIn"> <i
								class="iconfont">&#xe6a7;</i> <cite>入住信息管理</cite>
						</a></li>     -->
						<li><a
							_href="<%=request.getContextPath() %>/dormManage/handelDormApply">
								<i class="iconfont">&#xe6a7;</i> <cite>借阅申请处理</cite>
						</a></li>
					</ul></li>

				<li><a href="javascript:;"> <i class="iconfont">&#xe723;</i>
						<cite>书籍管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/textBookManage/jcInformation">
								<i class="iconfont">&#xe6a7;</i> <cite>书籍信息</cite>
						</a></li>
					</ul>
				<!--  	<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/textBookManage/jcCheck">
								<i class="iconfont">&#xe6a7;</i> <cite>教材审定</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/textBookManage/jcPurchase">
								<i class="iconfont">&#xe6a7;</i> <cite>教材征订</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/textBookManage/jcProvide">
								<i class="iconfont">&#xe6a7;</i> <cite>教材发放</cite>
						</a></li>
					</ul> -->
					</li>
		<!--  		<li><a href="javascript:;"> <i class="iconfont">&#xe699;</i>
						<cite>离校管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a
							_href="<%=request.getContextPath() %>/leaveManage/xscate"> <i
								class="iconfont">&#xe6a7;</i> <cite>离校学生信息</cite>
						</a></li>
						<li><a
							_href="<%=request.getContextPath() %>/leaveManage/jscate"> <i
								class="iconfont">&#xe6a7;</i> <cite>借书情况审核</cite>
						</a></li>
					</ul></li>    -->
				<li><a href="javascript:;"> <i class="iconfont">&#xe726;</i>
						<cite>管理员操作</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
					<!-- 	<li><a
							_href="<%=request.getContextPath()%>/adminManage/adminRole">
								<i class="iconfont">&#xe6a7;</i> <cite>角色管理</cite>
						</a></li>   -->
						<li><a
							_href="<%=request.getContextPath()%>/adminManage/editAtt"> <i
								class="iconfont">&#xe6a7;</i> <cite>公告编辑</cite>
						</a></li>
					</ul></li>

			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的主页</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='<%=request.getContextPath() %>/welcome'
						frameborder="0" scrolling="yes" class="x-iframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2018 Mandarin All Rights
			Reserved</div>
	</div>
</body>
</html>