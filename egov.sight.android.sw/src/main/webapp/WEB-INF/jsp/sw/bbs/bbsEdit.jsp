<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 수정</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bbsPost.css">
		
		<!-- library js -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</head>
	<body>
		<div id="wrap" class="text-center">
			<%@ include file = "../../../../resources/jspf/header.jsp" %>
			
			<div id="postBbsWrap">
				<c:url var = "bbsEdit" value="bbsEditAction.do"></c:url>
				<form:form commandName="bbsEditVO" action="${bbsEdit}">
					<div class="form-group">
				 		<form:label path = "title" >제목</form:label>
						<form:input path = "title" cssClass="form-control input-sm" id="title"  required="required"/>
					</div>
					
					<div class="form-group">
						<form:label    path = "content" >글 작성</form:label>
						<form:textarea path = "content" htmlEscape="false" cssClass="form-control input-lg" id="content" required="required"/>
					</div>
			
					<form:hidden path="bbs_id"/>
					<div class ="submit">
						<input id ="submit" type = "submit" value="수정하기" class="btn btn-primary btn-lg">
					</div>
				</form:form>
			</div>	
		</div><!-- #wrap end -->
		<!-- END HTML -->
		
		<script src="${pageContext.request.contextPath}/resources/js/bbsPost.js"> </script>
	</body>
</html>