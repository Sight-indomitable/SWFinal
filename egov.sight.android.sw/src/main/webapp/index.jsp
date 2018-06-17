<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Insert title here</title>
		
		<!-- library css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- layout css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
		
		<!-- library js -->
		<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	</head>

	<body>
		<div id="wrap">
			<%@ include file = "resources/jspf/header.jsp" %>
			
			<div id="index-wrap">
				<div class="${status} myAlert">
					${message}
				</div>
				
			</div><!-- #index-wrap end -->	
			
			 <!-- 캐러셀 코드 -->
			<div id="myCarousel-warp">
			  <h2>SW Framework</h2>  
			  <div id="myCarousel" class="carousel slide" data-ride="carousel">
			    <!-- Indicators -->
			    <ol class="carousel-indicators">
			      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1"></li>
			      <li data-target="#myCarousel" data-slide-to="2"></li>
			    </ol>
			
			    <div class="carousel-inner">
					<div class="item active">
					  <img src="${pageContext.request.contextPath}/resources/image/chicago.jpg" alt="carou1.jpg" style="width:100%;">
					</div>
					
					<div class="item">
					  <img src="${pageContext.request.contextPath}/resources/image/la.jpg" alt="carou2.jpg" style="width:100%;">
					</div>
					
					<div class="item">
					  <img src="${pageContext.request.contextPath}/resources/image/ny.jpg" alt="carou3.jpg" style="width:100%;">
					  </div>
					</div>
					
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" data-slide="prev">
					  <span class="glyphicon glyphicon-chevron-left"></span>
					  <span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" data-slide="next">
					  <span class="glyphicon glyphicon-chevron-right"></span>
					  <span class="sr-only">Next</span>
					</a>
				</div>
			</div><!-- #container end -->	
		</div><!-- #wrap end -->
		<!-- END HTML -->
		
	</body>
</html>