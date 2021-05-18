/**
 * member.js
 *
 * doUploadProfileImage(): my_page.jsp 에서 프로필 이미지를 업로드
 * doRetrieveFollowing(email, loginMemberEamil): 모달 div에 my_page 주인이 팔로우한 유저들을 출력
 * doRetrieveFollowed(email, loginMemberEamil): 모달 div에 my_page 주인을 팔로우한 유저들을 출력
 *
 * doCheckFollowingWithLoginMember(followingEmail, followedEmail, no): 모달 div에 출력된 유저들과 로그인한 유저와의 팔로우 여부를 체크
 * doCancelFollowInFollowModal(followingEmail, followedEmail, no): 모달 div에서 언팔로우
 * doFollowInFollowModal(followingEmail, followedEmail, no): 모달 div에서 팔로우
 * 
 * doEditProfile(): 프로필을 편집
 * 
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
	
	//console.log(document.getElementById('followingCountBtn'));
	if(document.getElementById('followingCountBtn') != null && document.getElementById('editShowBtn') != null){
	
		document.getElementById('followingCountBtn').addEventListener('click', function() {
		    modal('follow_modal');
		});
		
		document.getElementById('followedCountBtn').addEventListener('click', function() {
		    modal('follow_modal');
		});
		
		document.getElementById('introShowBtn').addEventListener('click', function() {
		    modal('intro_modal');
		});

		document.getElementById('editShowBtn').addEventListener('click', function() {
		    modal('profile_edit_modal');
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
				html += "   <td id='profileImageTd"+ i +"'></td>  ";
				html += "   <td>"+ value.followingEmail +"</td>  ";
				html += "   <td id='followCheckTd"+ i +"'></td>  ";
				html += " </tr> ";
				
	  			doSelectProfileImageEach(value.followingEmail, i);
				
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
				html += "   <td id='profileImageTd"+ i +"'></td>  ";
				html += "   <td>"+ value.followedEmail +"</td>  ";
				html += "   <td id='followCheckTd"+ i +"'></td>  ";
				html += " </tr> ";
				
	  			doSelectProfileImageEach(value.followedEmail, i);
				
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

function doEditProfile() {
	console.log("doEditProfile()");
	
	let email = document.getElementById("profileEmail").value;
	let realPw = document.getElementById("realPw").value;
	
	let newName = document.getElementById("newName").value;
	let nowPw = document.getElementById("nowPw").value;
	let newPw = document.getElementById("newPw").value;
	let newPwCheck = document.getElementById("newPwCheck").value;
	
	if(nowPw.trim().length == 0 && newPw.trim().length == 0 && newPwCheck.trim().length == 0) {
		nowPw = realPw;
		newPw = realPw;
		newPwCheck = realPw;
	}
	
	if(newName.trim().length == 0) { document.getElementById("newName").focus(); alert("Enter your new name"); return; }
	if(nowPw != realPw) { document.getElementById("nowPw").focus(); alert("This is not a correct password."); return; }
	if(newPw.trim().length == 0)  { document.getElementById("newPw").focus(); alert("Enter your new password."); return; }
	if(newPwCheck.trim().length == 0)  { document.getElementById("newPwCheck").focus(); alert("Confirm your new password."); return; }
	if(newPw != newPwCheck)  { document.getElementById("newPwCheck").focus(); alert("Confirm your new password."); return; }
	if(!checkPassword(email, newPw)) {return;}
	
	
	$.ajax({
  		type: "POST",
  		url:"/feb/member/do_update_progfile.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			name: newName,
  			pw: newPw,
  			email: email
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			
  			if(parseData.msgId == 1){
  				document.getElementById("nowPw").value = "";
  				document.getElementById("newPw").value = "";
  				document.getElementById("newPwCheck").value = "";
  				document.getElementById("realPw").value = newPw;
  			}
  			
  			alert(parseData.msgContents);
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
	
	
	
	
}






