<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 국제화 태그 -->
<%@ taglib prefix= "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="hContext" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.82.0">
	<title>MDGround</title>

	<script src="${hContext}/resources/js/jquery.min.js"></script>
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>

	<!-- Bootstrap core CSS -->
	<link href="${hContext}/resources/assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">

	<title><tiles:getAsString name="title"/></title>

	<!-- 사용자 정의 스타일 입력 스타일시트 -->
	<link href="${hContext}/resources/assets/woogie.css" rel="stylesheet">
	
	<script src="${hContext}/resources/assets/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${hContext}/resources/js/sign.js"></script>
	<script src="${hContext}/resources/js/post.js"></script>
	<script src="${hContext}/resources/js/main.js"></script>
	<script src="${hContext}/resources/js/storage.js"></script>
	<script src="${hContext}/resources/js/member.js"></script>
	<script src="${hContext}/resources/js/follow.js"></script>
	<script src="${hContext}/resources/js/reply.js"></script>
	
</head>

<body>

	<div id="wrap">
		<!-- header -->
		<tiles:insertAttribute name="header" />
		<!--// header -->

		<!-- container -->
		<tiles:insertAttribute name="container" />
		<!--// container -->

		<!-- footer -->
		<tiles:insertAttribute name="footer" />
		<!--// footer -->
	</div>

</body>

</html>