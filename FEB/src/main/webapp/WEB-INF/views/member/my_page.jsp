<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">

<%-- ${vo} --%>

    <article class="my-3" id="card">
      <div class="container basic_div_900 squircle_div">
  		
  		
        <div class="card-header">
          
          <table class="member_detail_table_my_page">
          	<tbody>
          	  <tr>
          	  	<td rowspan="3">
          	  	  <form name="image_frm" id="image_frm">
          	  	    <input type="hidden" name="fromTb" id="fromTb" value="2"/>
          	  	    <input type="hidden" name="fromNo" id="fromNo" value="${memberVO.memberNo}"/>
          	  	    <input type="hidden" name="profileImagePath" id="profileImagePath" value="${profileImage.path}"/>
          	  	    <input type="hidden" name="profileImageName" id="profileImageName" value="${profileImage.saveName}"/>
          	  	    <button type="button" <c:if test="${sessionScope.member.email == memberVO.email}">onclick="showPopup(this.form);"</c:if> class="btn-image">
          	  	      <img class="bd-placeholder-img profile_img_my_page" 
          	  	        <c:choose>
          	  	          <c:when test="${profileImage == null}">
          	  	            src="/feb/resources/image_source/nothing.jpg"
          	  	          </c:when>
          	  	          <c:when test="${profileImage != null}">
          	  	            src="/feb${profileImage.path}${profileImage.saveName}"
          	  	          </c:when>
          	  	        </c:choose>
          	  	      />
          	  	    </button>
          	  	  </form>
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
		
        
        <div id="post_images" class="container text_div">

		  <c:forEach var="i"  begin="0"  end="${postList.size()-1}" step="1">
		    <div class="inline_block_div">
		      <form id="imageFrm${postList.get(i).getPostNo()}" name="imageFrm${postList.get(i).getPostNo()}" method="get">
		        <input type="hidden" id="postNo${postList.get(i).getPostNo()}" name="postNo${postList.get(i).getPostNo()}" value="" >
		        <button type="button" class="btn-image" style="margin: 4px 1px;" ><img alt="img" onclick="doSelectPost(${postList.get(i).getPostNo()});" class="img-fluid my_page_img" src="/feb${postList.get(i).getThumbNail()}"></button>
		  	  </form>
		  	</div>
		  </c:forEach>  
        
        </div>
 
          
      </div>
    </article>


</div>