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
	<table class="table">
		<tr>
		<td>姓名：<input type="text" id="username"/></td>
		</tr>
		<tr>
		<td><input class="btn btn-default btn-add" type="button" value="添加"></td>
		</tr>
	</table>
<jsp:include page="../shared/_footer.jsp"></jsp:include>
<script>
$(function(){
	$(".btn-add").click(function(){
		var username=$("#username").val();
		$.post("${pageContext.request.contextPath}/user/insert",{name:username},function(data){
			console.log(data);
			if(data.code==1){
				layer.msg("添加成功",{icon:1,time:1500},function(){
					parent.location.href=parent.location.href;
				});
	
			}else{
				layer.msg(data.msg);
			}
		})
	})
})
</script>
</body>
</html>