<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">

<%-- ${vo} --%>

    <article class="my-3" id="card">
      <div class="container basic_div squircle_div">
  		
  		
        <div class="card-header">
          
          <table class="member_detail_table_my_page">
          	<tbody>
          	  <tr>
          	  	<td rowspan="4">
          	  	  <button type="button" class="btn-image"><img class="bd-placeholder-img profile_img_my_page" src="/feb/resources/image_source/javascript.png"></button>
          	  	</td>
          	  	<td>
          	  	  <h2>${memberVO.email}</h2>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td style="font-size: large;">
          	  	  <button type="button" class="btn-image"><span style="font-weight: bold;">Follower 0</span></button>
          	  	  <button type="button" class="btn-image"><span style="font-weight: bold;">Followed 0</span></button>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td>
          	  	  <span style="margin-left: 4px;">${memberVO.name}</span>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td>
          	  	  <span style="margin-left: 4px;">temporary</span>
          	  	</td>
          	  </tr>
          	</tbody>
          </table>
        </div>		
		
        
        <div class="container text_div">
        </div>
        
<%--         <c:choose>
          <c:when test="${sessionScope.member.email == vo.memberEmail}">
			<div class='container btn-group i_icon_div inline_block_div'>
			  <form id="postViewFrm" name="postViewFrm" method="post">
			    <input type="hidden" id="postNo" name="postNo" value="${vo.postNo}">                                                       
			    <input type="hidden" id="imageListStr" value='${imageListStr}'>                                                       
			    <button type='button' onclick="doMoveToEdit();" class='btn btn-sm btn-outline-secondary'>Edit</button>
			    <button type='button' onclick="doDelete();" class='btn btn-sm btn-outline-secondary'>Delete</button>
			  </form>
			</div> 
          </c:when>
         <c:when test="${sessionScope.member.email != vo.memberEmail && sessionScope.member != null}">
	        <div class="container i_icon_div">
		      <div class="inline_block_div" id="post_icon_bookmark${vo.postNo}">
		        <c:choose>
		          <c:when test="${bookmarkFlag == 1}">
		            <button type="button" onclick="doCancelStore(1, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image"><i class="bi bi-bookmark-fill i_icon"></i></button>
		          </c:when>
		          <c:when test="${bookmarkFlag == 0}">
		            <button type="button" onclick="doStore(1, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image"><i class="bi bi-bookmark i_icon"></i></button>
		          </c:when>
		        </c:choose>
		      </div>
		      <div class="inline_block_div" id="post_icon_heart${vo.postNo}">
		        <c:choose>
		          <c:when test="${likeFlag == 1}">
		            <button type="button" onclick="doCancelStore(2, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image"><i class="bi bi-heart-fill i_icon"></i></button>
		          </c:when>
		          <c:when test="${likeFlag == 0}">
		            <button type="button" onclick="doStore(2, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image"><i class="bi bi-heart i_icon"></i></button>
		          </c:when>
		        </c:choose>
		      </div>
	        </div>
          </c:when>
          <c:when test="${sessionScope.member == null}">
          </c:when>
        </c:choose> --%>
        
        
          
      </div>
    </article>


</div>