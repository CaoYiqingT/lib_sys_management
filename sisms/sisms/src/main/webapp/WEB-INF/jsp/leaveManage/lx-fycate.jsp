<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta charset="UTF-8">
<title>Student management system</title>
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

	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so layui-form-pane">
				<input type="text" name="username" placeholder="" autocomplete="off"
					class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock> <span class="x-right" style="line-height: 40px">共有数据：88
			条</span> </xblock>
		<table class="layui-table layui-form">
			<thead>
				<tr>
					<th width="20">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th width="120">姓名</th>
					<th width="120">读者号</th>
					<th>欠款金额</th>
					<th>是否缴纳</th>
					<th width="220">状态</th>
			</thead>
			<tbody class="x-cate">
				<tr cate-id='1' fid='0'>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary"
							data-id='2'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					<td>刘杨</td>
					<td>2015303399</td>
					<td>12000</td>
					<td>
						<div class="layui-input-inline">
							<select name="contrller">
								<option>是</option>
								<option>否</option>
							</select>
						</div>
					</td>
					<td><input type="checkbox" name="switch" lay-text="已批|未批"
						checked="1" lay-skin="switch"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<style type="text/css">
</style>

</body>

</html>