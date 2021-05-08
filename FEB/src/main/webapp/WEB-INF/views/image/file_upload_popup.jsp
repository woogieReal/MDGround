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
	<title>ENHANCE</title>

	<script src="${hContext}/resources/js/jquery.min.js"></script>
	<script src="${hContext}/resources/js/bootstrap.min.js"></script>

	<!-- Bootstrap core CSS -->
	<link href="${hContext}/resources/assets/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- 사용자 정의 스타일 입력 스타일시트 -->
	<link href="${hContext}/resources/assets/woogie.css" rel="stylesheet">
	
	<script src="${hContext}/resources/assets/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${hContext}/resources/js/sign.js"></script>
	<script src="${hContext}/resources/js/post.js"></script>
	
</head>

<body>
<div style="width: 100%; margin: auto; padding: 30px;">
  <!-- contents -->
  <c:choose>
	<c:when test="${fromTb == 1}">
	   <span class="page_title_name" style="font-size: x-large;"><c:out value="Post Images Upload"></c:out></span>
	</c:when>
	<c:when test="${fromTb == 2}">
	   <span class="page_title_name" style="font-size: x-large;"><c:out value="Recipe Images Upload"></c:out></span>
	</c:when>
  </c:choose>
  <input type="button" class="btn btn-primary btn-right" onclick="doUploadImages();" id="file_upload" value="등록" />
  <hr>
  
	<!-- 레시피 or 상품등록 페이지에서 넘겨받은 값 -->
	<input type="hidden" name="fromTb" id="fromTb" value="${fromTb}" />

  <form action="${hContext}/image/do_upload.do" id="uploadFrm" id="uploadFrm" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
	
	<input type="file" class="form-control" name="file_list" id="file_list" multiple="multiple" style="width: 400px" />
  
  </form>
  <!-- //contents -->
</div>

</body>

</html>