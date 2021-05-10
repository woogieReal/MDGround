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
	
	console.log("profileImagePath: "+profileImagePath);
	console.log("profileImageName: "+profileImageName);

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
		    	
		    	  console.log("data: " + data);
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