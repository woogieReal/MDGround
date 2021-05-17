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
	<script src="${hContext}/resources/js/member.js"></script>
	
</head>

<body>
<div class="container" style="width: 100%; margin: auto; padding: 30px;">
  <!-- contents -->
  <c:choose>
	<c:when test="${fromTb == 1}">
	  <span class="page_title_name" style="font-size: x-large;"><c:out value="Post Images Upload"></c:out></span>
      <input type="button" class="btn btn-primary btn-right" onclick="doUploadImages();" id="file_upload" value="upload" />
	</c:when>
	<c:when test="${fromTb == 2}">
	  <span class="page_title_name" style="font-size: x-large;"><c:out value="Profile Image Upload"></c:out></span>
      <input type="button" class="btn btn-primary btn-right" onclick="doUploadProfileImage();" id="file_upload" value="upload" />
	</c:when>
  </c:choose>
  <hr>
  
	<input type="hidden" name="fromTb" id="fromTb" value="${fromTb}" />

	<c:if test="${fromTb == 2}">
	  <input type="hidden" name="profileImagePath" id="profileImagePath" value="${profileImagePath}"/>
	  <input type="hidden" name="profileImageName" id="profileImageName" value="${profileImageName}"/>
	</c:if>
	
  <form action="${hContext}/image/do_upload.do" id="uploadFrm" id="uploadFrm" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
	
	<div class="container">
	  <input type="file" class="form-control" name="file_list" id="file_list" <c:if test="${fromTb == 1}">multiple="multiple"</c:if> />
    </div>
  
  </form>
  <!-- //contents -->
</div>

</body>

</html>