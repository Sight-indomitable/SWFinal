<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>${bbs.bbs_id}번째 게시글</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbsView.css">
		
		<!-- library js -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</head>
	
	<body>
		<div id="wrap" class="text-center">
			<%@ include file = "../../../../resources/jspf/header.jsp" %>				
		
			<div id="bbsViewWrap">
				<div class="panel panel-success" id="bbsView">
					<div class="panel-heading">
						<span class="bbsTitle">제목 : ${bbs.title}</span>
						<span class="user_id" >작성자 :${bbs.user_id}</span>
					</div>
					<textarea class="panel-body bbs-content" readonly>${bbs.content}</textarea>
		    	</div>
		    	
		    	<c:if test="${LoginUser.user_id eq bbs.user_id}">	<!-- 로그인한 유저가 작성자 일 경우 -->
		    		<div id="bbnEditBtn">
		    			<a href="bbsEdit.do?id=${bbs.bbs_id}"   class="btn btn-warning btn-md">수정하기</a>
		    			<a href="bbsDelete.do?id=${bbs.bbs_id}" class="btn btn-danger  btn-md">삭제하기</a>
		    		</div>
    			</c:if>
	    	</div><!-- #bbsViewWrap end -->
		</div><!-- #wrap end -->
		<!-- end HTML -->
				
	</body>
</html>