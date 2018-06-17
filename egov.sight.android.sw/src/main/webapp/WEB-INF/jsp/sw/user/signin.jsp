<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>회원가입</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signin.css">
	</head>
	<body>
		<div id="wrap" class="text-center">
				<%@ include file = "../../../../resources/jspf/header.jsp" %> <!-- 아... --> 	
			<div id="signin-wrap">
				<c:url var = "signin" value="signinAction.do"></c:url>
				<form:form commandName="SigninVO" action="${signin}">
					<div class="form-group">
				 		<form:label path = "user_id" cssClass="col-sm-offset-0 col-sm-10">id:</form:label>
						<form:input path = "user_id" cssClass="form-control" id="id"  required="required"/>
					</div>
					
					<div class="form-group">
						<form:label path = "pw" cssClass="col-sm-offset-0 col-sm-10">pw:</form:label>
						<form:password path = "pw" cssClass="form-control" id="pw"  required="required"/>
					</div>
					
					<div class="form-group">
						<form:label path = "phone" cssClass="col-sm-offset-0 col-sm-10">phone:</form:label>
						<form:input path = "phone" cssClass="form-control" id="phone"  required="required"/>
					</div>
					
					<div class="">gender:</div>
					<div class="radio">
						<label><form:radiobutton  path = "gender" value="male"  />남자</label>
					</div>
					
					<div class="radio">
						<label><form:radiobutton  path = "gender" value="female" required="required"/>여자</label>
					</div>
					
					<div class ="submit">
						<input type = "submit" value="가입" class="btn btn-primary btn-lg">
					</div>
				</form:form>
			</div><!-- #signin-wrap end -->
		</div><!-- #warp end -->
		
		<!-- END HTML -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</body>
</html>