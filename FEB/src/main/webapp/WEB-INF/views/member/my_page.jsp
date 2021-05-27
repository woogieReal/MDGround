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
<div class="row row-cols-sm-1 row-cols-md-1 row-cols-lg-2  g-4">
<div class="col" style="margin: auto;">
<div class="card">
  		
  		
  		
        <div class="card-header">
        
  		<div id="follow_modal" class="container my_modal">
  			<input type="button" class="btn btn-danger btn-sm btn-right modal_close_btn margin_5px_btn" value="Close"/>
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
  		</div>
  		
  		<div id="intro_modal" class="container my_modal">
  		  <input type="button" class="btn btn-sm btn-danger btn-right modal_close_btn margin_5px_btn" value="Close"/>
  		  <c:if test="${sessionScope.member.email == memberVO.email}">
  		    <input type="button" class="btn btn-primary btn-sm btn-right modal_close_btn margin_5px_btn" value="Edit" id="showIntroEditBtn" />
  		  </c:if>
  		  ${memberVO.introHtml }
  		</div>
  		
  		<div id="intro_edit_modal" class="container my_modal">
  		  <input type="button" class="btn btn-sm btn-danger btn-right modal_close_btn margin_5px_btn" value="Close"/>
  		  <input type="button" onclick="doConvert();" class="btn btn-primary btn-sm btn-right margin_5px_btn" value="Convert" id="convertBtn" />
  		  <input type="button" onclick="doEditIntro();" class="btn btn-primary btn-sm btn-right margin_5px_btn" value="Complete" id="introEditBtn" />
  		  <div class="mb-3">
  		  	<label for="text" class="form-label">Text</label>
  		  	<textarea class="form-control" id="text" onkeyup="if(event.keyCode == 13 && window.event.ctrlKey) javascript:enterKey('convert');" rows="5" placeholder="The text you entered appears at the bottom of the post." required>${memberVO.introMd }</textarea>
  		  </div>
  		  <div class="mb-3">
  		  	<label for="Preview" class="form-label">Preview</label>
  		  	<div class="squircle_div text_div" id="Preview"></div>
  		  </div>
  		  <button class="btn-image" id="register_button"></button>  		  
  		</div>
  		
  		<div id="profile_edit_modal" class="container my_modal">
  		  <input type="button" class="btn btn-sm btn-danger btn-right modal_close_btn margin_5px_btn" value="Close" />
  		  <input type="button" onclick="doEditProfile();" class="btn btn-primary btn-sm btn-right margin_5px_btn" value="Complete" id="profileEditBtn" />
 		  
 		  <input type="hidden" id="profileEmail" value="${memberVO.email}">
 		  
 		  <div class="mb-3">
 		    <label for="newName" class="form-label">Name</label>
 		    <input type="text" class="form-control" id="newName" value="${memberVO.name}">
 		  </div>
          <div class="mb-3">
            <label for="nowPw" class="form-label">Password</label>
 		  	<input type="password" class="form-control" id="nowPw" value="">
 		  </div>
 		  <div class="mb-3">
 		  	<label for="newPw" class="form-label">New Password</label>
 		  	<input type="password" class="form-control" id="newPw" value="">
 		  </div>
 		  <div class="mb-3">
 		  	<label for="newPwCheck" class="form-label">Confirm Password</label>
 		  	<input type="password" class="form-control" id="newPwCheck" value="">
 		  </div>
  		</div>

	      <div id="file_upload_modal" class="container my_modal">
	        <input type="button" id="file_upload_modal_close_btn" class="btn btn-sm btn-danger btn-right modal_close_btn margin_5px_btn" value="Close"/>
	        <input type="button" onclick="doUploadProfileImage();" id="file_upload" class="btn btn-primary btn-sm btn-right margin_5px_btn" value="Upload" />
	        
	        <h3>Profile Image Upload</h3>
	        <hr/>
	        
	        <form id="uploadFrm" id="uploadFrm" method="post" enctype="multipart/form-data" accept-charset="UTF-8" >
	          <div class="container">
	            <input type="file" class="form-control" name="file_list" id="file_list"/>
	          </div>
	        </form>
	      </div>
  		
          <table class="member_detail_table_my_page">
          	<tbody>
          	  <tr>
          	  	<td rowspan="3"><!-- 프로필 이미지 -->
          	  	  <form name="image_frm" id="image_frm">
          	  	    <input type="hidden" name="fromTb" id="fromTb" value="2"/>
          	  	    <input type="hidden" name="fromNo" id="fromNo" value="${memberVO.memberNo}"/>
          	  	    <input type="hidden" name="profileImagePath" id="profileImagePath" value="${profileImage.fullPath}"/>
          	  	    <input type="hidden" name="profileImageName" id="profileImageName" value="${profileImage.saveName}"/>
          	  	    
          	  	    <c:if test="${sessionScope.member.email == memberVO.email}">
          	  	      <button type="button" id="fileUploadShowBtn" class="btn-image">
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
          	  	<td><!-- 이메일 -->
          	  	  <span style="font-weight: bold; margin-left: 3px;">${memberVO.email}</span>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td style="font-size: large;"><!-- 팔로우, 팔로워 -->
          	  	  <button type="button" onclick="doRetrieveFollowing('${memberVO.email}', '${sessionScope.member.email}');" id="followingCountBtn" class="btn-image"><span style="font-weight: bold;">Follow ${followingCount}</span></button>
          	  	  <button type="button" onclick="doRetrieveFollowed('${memberVO.email}', '${sessionScope.member.email}');" id="followedCountBtn"  class="btn-image"><span style="font-weight: bold;">Follower ${followedCount}</span></button>
          	  	</td>
          	  </tr>
          	  <tr>
          	  	<td><!-- 이름 -->
          	  	  <button type="button" id="introShowBtn" class="btn-image"><span style="vertical-align: super;">${memberVO.name}</span></button>
          	  	  <c:choose>
          	  	    <c:when test="${sessionScope.member.email == memberVO.email}">
          	  	      <div class="inline_block_div">
          	  	        <form id="editFrm">
          	  	          <button type="button" id="editShowBtn" style="padding: 2px 10px; margin: -10px 0px 0px 10px;" class="btn btn-outline-primary">Edit</button>
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
			  <div class="row row-cols-1 row-cols-sm-1 row-cols-md-3 row-cols-lg-3" style="margin: 2px;">
			    <c:forEach var="i"  begin="0"  end="${postList.size()-1}" step="1">
	  			  
	  			  <div class="col" style="padding: 3px;">                                                                                                                                                   
				    <div class="card">                                                                                                                                      
				      <form id="imageFrm${postList.get(i).getPostNo()}" name="imageFrm${postList.get(i).getPostNo()}" method="get">                                                                                                                                                                        
					     <input type="hidden" id="anyNo${postList.get(i).getPostNo()}" name="anyNo${postList.get(i).getPostNo()}" value="" >                                                                                                                                                              
					     <div class="thumb_nail_div_small" id="mainImageDiv${postList.get(i).getPostNo()}">                                                                                                                                                              
					       <button type="button" class="btn-image"><img class="bd-placeholder-img card-img-top thumb_nail_img_small" onclick="doSelectPost(${postList.get(i).getPostNo()});" src="/feb${postList.get(i).getThumbNail()}"></button>                                             
					     </div>                                                                                                                                                              
				        <div class="card-body">                                                                                                                                         
				          <span style="">${postList.get(i).getTitle()}</span>                                                                                                                                                                                                                                                                                                                    
				        </div>                                                                                                                                                          
				      </form>                                                        
				    </div>                                                                                                                                                            
				  </div>
				  
			    </c:forEach>
			  </div>
			</c:if>  
          </div>
          <div class="tab-pane fade" id="nav-bookmark" role="tabpanel" aria-labelledby="nav-profile-tab">
            <c:if test="${bookmarkList.size() > 0}">
			  <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-3" style="margin: 2px;">
			    <c:forEach var="i"  begin="0"  end="${bookmarkList.size()-1}" step="1">
	  			  <div class="col">                                                                                                                                                   
				    <div class="card">                                                                                                                                      
				      <form id="imageFrm${bookmarkList.get(i).getPostNo()}" name="imageFrm${bookmarkList.get(i).getPostNo()}" method="get">                                                                                                                                                                        
					     <input type="hidden" id="anyNo${bookmarkList.get(i).getPostNo()}" name="anyNo${bookmarkList.get(i).getPostNo()}" value="" >                                                                                                                                                              
					     <div class="thumb_nail_div_small" id="mainImageDiv${bookmarkList.get(i).getPostNo()}">                                                                                                                                                              
					       <button type="button" class="btn-image"><img class="bd-placeholder-img card-img-top thumb_nail_img_small" onclick="doSelectPost(${bookmarkList.get(i).getPostNo()});" src="/feb${bookmarkList.get(i).getThumbNail()}"></button>                                             
					     </div>                                                                                                                                                              
				        <div class="card-body">                                                                                                                                         
				          <span style="">${bookmarkList.get(i).getTitle()}</span>                                                                                                                                                                                                                                                                                                                    
				        </div>                                                                                                                                                          
				      </form>                                                        
				    </div>                                                                                                                                                            
				  </div>		  	  
			    </c:forEach>
			  </div>
			</c:if>  
          </div>
        </div>
        </div>

        
        
        </div>
 
          
</div>
</div>
</div>
</div>  
</div>            
</article>
</section>
</div>


</div>