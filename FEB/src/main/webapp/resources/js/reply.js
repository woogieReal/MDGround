/**
 * reply.js
 * 
 * doRetrieveReply(no): 댓글 목록을 출력
 * doInsertReply(): 댓글을 입력
 * 
 * 
 * 
 * 
 */
 
function doRetrieveReply(no){
	//console.log("doRetrieveReply()");
	console.log("postNo: "+no);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/reply/do_retrieve.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			postNo: no
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			var html = "";
  			
 			$.each(parseData, function(i, value) {
				
				html += " <tr> ";
				html += "   <td rowspan='3' id='profileImageTd"+ i +"'></td> ";
				html += "   <td style='background-color: #efebe9;'>"+ value.memberEmail +"</td> ";
				html += "   <td style='background-color: #efebe9; text-align: right;'>"+ value.regDt +"</td> ";
				html += " </tr> ";
				html += " <tr> ";
				html += "   <td colspan='2'>"+ value.contents +"</td>   ";
				html += " </tr> ";
				html += " <tr> ";
				html += "   <td></td> ";
				html += "   <td style='text-align: right;'>"+  +"</td>   ";
				html += " </tr> ";
				
				doSelectProfileImageEach(value.memberEmail, i);
				
			});
			
			document.getElementById("replyTable").innerHTML = html;			
			  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
  		
}

function doInsertReply() {
	//console.log("doInsertReply()");
	
	var text = document.getElementById("replyText").value;
	var no = document.getElementById("postNoInReply").value;
	var email = document.getElementById("emailInReply").value;
	
	console.log(text);
	console.log(no);
	console.log(email);
	
	$.ajax({
  		type: "POST",
  		url:"/feb/reply/do_insert.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			contents: text,
  			postNo: no,
  			memberEmail: email
  		},
  		success:function(data){//통신 성공
  			
 			var parseData = JSON.parse(data);
 			
 			if(parseData.msgId == 1) {
				doRetrieveReply(no);
			} else {
				alert(parseData.msgContents);
			}		
			  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
	
	
}




