<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav aria-label="Page navigation">
<ul class="pagination">
	<c:forEach var="i" begin="1" end="${pageInfo.getPages() }">
	<li ${pageInfo.pageNum==i?"class='active'":"" }><a href="${pageContext.request.contextPath}/user/list?page=${i }">${i }</a></li>
	</c:forEach>
  </ul>
  </nav>