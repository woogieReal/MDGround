/**
 * cmn.js
 *
 * doSelectProfileImageEach(email, no): 유저들의 프로필 이미지를 각각 출력
 * doSelectMember(no, email): 작성자의 프로필 이미지를 클릭하면 my_page.jsp 로 이동
 *
 */
 
function doSelectProfileImageEach(email, no) {

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
  			
  			var html = "";
  			
  			html += "        <form id='imageFrm"+ no +"' name='imageFrm"+ no +"' method='get'>         ";
  			html += "		   <input type='hidden' id='anyNo"+ no +"' name='anyNo"+ no +"' value='' >     ";
  			html += "          <button type='button' style='margin: 0px;' onclick='doSelectMember("+ no +", \""+ email +"\");' class='btn-image'><img class='profile_img_header' src='/feb/"+ srcValue +"'></button>";
  			html += "        </form>                                                        ";
			
			document.getElementById("profileImageTd"+no+"").innerHTML = html;
			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
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
 
 