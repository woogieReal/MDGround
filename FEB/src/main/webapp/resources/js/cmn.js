/**
 * cmn.js
 *
 * doSelectProfileImageEach(email, no): 유저들의 프로필 이미지를 각각 출력
 * doSelectMember(no, email): 작성자의 프로필 이미지를 클릭하면 my_page.jsp 로 이동
 * 
 * modal(id): 모달창 설정
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


window.onload = function() {
	
	//console.log(document.getElementById('followingCountBtn'));
	if(document.getElementById('followingCountBtn') != null){
	
		//console.log("modal");
		
		document.getElementById('followingCountBtn').addEventListener('click', function() {
		    modal('follow_modal');
		});
		
		document.getElementById('followedCountBtn').addEventListener('click', function() {
		    modal('follow_modal');
		});
		
		document.getElementById('introShowBtn').addEventListener('click', function() {
		    modal('intro_modal');
		});

		if(document.getElementById('editShowBtn') != null) {
		
			document.getElementById('editShowBtn').addEventListener('click', function() {
			    modal('profile_edit_modal');
			});
		}
		
		if(document.getElementById('showIntroEditBtn') != null) {
		
			document.getElementById('showIntroEditBtn').addEventListener('click', function() {
			    modal('intro_edit_modal');
			});
		}
	
	}
	
	if(document.getElementById('fileUploadShowBtn') != null) {
		
		//console.log("file_upload_modal");
		
		document.getElementById('fileUploadShowBtn').addEventListener('click', function() {
		    modal('file_upload_modal');
		});		
	
	}	

}




 
 