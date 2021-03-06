<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="p-3 bg-dark text-white">
  <div class="container">
    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
      
      <button type="button" class="btn-image" style="margin: -8px 5px;" onclick="doMoveToMain();"><i class="bi bi-markdown i_icon_logo"></i></button> 
      
      <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
        <li><button type="button" class="btn-image" style="margin: 8px 5px; color: white;" onclick="doMoveToMain();">Home</button></li>
        <li><a href="#featureDiv" class="nav-link px-2 text-white">Features</a></li>
      </ul>

      <form id="searchFrm" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
      	
        <!-- <input type="search" class="form-control form-control-dark" placeholder="Search..."> -->
      </form>

      <div class="text-end">
      <form id="moveFrm">
      	<c:choose>
      	  <c:when test="${sessionScope.member != null}">
            <button type="button" onclick="doMovePost();" class="btn btn-outline-light me-2">post</button>
            <button type="button" onclick="doLogOut();" class="btn btn-outline-light me-2">Log out</button>
            <div id="headerProfileImageDiv" class="inline_block_div">
              
            </div>
      	  </c:when>
      	  <c:when test="${sessionScope.member == null}">
            <button type="button" onclick="doMoveToSignIn();" class="btn btn-outline-light me-2">Login</button>
            <button type="button" onclick="doMoveToSignUp();" class="btn btn-warning">Sign-up</button>
      	  </c:when>
      	</c:choose>
      </form>
      </div>
    </div>
  </div>
</header>
<script type="text/javascript">
	$(document).ready(function() {
		if(${sessionScope.member != null}){
			doSelectProfileImage('${sessionScope.member.email}');
		}
	});
</script>
