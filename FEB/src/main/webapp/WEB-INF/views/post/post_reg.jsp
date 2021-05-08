<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core태그 -->
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="eachPart">
  <div class="container01">  
	<div class="container">
	  <main>
	    <div class="py-5 text-center">
	      <h2>Post</h2><br/>
	      <p class="lead"><c:out value="${sessionScope.member.name}"></c:out></p>
	    </div>
	
	    <div class="row g-5">
	
	      <!-- 이미지 등록 칸으로 만들 곳 -->
	      <div class="col-md-5 col-lg-4 order-md-last">
	
	        <form name="image_frm" id="image_frm">
	        
	          <input type="hidden" name="fromTb" id="fromTb" value="1"/>
				
	          <h4 class="d-flex justify-content-between align-items-center mb-3">
	            <span class="text-primary">Images</span>
	            
	            <!-- 등록한 이미지가 몇 개인지 보여 줄 칸 -->
	            <div id="imageCntView"></div>
	            
	            <button type="button" class="btn btn-outline-primary me-2" onclick="showPopup(this.form);">add</button>
	          
	          </h4>
				
			  <!-- 업로드한 이미지 목록 출력 -->	
	          <div id="uploadImageView" name="uploadImageView">
	          </div>
	
					
			  		
	
	        </form>
	      </div>
	      <!--// 이미지 등록 칸으로 만들 곳 -->
	
	      <div class="col-md-7 col-lg-8">
	        <form class="needs-validation" name="post_frm" id="post_frm" novalidate>
	          <div class="row g-3">

				<input type="hidden" name="memberEmail" id="memberEmail" value="${sessionScope.member.email}"/>
				<input type="hidden" name="imageList" id="imageList" value=""/>
				<input type="hidden" name="whichMainImage" id="whichMainImage" value="0"/>
	
	            <div class="col-12">
	              <label for="title" class="form-label">Title<span class="text-muted"></span></label>
	              <input type="text" class="form-control" name="title" id="title" placeholder="Please enter the title" required>
	            </div>

	            <div class="col-12">
	              <label for="category" class="form-label">Category</label>
	              <select class="form-select form-select-lg mb-3" id="category" style="font-size: medium;" aria-label=".form-select-lg example">
				  	<option value="daily life" selected="selected">daily life</option>          
				  	<option value="javascript">javascript</option>                 
	              </select>
	            </div>
	
	            <div class="col-12">
	              <label for="text" class="form-label">Text</label><input type="button" onclick="doConvert();" class="btn btn-primary btn-sm btn-right" value="Convert" id="convertBtn" />
	              <textarea class="form-control" id="text" onkeyup="ctrEnterkey();" rows="10" placeholder="The text you entered appears at the bottom of the post." required></textarea>
	            </div>

	            <div class="col-12">
	              <label for="Preview" class="form-label">Preview</label>
	              <div class="squircle_div text_div" id="Preview"></div>
	            </div>
	            
	          </div>
	
	          <hr class="my-4">
	
	        </form>
	          <button class="w-100 btn btn-primary btn-lg" onclick="post();" name="register_button" id="register_button" type="submit">Post</button>
	      </div>
	    </div>
	  </main>
	</div>
  <br/><br/><br/>
  </div>
</div>