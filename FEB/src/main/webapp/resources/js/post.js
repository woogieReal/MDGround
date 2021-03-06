/**
 * post.js
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
 
function doMovePost() {
	//console.log("doMovePost()");
	var frm = document.getElementById("moveFrm");
	frm.action = "/feb/post/post_reg_view.do";
	frm.submit();
};

 
function showPopup(frm) { 
	//console.log('showPopup()');
	if(document.getElementById("fromTb").value == 1) {
		document.getElementById("whichMainImage").value = "";
	} if(document.getElementById("fromTb").value == 2) {
		//console.log(document.getElementById("fromNo").value);
	}
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - 500 )/2);
    var _top = Math.ceil(( window.screen.height - 200 )/2);

	var title = "Image Upload";
	var option = "toolbar=0,scrollbars=no,resizable=no,status=yes,width=500,height=200,left="+_left+",top="+_top+"";
	
	window.open("/feb/image/image_view.do",title,option);
	
	frm.target = title;
	frm.action = "/feb/image/image_view.do";
	frm.method = "get";
	frm.submit();
	
};

function doUploadImages() {

  //console.log('doUploadImages()');
  
  var form = new FormData(document.getElementById("uploadFrm"));
  
  $.ajax({
      url: "/feb/image/do_upload.do",
      enctype: 'multipart/form-data',
      data: form, 
      type: 'POST',
      async: 'false',
      processData: false,
      contentType: false,
      success: function(data) {
    	
    	//console.log("data: " + data);
		alert("Successfully uploaded");

        setSendChild(data);
        document.getElementById("file_upload_modal_close_btn").click();

      },
      error: function(data) {
        console.log('error'+data);
      }
    });

}

//popup에서 가져온 값 처리
function setSendChild(param) {
	
	//console.log("param: " + param);
	
	var jsonString = JSON.stringify(param);
	
	//console.log("jsonString: " + jsonString);
	
	document.getElementById("imageList").value = jsonString; 
	
	var tmpImageList = JSON.parse(jsonString);
	//console.log(tmpImageList);
	
	var cnt = 0;
	
	document.getElementById("uploadImageView").value = "";
	
	var html = "";
	html += "<ul class='list-group mb-3'>";
	
	let imageNm = "uploadImage";
	
	$.each(tmpImageList, function(i, value) {
		
		//console.log("onclick: " + imageNm + i);
		
		if(cnt == 0){
			html += "<li class='list-group-item d-flex justify-content-between lh-sm'> <img style='width: 200px; height: 50px; object-fit: cover; border-radius: 5px;' id='uploadImage"+i+"' onclick='changeImageSize("+ imageNm + i +")' src='/feb"+ value.path + value.saveName +"'> <input type = 'radio' style='font-size: 32px;' class='form-check-input' name = 'selectImage' value = '"+i+"' checked='checked' onclick='clickWhichMainImage("+i+");'></li>";
		} else {
			html += "<li class='list-group-item d-flex justify-content-between lh-sm'> <img style='width: 200px; height: 50px; object-fit: cover; border-radius: 5px;' id='uploadImage"+i+"' onclick='changeImageSize("+ imageNm + i +")' src='/feb"+ value.path + value.saveName +"'> <input type = 'radio' style='font-size: 32px;' class='form-check-input' name = 'selectImage' value = '"+i+"' onclick='clickWhichMainImage("+i+");' ></li>";
		}
		
		cnt += 1;
	});
	
	html += "</ul>";
	
	//console.log(html);
	
	document.getElementById("uploadImageView").innerHTML=html;
	
	document.getElementById("imageCntView").value = "";
	
	var html2 = "<span class='badge bg-primary rounded-pill'>"+cnt+"</span>";
	document.getElementById("imageCntView").innerHTML=html2;
	
}

function clickWhichMainImage(i){
	//console.log("clickWhichMainImage"+i);
	document.getElementById("whichMainImage").value = i;
}

function post(){
	//console.log("post()");
	
	let title = document.getElementById("title").value;
	let text = document.getElementById("text").value;
	let category = document.getElementById("category").value;
	let memberEmail = document.getElementById("memberEmail").value;
	
	let imageList = document.getElementById("imageList").value;
	let fromTb = document.getElementById("fromTb").value;
	let mainImage = document.getElementById("whichMainImage").value;
	
	//console.log("title: "+title);
	//console.log("category: "+category);
	//console.log("text: "+text);
	//console.log("memberEmail: "+memberEmail);
	
	//console.log("imageList: "+imageList);
	//console.log("fromTb: "+fromTb);
	//console.log("mainImage: "+mainImage);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_insert.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			title: title,
  			textMd: text,
  			category: category,
  			memberEmail: memberEmail
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			
  			//console.log(imageList);
  			
  			if(parseData.msgId == 1 && imageList != ""){
	  			
				$.ajax({
			  		type: "POST",
			  		url:"/feb/image/do_insert.do",
			  		asyn:"true",
			  		dataType:"html",
			  		data:{
			  			imageList: imageList,
			  			fromTb: fromTb,
			  			mainImage: mainImage
			  		},
			  		success:function(data){//통신 성공
			  			
			  			var parseData = JSON.parse(data);
			  			if(parseData.msgId == 1){
				  			alert("Successfully posted");
				  			doMoveToMain();
				  			
			  			} else {
				  			alert(parseData.msgContents);
			  			}
			  		
			  		},
			  		error:function(data){//실패시 처리
			  			console.log("error:"+data);
			  		}
			  	});	  			
	  			
	  			
  			} else {
	  			alert(parseData.msgContents);
	  			doMoveToMain();
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});		
	
}

function doConvert() {
	//console.log("doConvert()");
	var text = document.getElementById("text").value;
	//console.log("text: "+text);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_convert.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			textMD: text
  		},
  		success:function(data){//통신 성공
  			
			//console.log("data: "+data);
  			document.getElementById("Preview").innerHTML = data;
  			document.getElementById("register_button").focus();
  			
  		},
  		error:function(data){//실패시 처리
  			//console.log("error:"+data);
  		}
  	});			
	
}

function doMoveToEdit() {
	//console.log("doMoveToEdit()");
	var frm = document.getElementById("postViewFrm");
	frm.action = "/feb/post/do_edit_post.do";
	frm.submit();	
}

function doDelete() {
	//console.log("doDelete()");
	if(!window.confirm('really?')) return;
	
	let postNo = document.getElementById("postNo").value;
	let imageList = document.getElementById("imageListStr").value;
	//console.log("postNo: "+postNo);
	//console.log("imageList: "+imageList);
	//console.log("stringify: "+JSON.stringify(imageList));
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_delete.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			postNo: postNo
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			
  			if(parseData.msgId == 1 && imageList != "[]"){
	  			
				$.ajax({
			  		type: "POST",
			  		url:"/feb/image/do_delete.do",
			  		asyn:"true",
			  		dataType:"html",
			  		data:{
			  			imageList: imageList
			  		},
			  		success:function(data){//통신 성공
			  			
			  			var parseData = JSON.parse(data);
			  			if(parseData.msgId == 1){
				  			alert("Successfully deleted");
				  			doMoveToMain();
				  			
			  			} else {
				  			alert(parseData.msgContents);
			  			}
			  		
			  		},
			  		error:function(data){//실패시 처리
			  			console.log("error:"+data);
			  			
			  		}
			  	});	  			
	  			
	  			
  			} else {
	  			alert(parseData.msgContents);
	  			doMoveToMain();
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function edit(){
	console.log("edit()");
	
	let title = document.getElementById("title").value;
	let text = document.getElementById("text").value;
	let category = document.getElementById("category").value;
	let postNo = document.getElementById("postNo").value;
	
	let imageListDel = document.getElementById("imageListDel").value;
	let imageList = document.getElementById("imageList").value;
	let fromTb = document.getElementById("fromTb").value;
	let mainImage = document.getElementById("whichMainImage").value;
	
	//console.log("title: "+title);
	//console.log("text: "+text);
	//console.log("category: "+category);
	//console.log("postNo: "+postNo);
	
	//console.log("imageListDel: "+imageListDel);
	//console.log("imageList: "+imageList);
	//console.log("fromTb: "+fromTb);
	//console.log("mainImage: "+mainImage);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_update.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			title: title,
  			textMd: text,
  			category: category,
  			postNo: postNo
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			
  			if(parseData.msgId == 1 && imageList != ""){
	  			
				$.ajax({
			  		type: "POST",
			  		url:"/feb/image/do_update.do",
			  		asyn:"true",
			  		dataType:"html",
			  		data:{
			  			fromTb: fromTb,
			  			fromNo: postNo,
			  			imageListDel: imageListDel,
			  			imageListNew: imageList,
			  			mainImage: mainImage
			  		},
			  		success:function(data){//통신 성공
			  			
			  			var parseData = JSON.parse(data);
			  			if(parseData.msgId == 1){
				  			alert("Successfully edited");
				  			doMoveToMain();
				  			
			  			} else {
				  			alert(parseData.msgContents);
			  			}
			  		
			  		},
			  		error:function(data){//실패시 처리
			  			console.log("error:"+data);
			  			
			  		}
			  	});	  			
	  			
	  			
  			} else {
	  			alert(parseData.msgContents);
	  			doMoveToMain();
  			}
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
}

function changeImageSize(image) {
	//console.log(image);
	
	//let imagetmp = document.getElementById(image);
	let imagetmp = image;
	
	//console.log(imagetmp);
	//console.log(imagetmp.style.height);
	
	if(imagetmp.style.height == '50px'){
		imagetmp.style.height = "100%";
	} else {
		imagetmp.style.height = '50px';
	}
	
}
