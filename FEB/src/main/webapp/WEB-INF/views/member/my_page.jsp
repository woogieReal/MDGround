<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">

<%-- ${vo} --%>

    <article class="my-3" id="card">
      <div class="container basic_div_900 squircle_div">
  		
  		<div id="follow_modal">
  			<table class="table">
  			  <thead>
  			    <tr>
  			      <th scope="col" style="display: none;" width="20%"></th>
  			      <th scope="col" style="display: none;" width="60%"></th>
  			      <th scope="col" style="display: none;" width="20%"></th>
  			    </tr>
  			  </thead>
  			  <tbody id="followTable">
  			  </tbody>
  			</table>
  			<button type="button" class="btn-image modal_close_btn"><span style="font-weight: bold;">X</span></button>
  		</div>
  		
        <div class="card-header">
          
          <table class="member_detail_table_my_page">
          	<tbody>
          	  <tr>
          	  	<td rowspan="3">
          	  	  <form name="image_frm" id="image_frm">
          	  	    <input type="hidden" name="fromTb" id="fromTb" value="2"/>
          	  	    <input type="hidden" name="fromNo" id="fromNo" value="${memberVO.memberNo}"/>
          	  	    <input type="hidden" name="profileImagePath" id="profileImagePath" value="${profileImage.fullPath}"/>
          	  	    <input type="hidden" name="profileImageName" id="profileImageName" value="${profileImage.saveName}"/>
          	  	    
          	  	    <c:if test="${sessionScope.member.email == memberVO.email}">
          	  	      <button type="button" onclick="showPopup(this.form);" class="btn-image">
          	  	    </c:if>  
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
          	  	    <c:if test="${sessionScope.member.email == memberVO.email}">
          	  	      </button>
          	  	    </c:if> 
          	  	  </form>
          	  	</td>
          	  	<td>
          	  	  <h2>${memberVO.email}</h2>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td style="font-size: large;">
          	  	  <button type="button" onclick="doRetrieveFollowing('${memberVO.email}', '${sessionScope.member.email}');" id="followingCountBtn" class="btn-image"><span style="font-weight: bold;">Follow ${followingCount}</span></button>
          	  	  <button type="button" onclick="doRetrieveFollowed('${memberVO.email}', '${sessionScope.member.email}');" id="followedCountBtn"  class="btn-image"><span style="font-weight: bold;">Follower ${followedCount}</span></button>
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

        <div class="bd-example">
        <nav>
          <div class="nav nav-tabs mb-3" id="nav-tab" role="tablist">
            <button class="nav-link active" id="nav-post-tab" data-bs-toggle="tab" data-bs-target="#nav-post" type="button" role="tab" aria-controls="nav-home" aria-selected="true">Post</button>
            <button class="nav-link" id="nav-bookmark-tab" data-bs-toggle="tab" data-bs-target="#nav-bookmark" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">Bookmark</button>
          </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="nav-post" role="tabpanel" aria-labelledby="nav-home-tab">
            <c:if test="${postList.size() > 0}">
			  <c:forEach var="i"  begin="0"  end="${postList.size()-1}" step="1">
			    <div class="inline_block_div" id="my_page_post_div" style="margin: 2px;">
	  			  <div class="col" style="width: 240px;">                                                                                                                                                   
				    <div class="card shadow-sm">                                                                                                                                      
				      <form id="imageFrm${postList.get(i).getPostNo()}" name="imageFrm${postList.get(i).getPostNo()}" method="get">                                                                                                                                                                        
					                                                                                                                                                                 
					     <input type="hidden" id="anyNo${postList.get(i).getPostNo()}" name="anyNo${postList.get(i).getPostNo()}" value="" >                                                                                                                                                              
					     <div id="mainImageDiv${postList.get(i).getPostNo()}">                                                                                                                                                              
					       <button type="button" class="btn-image"><img class="bd-placeholder-img card-img-top thumb_nail_img_small" onclick="doSelectPost(${postList.get(i).getPostNo()});" src="/feb${postList.get(i).getThumbNail()}"></button>                                             
					     </div>                                                                                                                                                              
					                                                                                                                                                                 
				        <div class="card-body">                                                                                                                                         
				          <span style="font-weight: bold;">${postList.get(i).getTitle()}</span>                                                                                                                                                                                                                                                                                                                    
				        </div>                                                                                                                                                          
				      </form>                                                        
				    </div>                                                                                                                                                            
				  </div>		  	  
			  	</div>
			  </c:forEach>
			</c:if>  
          </div>
          <div class="tab-pane fade" id="nav-bookmark" role="tabpanel" aria-labelledby="nav-profile-tab">
            <c:if test="${bookmarkList.size() > 0}">
			  <c:forEach var="i"  begin="0"  end="${bookmarkList.size()-1}" step="1">
			    <div class="inline_block_div" id="my_page_post_div" style="margin: 2px;">
	  			  <div class="col" style="width: 240px;">                                                                                                                                                   
				    <div class="card shadow-sm">                                                                                                                                      
				      <form id="imageFrm${bookmarkList.get(i).getPostNo()}" name="imageFrm${bookmarkList.get(i).getPostNo()}" method="get">                                                                                                                                                                        
					                                                                                                                                                                 
					     <input type="hidden" id="anyNo${bookmarkList.get(i).getPostNo()}" name="anyNo${bookmarkList.get(i).getPostNo()}" value="" >                                                                                                                                                              
					     <div id="mainImageDiv${bookmarkList.get(i).getPostNo()}">                                                                                                                                                              
					       <button type="button" class="btn-image"><img class="bd-placeholder-img card-img-top thumb_nail_img_small" onclick="doSelectPost(${bookmarkList.get(i).getPostNo()});" src="/feb${bookmarkList.get(i).getThumbNail()}"></button>                                             
					     </div>                                                                                                                                                              
					                                                                                                                                                                 
				        <div class="card-body">                                                                                                                                         
				          <span style="font-weight: bold;">${bookmarkList.get(i).getTitle()}</span>                                                                                                                                                                                                                                                                                                                    
				        </div>                                                                                                                                                          
				      </form>                                                        
				    </div>                                                                                                                                                            
				  </div>		  	  
			  	</div>
			  </c:forEach>
			</c:if>  
          </div>
        </div>
        </div>

        
        
        </div>
 
          
      </div>
    </article>


</div>