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
        <h1 class="fw-light">Album example</h1>
        <p class="lead text-muted">Something short and leading about the collection belowâits contents, the creator, etc. Make it short and sweet, but not too short so folks donât simply skip over it entirely.</p>
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
		console.log("main");
		doRetrieve("postCategoryNo", "0");
	});
</script>