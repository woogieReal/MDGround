/**
 * storage.js
 */
 
function doStore(type, email ,no) {
	console.log("doStore()");
	/*console.log("type: "+type);
	console.log("email: "+email);
	console.log("no: "+no);*/
	
	$.ajax({
  		type: "POST",
  		url:"/feb/storage/do_store.do",
  		asyn:true,
  		dataType:"html",
  		data:{
  			storeType: type,
  			memberEmail: email,
  			postNo: no
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
			if(parseData.msgId == 1 && type ==1){
				document.getElementById("post_icon_bookmark"+no).innerHTML = "<button type='button' onclick='doCancelStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-bookmark-fill i_icon'></i></button>";
			} else if(parseData.msgId == 1 && type ==2){
				document.getElementById("post_icon_heart"+no).innerHTML = "<button type='button' onclick='doCancelStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-heart-fill i_icon'></i></button>";
			}		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
}

function doCancelStore(type, email ,no) {
	console.log("doCancelStore()");
	/*console.log("type: "+type);
	console.log("email: "+email);
	console.log("no: "+no);*/
	
	$.ajax({
  		type: "POST",
  		url:"/feb/storage/do_cancel_store.do",
  		asyn:true,
  		dataType:"html",
  		data:{
  			storeType: type,
  			memberEmail: email,
  			postNo: no
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
			if(parseData.msgId == 1 && type ==1){
				document.getElementById("post_icon_bookmark"+no).innerHTML = "<button type='button' onclick='doStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-bookmark i_icon'></i></button>";
			} else if(parseData.msgId == 1 && type ==2){
				document.getElementById("post_icon_heart"+no).innerHTML = "<button type='button' onclick='doStore("+type+", \""+email+"\" ,"+no+");' class='btn-image'><i class='bi bi-heart i_icon'></i></button>";
			}		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
}