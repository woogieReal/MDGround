/**
 * main.js
 *
 * doRetrievePost(searchDiv, searchWord, loginMemberEamil): main.jsp 에 모든 게시물을 출력 
 *   doSelectProfileImageEachPost(email, no): 모든 게시물에 작성자의 프로필 이미지를 출력
 *   doSelectMainImage(no, category): 모든 게시물에 게시물의 썸네일을 출력
 *   doCheckStore(type, email, no): 로그인한 유저가 각 게시물에 대하여 북마크/좋아요를 했는지에 대한 체크와 출력
 * 
 * doSelectPost(no): 각 게시물을 클릭하면 post_detail.jsp 로 이동
 * doSelectMember(no, email): 각 게시물의 작성자의 프로필 이미지를 클릭하면 my_page.jsp 로 이동
 * 
 * doSelectProfileImage(email): header.jsp 에 로그인한 유저의 프로필 이미지를 출력
 * doClickProfileImage(email): header.jsp 에 있는 로그인 유저의 프로필 이미지를 클릭하여 my_page.jsp 로 이동
 * 
 * 
 * 
 */
 
 
function doRetrievePost(searchDiv, searchWord, loginMemberEamil) {
	//console.log("doMovePost()");
	console.log("loginMemberEamil: "+loginMemberEamil);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_retrieve.do",
  		asyn:false,
  		dataType:"html",
  		data:{
  			searchDiv: searchDiv,
  			searchWord: searchWord
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
			console.log(parseData);
			
			document.getElementById("mainPostsDiv").value = "";
			
			var html = "";
			
			$.each(parseData, function(i, value) {
				
				var imagePath = value.thumbNail;
				if(imagePath == undefined || imagePath == ""){
					imagePath = "/resources/image_source/javascript.png";
				}
				//console.log("imagePath: "+imagePath);
				
				html += "    <div class='col'>                                                                                                                                                   ";
				html += "      <div class='card shadow-sm'>                                                                                                                                      ";
				html += "        <form id='imageFrm"+ value.postNo +"' name='imageFrm"+ value.postNo +"' method='get'>         ";
				html += "		   <div class='card-header'>                                                                                                                                                                ";
				html += "		     <div class='inline_block_div' id='postProfileImageDiv"+ value.postNo +"' name='postProfileImageDiv"+ value.postNo +"' ></div>                                                                                                                                                            ";
				html += "		     <button type='button' onclick='doSelectMember("+ value.postNo +", \""+ value.memberEmail +"\");' class='btn-image'><span style='font-weight: bold;'>"+ value.memberEmail +"</span></button>                                                                                                                                                                ";
				html += "		   </div>                                                                                                                                                                ";
				html += "		                                                                                                                                                                 ";
				html += "		   <input type='hidden' id='anyNo"+ value.postNo +"' name='anyNo"+ value.postNo +"' value='' >                                                                                                                                                              ";
				html += "		   <div id='mainImageDiv"+ value.postNo +"'>                                                                                                                                                              ";
				//html += "		     <button type='button' class='btn-image'><img class='bd-placeholder-img card-img-top thumb_nail_img' onclick='doSelectPost("+ value.postNo +");' src='/feb"+ imagePath +"'></button>                                             ";
				html += "		   </div>                                                                                                                                                              ";
				html += "		                                                                                                                                                                 ";
				html += "          <div class='card-body'>                                                                                                                                         ";
				html += "            <span style='font-weight: bold;'>"+ value.title +"</span>     ";
				html += "            <div class='d-flex justify-content-between align-items-center'>                                                                                               ";
				html += "              <small class='text-muted'>"+ value.category +"</small><br>                                                                                                                     ";
				html += "            </div>                                                                                                                                                        ";
				html += "            <small class='text-muted'>"+ value.regDt +"</small><br>                                                                                                                     ";
				html += "		     <div class='i_icon_div_main'>                                                                                                                                                          ";
				html += "		       <div class='inline_block_div' id='post_icon_bookmark"+ value.postNo +"'></div>                                                                                                                                                          ";
				html += "		       <div class='inline_block_div' id='post_icon_heart"+ value.postNo +"'></div>                                                                                                                                                          ";
				html += "            </div>                                                                                                                                                        ";
				html += "          </div>                                                                                                                                                          ";
				html += "        </form>                                                        ";
				html += "      </div>                                                                                                                                                            ";
				html += "    </div>                                                                                                                                                              ";

				doSelectMainImage(value.postNo, value.category);
				
				if(value.memberEmail != loginMemberEamil && loginMemberEamil != ""){
					doCheckStore(1, loginMemberEamil, value.postNo);
					doCheckStore(2, loginMemberEamil, value.postNo);
				}
				
				doSelectProfileImageEachPost(value.memberEmail, value.postNo);
				
			});
			
			//console.log(html);
			
			document.getElementById("mainPostsDiv").innerHTML = html;
			
			if(loginMemberEamil != ""){
				doSelectProfileImage(loginMemberEamil);		
			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
}

function doSelectProfileImageEachPost(email, no) {

	$.ajax({
  		type: "POST",
  		url:"/feb/image/do_select_profile_image.do",
  		asyn:true,
  		dataType:"html",
  		data:{
  			email: email
  		},
  		success:function(data){//통신 성공
  			
  			let srcValue = "";
  			var parseData = JSON.parse(data);
  			
  			if(parseData != null){
  				srcValue = parseData.path + parseData.saveName;
  			} else if(parseData == null){
  				srcValue = "/resources/image_source/nothing.jpg";
  			}
  			
  			//console.log("srcValue: "+srcValue);
  			
			document.getElementById("postProfileImageDiv"+no+"").innerHTML = "  <button type='button' style='margin: 0px;' onclick='doClickProfileImage(\""+ email +"\");' class='btn-image'><img class='profile_img_header' src='/feb/"+ srcValue +"'></button>";
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function doSelectMainImage(no, category) {
	//console.log("doSelectMainImage("+ no +")");
	//console.log(category);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/image/do_select_main_image.do",
  		asyn:false,
  		dataType:"html",
  		data:{
  			postNo: no
  		},
  		success:function(data){//통신 성공
  			
  			let srcValue = "";
  			var parseData = JSON.parse(data);
  			
  			if(parseData != null){
  				srcValue = parseData.path + parseData.saveName;
  			} else if(parseData == null){
  				switch(category){
  					case "daily life": srcValue="/resources/image_source/markdown.png";   break;
  					case "java":       srcValue="/resources/image_source/java.png";       break;
  					case "javascript": srcValue="/resources/image_source/javascript.png"; break;
  				}
  			}
  			
  			//console.log("srcValue: "+srcValue);
  			
			document.getElementById("mainImageDiv"+no+"").innerHTML = "<button type='button' class='btn-image'><img class='bd-placeholder-img card-img-top thumb_nail_img' onclick='doSelectPost("+ no +");' src='/feb"+ srcValue +"'></button>";
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
  		
}

function doCheckStore(type, email, no) {

	$.ajax({
  		type: "POST",
  		url:"/feb/storage/do_check_store.do",
  		asyn:false,
  		dataType:"html",
  		data:{
  			storeType: type,
  			memberEmail: email,
  			postNo: no
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);

			if(parseData.msgId == 1 && type == 1){
				document.getElementById("post_icon_bookmark"+no).innerHTML = "<button type='button' onclick='doCancelStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-bookmark-fill i_icon'></i></button>";
			} else if(parseData.msgId == 0 && type == 1) {
				document.getElementById("post_icon_bookmark"+no).innerHTML = "<button type='button' onclick='doStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-bookmark i_icon'></i></button>";
			} else if(parseData.msgId == 1 && type == 2) {
				document.getElementById("post_icon_heart"+no).innerHTML = "<button type='button' onclick='doCancelStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-heart-fill i_icon'></i></button>";
			} else if(parseData.msgId == 0 && type == 2) {
				document.getElementById("post_icon_heart"+no).innerHTML = "<button type='button' onclick='doStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-heart i_icon'></i></button>";
			}		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  	
}

function doSelectPost(no) {
	//console.log("doSelectPost("+ no +")");
	
	var frm = document.getElementById("imageFrm"+no+"");
	frm.action = "/feb/post/do_select_post.do";
	
	document.getElementById("anyNo"+no+"").setAttribute("name", "postNo");
	document.getElementById("anyNo"+no+"").setAttribute("id", "postNo");
	document.getElementById("postNo").value = no;
	
	//console.log("postNo: "+document.getElementById("postNo").value);
	frm.submit();
}

function doSelectMember(no, email) {
	//console.log("no: "+no);
	//console.log("email: "+email);
	
	var frm = document.getElementById("imageFrm"+no+"");
	frm.action = "/feb/member/do_select_one.do";
	
	document.getElementById("anyNo"+no+"").setAttribute("name", "email");
	document.getElementById("anyNo"+no+"").setAttribute("id", "email");
	document.getElementById("email").value = email;	
	
	//console.log("email: "+document.getElementById("email").value);
	frm.submit();	
}

function doSelectProfileImage(email) {

	$.ajax({
  		type: "POST",
  		url:"/feb/image/do_select_profile_image.do",
  		asyn:true,
  		dataType:"html",
  		data:{
  			email: email
  		},
  		success:function(data){//통신 성공
  			
  			let srcValue = "";
  			var parseData = JSON.parse(data);
  			
  			if(parseData != null){
  				srcValue = parseData.path + parseData.saveName;
  			} else if(parseData == null){
  				srcValue = "/resources/image_source/nothing.jpg";
  			}
  			
  			//console.log("srcValue: "+srcValue);
  			
  			let html = "";
  			html += "<form id='headerProfileImageFrm' name='headerProfileImageFrm'>";
  			html += "  <input type='hidden' id='tmpEmail' name='tmpEmail' value='' >";
  			html += "  <button type='button' onclick='doClickProfileImage(\""+ email +"\");' class='btn-image'><img class='profile_img_header' src='/feb/"+ srcValue +"'></button>";
  			html += "</form>";
  			
  			//console.log(html);
  			
			document.getElementById("headerProfileImageDiv").innerHTML = html;
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function doClickProfileImage(email) {
	console.log("doClickProfileImage()");
	
	var frm = document.getElementById("headerProfileImageFrm");
	frm.action = "/feb/member/do_select_one.do";
	
	document.getElementById("tmpEmail").setAttribute("name", "email");
	document.getElementById("tmpEmail").setAttribute("id", "email");
	document.getElementById("email").value = email;	
	
	frm.submit();	
	
}

