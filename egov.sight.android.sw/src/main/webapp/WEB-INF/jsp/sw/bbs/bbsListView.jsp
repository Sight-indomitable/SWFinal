<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>게시판</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbsList.css">
		
		<!-- library js -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</head>
	<body>
		<div id="wrap" class="text-center">
			<%@ include file = "../../../../resources/jspf/header.jsp" %> <!-- 아... --> 								
			
			<div id="bbsListView-wrap">
			
				<c:if test="${empty LoginUser}">
					<div class="alert alert-info my-info">
						<strong>INFO!</strong> 로그인 해야만 글을 작성 할 수 있습니다.
					</div>
				</c:if>
				
				<div class="${status}">${message}</div>	<!-- 컨트롤러에서 받아오는 결과갑 -->
				
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>	
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${bbsList}" >
							<tr class="${index}">
								<td>${list.bbs_id}</td>
								<td>${list.title }</td>
								<td>${list.user_id}</td>	
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<c:if test="${!empty LoginUser}">
							<tr>
								<td colspan="3">
									<a href="bbsPost.do" class="btn btn-success btn-md">글쓰러 가기</a>
								</td>
							</tr>
						</c:if>
					</tfoot>
				</table>
			</div><!-- #bbsView-wrap end -->
		</div><!-- #warp end -->
		<!-- END HTML -->
		<script src="${pageContext.request.contextPath}/resources/js/bbsListView.js" ></script>
	</body>
</html>