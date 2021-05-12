<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">
<main>



<%-- <c:out value="${sessionScope.member}"></c:out> --%>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">
		  Welcome ${sessionScope.member.name}!
        </h1>
        <p class="lead text-muted">
          This web site provides users with special post using markdown.
          You can see how your markdown text is affected in the preview below just by pressing Ctrl + Enter.
          We recommend you to sign up for a member and post!
        </p>
        <p>
          <a href="#" class="btn btn-primary my-2">Main call to action</a>
          <a href="#" class="btn btn-secondary my-2">Secondary action</a>
        </p>
      </div>
    </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">

      <div id="mainPostsDiv" class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3"></div>
      
    </div>
  </div>

</main>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//console.log("main");
		doRetrievePost("postCategoryNo", "0", '${sessionScope.member.email}');
	});
</script>