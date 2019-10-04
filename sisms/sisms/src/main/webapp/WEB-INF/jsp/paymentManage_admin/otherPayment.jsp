<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<form
			action="<%=request.getContextPath()%>/static/paymentManage_admin/insert"
			method="post" class="layui-form">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 读者号 </label>
				<div class="layui-input-inline">
					<input type="text" name="studentID" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
					<span>${studentID}</span>
				</div>
				<div class="layui-form-mid layui-word-aux">输入单个读者号或读者号范围，格式“151-159”</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 缴费类型 </label>
				<div class="layui-input-inline">
					<input type="text" name="payKind" required="" lay-verify="required"
						autocomplete="off" class="layui-input"> <span>${payKind}</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 费用 </label>
				<div class="layui-input-inline">
					<input type="text" name="payPrice" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
					<span>${payPrice}</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 到期时间 </label>
				<div class="layui-input-inline">
					<input type="date" name="deadline" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
					<span>${deadline}</span>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					发布</button>
			</div>
		</form>
		</xblock>


		<table class="layui-table">
			<thead>
				<tr>
					<th>序号</th>
					<th>读者号</th>
					<th>姓名</th>
					<th>缴费类型</th>
					<th>费用</th>
					<th>到期时间</th>
					<th>状态</th>
			</thead>
			<tbody>
				<c:forEach items="${stuList}" var="record">
					<c:if test="${record.payDate == null}">
						<tr>
							<td>${record.payNumber}</td>
							<td>${record.studentID}</td>
							<td>${record.studentName}</td>
							<td>${record.payKind}</td>
							<td>${record.payPrice}</td>
							<td>${record.deadline}</td>
							<td class="td-status"><span
								class="layui-btn layui-btn-normal layui-btn-mini">已发布</span></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});

		<script>
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