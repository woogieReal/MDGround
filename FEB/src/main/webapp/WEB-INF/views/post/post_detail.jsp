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
		  <c:if test="${imageList.size() > 0}">
		    <c:forEach var="i"  begin="0"  end="${imageList.size()-1}" step="1">
		      <img alt="img" class="img-fluid squircle_img" src="/feb${imageList.get(i).getPath()}${imageList.get(i).getSaveName()}">
		    </c:forEach>		  		
  		  </c:if> 
        </div>
        
        <div class="container text_div" id="post_text">
		  ${vo.textHtml}
        </div>
        
		<table class="member_simple_table_post_detail">
			<tbody>
			  <tr>
			    <td rowspan="2">
			      <form id="headerProfileImageFrm" name="headerProfileImageFrm">
			        <input type="hidden" id="tmpEmail" name="tmpEmail" value="">
			        <button type="button" onclick="doClickProfileImage('${vo.memberEmail}');" class="btn-image" >
			          <img class="profile_img_header" src="/feb${profileImage.path}${profileImage.saveName}">
			        </button>
			      </form>
			    </td>
			  	<td>
			  	  ${vo.memberEmail}
			  	</td>
			  	<td rowspan="2">
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
			          <div class="inline_block_div" id="my_page_icon_follow">
		          	    <c:choose>
		           	  	  <c:when test="${followFlag == 0}">
		          	  	    <button type="button" class="btn-image" onclick="doFollow('${vo.memberEmail}', '${sessionScope.member.email}');" style="margin: -5px 0px 0px 15px;" ><i class="bi bi-person-plus i_icon"></i></button>
		            	  </c:when>
		          	  	</c:choose>
		          	  	<c:choose>
		          	  	  <c:when test="${followFlag == 1}">
		          	  	    <button type="button" class="btn-image" onclick="doCancelFollow('${vo.memberEmail}', '${sessionScope.member.email}');" style="margin: -5px 0px 0px 15px;" ><i class="bi bi-person-plus-fill i_icon"></i></button>
		          	  	  </c:when>
		          	  	</c:choose>	          
			          </div>
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
			  	</td>
			  </tr>
			  <tr>
			  	<td>
			  	  ${vo.regDt}
			  	</td>
			  </tr>
			</tbody>
		</table>
        
		<table class="table replyTable" style="width: 95%;">
	   	  <thead>
		  	<tr>
		  	  <th scope="col" width="10%"></th>
		  	  <th scope="col" width="70%"></th>
		  	  <th scope="col" width="20%"></th>
		  	</tr>
		  	<c:if test="${sessionScope.member != null}">
		  	  <tr>
		  	    <td colspan="2">
		  	      <input type="hidden" id="postNoInReply" value="${vo.postNo}">
		  	      <input type="hidden" id="emailInReply" value="${sessionScope.member.email}">
		  	      <input type="text" id="replyText" class="form-control">
		  	    </td>
		  	    <td>
		  	      <button type="submit" onclick="doInsertReply();" class="btn btn-primary">Post comment</button>
		  	    </td>
		  	  </tr>
		  	</c:if>
		  	<tr><td></td><td></td><td></td></tr>
		  </thead>
		  <tbody id="replyTable">
		  </tbody>
		</table>
        
        
       
          
      </div>
    </article>

</div>
<script type="text/javascript">
	$(document).ready(function() {
		//console.log("post_detail");
		doRetrieveReply(${vo.postNo});
	});
</script>