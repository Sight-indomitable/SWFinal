<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
	<div class="container">
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="index.do">
	    	<spring:message code="header.title"/>
	    </a>
	  </div>
	  <div class="navbar-collapse collapse">
	    <ul class="nav navbar-nav">
			<li class="active">
				<a href="index.do"><spring:message code="header.main"/></a>
			</li>
			
			<li>
				<a href="bbsListView.do"><spring:message code="header.bbs"/></a>
			</li>
			
			<li>
				<a href="signin.do"><spring:message code="header.signupDropdown"/></a>
			</li>
	      	
	      	<li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		        	<spring:message code="header.signupDropdown"/> <span class="caret"></span>
	        	</a>
		        <ul class="dropdown-menu" role="menu">
					<li>
						<c:if test="${empty LoginUser}">
							<a href="login.do"><spring:message code="header.login"/></a>
						</c:if>
					</li>
					<li>
						<c:if test="${!empty LoginUser}">
							<a href="logout.do"><spring:message code="header.logout"/></a>
						</c:if>
					</li>
					<li><a href="#">미구현</a></li>
		        </ul>
	      	</li>
	    </ul>
	  </div><!--/.nav-collapse -->
	</div>
</nav>