/**
 * main.js
 */
 
function doRetrieve(searchDiv, searchWord) {
	console.log("doMovePost()");
	
	$.ajax({
  		type: "POST",
  		url:"/feb/post/do_retrieve.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			searchDiv: searchDiv,
  			searchWord: searchWord
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
			console.log(parseData);
			
			document.getElementById("mainPostsDiv").value = "";
			
			var html = "";
			
			$.each(parseData, function(i, value) {
				
				var imagePath = value.thumbNail;
				if(imagePath == undefined || imagePath == ""){
					imagePath = "/resources/image_source/javascript.png";
				}
				//console.log("imagePath: "+imagePath);
				
				html += "    <div class='col'>                                                                                                                                                   ";
				html += "      <div class='card shadow-sm'>                                                                                                                                      ";
				html += "        <form id='imageFrm"+ value.postNo +"' name='imageFrm"+ value.postNo +"' method='get'>         ";
				html += "		   <input type='hidden' id='postNo"+ value.postNo +"' name='postNo"+ value.postNo +"' value='' >                                                                                                                                                              ";
				html += "		   <button type='button' class='btn-image'><img class='bd-placeholder-img card-img-top thumb_nail_img' onclick='doSelectPost("+ value.postNo +");' src='/feb"+ imagePath +"'></button>                                             ";
				html += "		                                                                                                                                                                 ";
				html += "          <div class='card-body'>                                                                                                                                         ";
				html += "            <span style='font-weight: bold;'>"+ value.title +"</span>     ";
				html += "            <div class='d-flex justify-content-between align-items-center'>                                                                                               ";
				html += "              <small class='text-muted'>"+ value.category +"</small>                                                                                                                    ";
				html += "            </div>                                                                                                                                                        ";
				html += "          </div>                                                                                                                                                          ";
				html += "        </form>                                                        ";
				html += "      </div>                                                                                                                                                            ";
				html += "    </div>                                                                                                                                                              ";

			});
			
			//console.log(html);
			
			document.getElementById("mainPostsDiv").innerHTML = html;
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
}

function doSelectPost(no) {
	//console.log("doSelectPost("+ no +")");
	
	var frm = document.getElementById("imageFrm"+no+"");
	frm.action = "/feb/post/do_select_post.do";
	
	document.getElementById("postNo"+no+"").setAttribute("name", "postNo");
	document.getElementById("postNo"+no+"").setAttribute("id", "postNo");
	document.getElementById("postNo").value = no;
	
	//console.log("postNo: "+document.getElementById("postNo").value);
	frm.submit();
}





