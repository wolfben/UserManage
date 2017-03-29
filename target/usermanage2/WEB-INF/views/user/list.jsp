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
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td><a href="detail?id=${item.id }">${item.name }</a></td>
			</tr>
		</c:forEach>
	</table>
<jsp:include page="../shared/_footer.jsp"></jsp:include>
<script>
$(function(){
	$(".btn-add").click(function(){
		layer.open({
			  type: 2,
			  title: '添加用户',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['380px', '350px'],
			  content: '${pageContext.request.contextPath}/user/add' //iframe的url
			}); 
	})
})
</script>
</body>
</html>