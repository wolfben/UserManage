<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../shared/_header.jsp"></jsp:include>
</head>
<body>
	<div>
		<input class="btn btn-default btn-add" type="button" value="添加">
	</div>
	<table class="table">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td><a href="detail?id=${item.id }">${item.name }</a></td>
				<td><input class="btn btn-danger btn-del" data-id="${item.id}"
					type="button" value="删除"></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="../shared/_footer.jsp"></jsp:include>
	<script>
		$(function() {
			$(".btn-add").click(function() {
				layer.open({
					type : 2,
					title : '添加用户',
					shadeClose : true,
					shade : 0.8,
					area : [ '380px', '350px' ],
					content : '${pageContext.request.contextPath}/user/add' //iframe的url
				});
			})

			$(".btn-del").click(function() {
				var obj = $(this);
				layer.confirm('确定要删除吗？', {
					icon : 3,
					title : '提示'
				}, function(index) {
					//do something
					var id = obj.attr("data-id");
					$.post("${pageContext.request.contextPath}/user/delete", {
						id : id
					}, function(data) {
						if (data.code == 1) {
							layer.msg('删除成功', {
								  icon: 1,
								  time: 2000 //2秒关闭（如果不配置，默认是3秒）
								}, function(){
									location.href = location.href;
								});
						} else {
							layer.msg(data.msg);
						}

					})

				});
			})
		})
	</script>
</body>
</html>