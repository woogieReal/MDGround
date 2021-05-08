<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">

<%-- ${vo} --%>

    <article class="my-3" id="card">
      <div class="container basic_div squircle_div">
  		
        <div class="card-header">
          <span style="font-weight: bold;" id="post_title">${vo.title}</span>
          <div class="right_div" id="post_category">
          	${vo.category}
          </div>
        </div>		
		
		<div id="post_images">
		
		  <c:forEach var="i"  begin="0"  end="${imageList.size()-1}" step="1">
		    <img alt="img" class="img-fluid squircle_img" src="/feb${imageList.get(i).getPath()}${imageList.get(i).getSaveName()}">
		  </c:forEach>		  		
  		  
        </div>
        
        <div class="container text_div" id="post_text">
			${vo.textHtml}
        </div>
        
        <c:choose>
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
        </c:choose>
        
        
          
      </div>
    </article>


</div>