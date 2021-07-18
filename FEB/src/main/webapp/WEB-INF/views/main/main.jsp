<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">
<main>



<%-- <c:out value="${sessionScope.member}"></c:out> --%>

  <section class="py-5 text-center container"  id="featureDiv">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">
		  Welcome ${sessionScope.member.name}!
        </h1>
        <p class="lead text-muted">
          This web site provides users with special post using markdown.
          You can see how your markdown text is affected in the preview below just by pressing Ctrl + Enter (or Convert button on mobile).
          We recommend you to sign up for a member and post!
        </p>
        <div class="col-4" style="margin: auto;">
          <label for="category" class="form-label">Category</label>
          <select class="form-select form-select-lg mb-3" onchange="chageCategorySelect('${sessionScope.member.email}');" id="categoryMainPage" style="font-size: medium;" aria-label=".form-select-lg example">
			<option value="nothing" selected="selected">entire</option>          
			<option value="daily life">daily life</option>          
			<option value="programming">programming</option>          
			<option value="java">java</option>          
			<option value="javascript">javascript</option>                 
			<option value="typescript">typescript</option>                 
			<option value="react">react</option>                 
			<option value="next">next</option>                 
          </select>
        </div>          
      </div>
    </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">

      <!-- <div id="mainPostsDiv" class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3"></div> -->
      <div id="mainPostsDiv" class="row row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-lg-3 g-3"></div>
      
    </div>
  </div>

</main>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//console.log("main");
		doRetrievePost("nothing", "0", "nothing", "0", '${sessionScope.member.email}');
	});
</script>