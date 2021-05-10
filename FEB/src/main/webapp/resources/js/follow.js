/**
 * follow.js
 */
 
function doFollow(followingEmail, followedEmail) {
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
	  			document.getElementById("my_page_icon_follow").innerHTML = "<button type='button' class='btn-image' onclick='doCancelFollow(\""+ followingEmail +"\", \""+ followedEmail +"\");' style='margin: -5px 0px 0px 15px;'><i class='bi bi-person-plus-fill i_icon'></i></button>";
  			} else {
	  			alert(parseData.msgContents);
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  		
}

function doCancelFollow(followingEmail, followedEmail) {
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
	  			document.getElementById("my_page_icon_follow").innerHTML = "<button type='button' class='btn-image' onclick='doFollow(\""+ followingEmail +"\", \""+ followedEmail +"\");' style='margin: -5px 0px 0px 15px;'><i class='bi bi-person-plus i_icon'></i></button>";
  			} else {
	  			alert(parseData.msgContents);
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
  		
}
