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
          	  	<td rowspan="3">
          	  	  <button type="button" class="btn-image"><img class="bd-placeholder-img profile_img_my_page" src="/feb/resources/image_source/javascript.png"></button>
          	  	</td>
          	  	<td>
          	  	  <h2>${memberVO.email}</h2>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td style="font-size: large;">
          	  	  <button type="button" class="btn-image"><span style="font-weight: bold;">Follow ${followingCount}</span></button>
          	  	  <button type="button" class="btn-image"><span style="font-weight: bold;">Follower ${followedCount}</span></button>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td>
          	  	  <span style="margin-left: 5px; vertical-align: super;">${memberVO.name}</span>
          	  	  <c:choose>
          	  	    <c:when test="${sessionScope.member.email == memberVO.email}">
          	  	      <div class="inline_block_div">
          	  	        <form id="editFrm">
          	  	          <button type="button" style="padding: 2px 10px; margin: -10px 0px 0px 10px;" class="btn btn-outline-primary">Edit</button>
          	  	        </form>
          	  	      </div>
          	  	    </c:when>
          	  	    <c:when test="${sessionScope.member.email != memberVO.email && sessionScope.member != null}">
          	  	      <div class="inline_block_div" id="my_page_icon_follow">
          	  	        <c:choose>
           	  	          <c:when test="${followFlag == 0}">
          	  	            <button type="button" class="btn-image" onclick="doFollow('${memberVO.email}', '${sessionScope.member.email}');" style="margin: -5px 0px 0px 15px;"><i class="bi bi-person-plus i_icon"></i></button>
            	  	      </c:when>
          	  	        </c:choose>
          	  	        <c:choose>
          	  	          <c:when test="${followFlag == 1}">
          	  	            <button type="button" class="btn-image" onclick="doCancelFollow('${memberVO.email}', '${sessionScope.member.email}');" style="margin: -5px 0px 0px 15px;"><i class="bi bi-person-plus-fill i_icon"></i></button>
          	  	          </c:when>
          	  	        </c:choose>
          	  	      </div>
          	  	    </c:when>
          	  	    <c:when test="${sessionScope.member == null}">
          	  	    </c:when>
          	  	  </c:choose>
          	  	</td>
          	  </tr>

          	</tbody>
          </table>
        </div>		
		
        
        <div class="container text_div">
        </div>
 
          
      </div>
    </article>


</div>