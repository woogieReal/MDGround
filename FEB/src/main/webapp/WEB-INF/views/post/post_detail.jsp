<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">

<div class="bd-cheatsheet container-fluid bg-body">
<section id="components">
<article class="my-3" id="card">
<div>
<div class="bd-example">
<div class="row row-cols-1 row-cols-md-1 row-cols-lg-2  g-4">
<div class="col" style="margin: auto;">
<div class="card">
    
  		
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
		    <thead>
		      <tr>
		        <th scope="col" width="10%"></th>
		        <th scope="col" width="60%"></th>
		        <th scope="col" width="30%"></th>
		      </tr>
		    </thead>
			<tbody>
			  <tr>
			    <td rowspan="2">
			      <form id="imageFrm${vo.postNo}" name="imageFrm${vo.postNo}">
			        <input type="hidden" id="anyNo${vo.postNo}" name="anyNo${vo.postNo}" value="">
			        <button type="button" style="margin: 0px 10px;" onclick="doSelectMember(${vo.postNo},'${vo.memberEmail}');" class="btn-image" >
			          <img class="profile_img_header" src="/feb${profileImage.path}${profileImage.saveName}">
			        </button>
			      </form>
			    </td>
			  	<td>
			  	  ${vo.memberEmail}
			  	</td>
			  </tr>
			  <tr>
			  	<td>
			  	  ${vo.regDt}
			  	</td>
			  </tr>
			</tbody>
		</table>
		
		       <c:choose>
		         <c:when test="${sessionScope.member.email == vo.memberEmail}">
					<div class='container i_icon_div'>
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
		          	  	    <button type="button" class="btn-image" onclick="doFollow('${vo.memberEmail}', '${sessionScope.member.email}');" ><i class="bi bi-person-plus i_icon"></i></button>
		            	  </c:when>
		          	  	</c:choose>
		          	  	<c:choose>
		          	  	  <c:when test="${followFlag == 1}">
		          	  	    <button type="button" class="btn-image" onclick="doCancelFollow('${vo.memberEmail}', '${sessionScope.member.email}');"><i class="bi bi-person-plus-fill i_icon"></i></button>
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
				            <button type="button" onclick="doCancelStore(2, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image" style="margin: 0px;"><i class="bi bi-heart-fill i_icon"></i></button>
				          </c:when>
				          <c:when test="${likeFlag == 0}">
				            <button type="button" onclick="doStore(2, '${sessionScope.member.email}', ${vo.postNo});" class="btn-image" style="margin: 0px;"><i class="bi bi-heart i_icon"></i></button>
				          </c:when>
				        </c:choose>
				      </div>
			        </div>
		          </c:when>
		          <c:when test="${sessionScope.member == null}">
		          </c:when>
		        </c:choose>		
        
		<table class="table replyTable" style="width: 95%;">
	   	  <thead>
		  	<tr>
		  	  <th scope="col" width="10%"></th>
		  	  <th scope="col" width="65%"></th>
		  	  <th scope="col" width="20%"></th>
		  	</tr>
		  	<c:if test="${sessionScope.member != null}">
		  	  <tr>
		  	    <td colspan="2">
		  	      <input type="hidden" id="postNoInReply" value="${vo.postNo}">
		  	      <input type="hidden" id="emailInReply" value="${sessionScope.member.email}">
		  	      <input type="text"   id="replyText" onkeyup="doInsertReplyByEnter();" class="form-control">
		  	    </td>
		  	    <td>
		  	      <button type="submit" onclick="doInsertReply();" class="btn btn-primary">Click</button>
		  	    </td>
		  	  </tr>
		  	</c:if>
		  	<tr><td></td><td></td><td></td></tr>
		  </thead>
		  <tbody id="replyTable">
		  </tbody>
		</table>
        
        
       
          
      
    
</div>
</div>
</div>
</div>  
</div>            
</article>
</section>
</div>




</div>
<script type="text/javascript">
	$(document).ready(function() {
		//console.log("post_detail");
		doRetrieveReply(${vo.postNo},'${sessionScope.member.email}');
	});
</script>