/**
 * header.js
 *
 * doSelectProfileImage(email): header.jsp 에 로그인한 유저의 프로필 이미지를 출력
 * doClickProfileImage(email): header.jsp 에 있는 로그인 유저의 프로필 이미지를 클릭하여 my_page.jsp 로 이동 
 *
 */
 
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


 
