/**
 * member.js
 */
 
function doUploadProfileImage() {
	console.log("doUploadProfileImage()");
	
    var form = new FormData(document.getElementById("uploadFrm"));
	
	var profileImagePath = document.getElementById("profileImagePath").value;
	var profileImageName = document.getElementById("profileImageName").value;
	
	if(profileImagePath == "") profileImagePath = "nothingPath";
	if(profileImageName == "") profileImageName = "nothingName";
	
	//console.log("profileImagePath: "+profileImagePath);
	//console.log("profileImageName: "+profileImageName);

	$.ajax({
  		type: "POST",
  		url:"/feb/image/do_delete_profile_image.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			profileImagePath: profileImagePath,
  			profileImageName: profileImageName
  		},
  		success:function(data){//통신 성공
  			
		    $.ajax({
		        url: "/feb/image/do_upload_profile_image.do",
		        enctype: 'multipart/form-data',
		        data: form, 
		        //dataType: 'text',
		        type: 'POST',
		        async: 'false',
		        processData: false,
		        contentType: false,
		        success: function(data) {
		    	
		    	  //console.log("data: " + data);
				  alert("이미지 등록이 완료되었습니다.");
				  
		          window.self.close();
		
		        },
		        error: function(data) {
		          console.log('error'+data);
		        }
		    });	
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

window.onload = function(){
	
	document.getElementById('followingCountBtn').addEventListener('click', function() {
	    modal('follow_modal');
	});
	
	document.getElementById('followedCountBtn').addEventListener('click', function() {
	    modal('follow_modal');
	});
	
	function modal(id) {
	    var zIndex = 9999;
	    var modal = document.getElementById(id);
	
	    // 모달 div 뒤에 시꺼먼 레이어
	    var bg = document.createElement("div");
	    bg.setStyle({
	        position: 'fixed',
	        zIndex: zIndex,
	        left: '0px',
	        top: '0px',
	        width: '100%',
	        height: '100%',
	        overflow: 'auto',
	        backgroundColor: 'rgba(255,255,255,0.4)'
	    });
	    document.body.append(bg);
	
	    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
	    modal.querySelector('.modal_close_btn').addEventListener('click', function() {
	        bg.remove();
	        modal.style.display = 'none';
	    });
	
	    modal.setStyle({
	        position: 'fixed',
	        display: 'block',
	        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
	
	        // 시꺼먼 레이어 보다 한칸 위에 보이기
	        zIndex: zIndex + 1,
	
	        // div center 정렬
	        top: '50%',
	        left: '50%',
	        transform: 'translate(-50%, -50%)',
	        msTransform: 'translate(-50%, -50%)',
	        webkitTransform: 'translate(-50%, -50%)'
	    });
	}
	
	Element.prototype.setStyle = function(styles) {
	    for (var k in styles)
	        this.style[k] = styles[k];
	    return this;
	};

}

function doRetrieveFollowing(email, loginMemberEamil){
	console.log("doRetrieveFollowing()");
	
	$.ajax({
  		type: "POST",
  		url:"/feb/follow/do_retrieve_following.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			email: email
  		},
  		success:function(data){//통신 성공
  			
			var parseData = JSON.parse(data);
			var html = "";
			
			$.each(parseData, function(i, value) {
				
				console.log(value.followingEmail);
				
				html += " <tr> ";
				html += "   <td id='followProfileImageTd"+ i +"'></td>  ";
				html += "   <td>"+ value.followingEmail +"</td>  ";
				html += "   <td id='followCheckTd"+ i +"'></td>  ";
				html += " </tr> ";
				
	  			doSelectProfileImageEachFollow(value.followingEmail, i);
				
				if(value.followingEmail != loginMemberEamil && loginMemberEamil != ""){
					doCheckFollowingWithLoginMember(value.followingEmail, loginMemberEamil, i);
				}
				
				
			});
			
			document.getElementById("followTable").innerHTML = html;			
  			
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
	
}

function doRetrieveFollowed(email, loginMemberEamil){
	console.log("doRetrieveFollowed()");
	console.log("email: "+email);
	console.log("loginMemberEamil: "+loginMemberEamil);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/follow/do_retrieve_followed.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			email: email
  		},
  		success:function(data){//통신 성공
  			
			var parseData = JSON.parse(data);
			var html = "";
			console.log("parseData: "+parseData);
			
			$.each(parseData, function(i, value) {
				
				console.log(value.followedEmail);
				
				html += " <tr> ";
				html += "   <td id='followProfileImageTd"+ i +"'></td>  ";
				html += "   <td>"+ value.followedEmail +"</td>  ";
				html += "   <td id='followCheckTd"+ i +"'></td>  ";
				html += " </tr> ";
				
	  			doSelectProfileImageEachFollow(value.followedEmail, i);
				
				if(value.followedEmail != loginMemberEamil && loginMemberEamil != ""){
					doCheckFollowingWithLoginMember(value.followedEmail, loginMemberEamil, i);
				}				
				
			});
			
			document.getElementById("followTable").innerHTML = html;			
  			
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  		
}


function doSelectProfileImageEachFollow(email, no) {

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
  			
			document.getElementById("followProfileImageTd"+no+"").innerHTML = "  <button type='button' style='margin: 0px;' onclick='doClickProfileImage(\""+ email +"\");' class='btn-image'><img class='profile_img_header' src='/feb/"+ srcValue +"'></button>";
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function doCheckFollowingWithLoginMember(followingEmail, followedEmail, no) {

	$.ajax({
  		type: "POST",
  		url:"/feb/follow/do_check_following.do",
  		asyn:true,
  		dataType:"html",
  		data:{
  			followingEmail: followingEmail,
  			followedEmail: followedEmail
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			
  			if(parseData.msgId == 1){
  				document.getElementById("followCheckTd"+no+"").innerHTML = "<button type='button' class='btn-image' onclick='doCancelFollowInFollowModal(\""+ followingEmail +"\" , \""+ followedEmail +"\" , "+ no +");'><i class='bi bi-person-plus-fill i_icon'></i></button>";
  			} else {
  				document.getElementById("followCheckTd"+no+"").innerHTML = "<button type='button' class='btn-image' onclick='doFollowInFollowModal(\""+ followingEmail +"\" , \""+ followedEmail +"\" , "+ no +");'><i class='bi bi-person-plus i_icon'></i></button>";
  			}
  			
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function doCancelFollowInFollowModal(followingEmail, followedEmail, no) {
	console.log("doCancelFollow");
	//console.log("followingEmail: "+followingEmail);
	//console.log("followedEmail: "+followedEmail);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/follow/do_cancel_follow.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			followingEmail: followingEmail,
  			followedEmail: followedEmail
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			if(parseData.msgId == 1){
	  			document.getElementById("followCheckTd"+no+"").innerHTML = "<button type='button' class='btn-image' onclick='doFollowInFollowModal(\""+ followingEmail +"\" , \""+ followedEmail +"\" , "+ no +");'><i class='bi bi-person-plus i_icon'></i></button>";
  			} else {
	  			alert(parseData.msgContents);
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  		
}

function doFollowInFollowModal(followingEmail, followedEmail, no) {
	console.log("doFollow");
	//console.log("followingEmail: "+followingEmail);
	//console.log("followedEmail: "+followedEmail);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/follow/do_follow.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			followingEmail: followingEmail,
  			followedEmail: followedEmail
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			if(parseData.msgId == 1){
	  			document.getElementById("followCheckTd"+no+"").innerHTML = "<button type='button' class='btn-image' onclick='doCancelFollowInFollowModal(\""+ followingEmail +"\" , \""+ followedEmail +"\" , "+ no +");'><i class='bi bi-person-plus-fill i_icon'></i></button>";
  			} else {
	  			alert(parseData.msgContents);
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  		
}


