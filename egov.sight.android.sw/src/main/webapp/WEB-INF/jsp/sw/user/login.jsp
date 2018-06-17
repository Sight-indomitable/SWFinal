<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
	</head>
	<body>
		<div id="wrap" class="text-center">
				<%@ include file = "../../../../resources/jspf/header.jsp" %> <!-- 아... --> 	
			
			<div id="login-wrap">
				<c:url var = "login" value="loginAction.do"></c:url>
				<form:form commandName="LoginVO" action="${login}">
					<div class="form-group">
						<form:label path = "user_id" cssClass="col-sm-offset-0 col-sm-10">아이디:</form:label>
						<form:input path = "user_id" cssClass="form-control"/>
					</div>
					
					<div class="form-group">
						<form:label    path = "pw" cssClass="col-sm-offset-0 col-sm-10">비밀번호:</form:label>
						<form:password path = "pw" cssClass="form-control"/>
					</div>
					
					<div class ="submit">
						<input type = "submit" value="로그인" class="btn btn-primary btn-lg">
					</div>
				</form:form>
			</div><!-- #login-wrap end -->
		</div><!-- #warp end -->
		
		<!-- END HTML -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</body>
</html>