/**
 * sign_in js
 */

function doMoveToMain() {
	console.log("doMoveToMain()");
	location.href = "http://localhost:8099/feb/main/main_view.do";
};

function doMoveToSignIn() {
	console.log("doMoveToSignIn()");
	location.href = "http://localhost:8099/feb/member/sign_in_view.do";
};

function doMoveToSignUp() {
	console.log("doMoveToSignIn()");
	location.href = "http://localhost:8099/feb/member/sign_up_view.do";
};

function doSignIn() {
	console.log("doSignIn()");
	let email = document.getElementById("email").value;
	let pw = document.getElementById("pw").value;
	
	$.ajax({
  		type: "POST",
  		url:"/feb/member/do_login_check.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			email: email,
  			pw: pw
  		},
  		success:function(data){//통신 성공
  			
  			var parseData = JSON.parse(data);
  			if(parseData.msgId == 1){
	  			doMoveToMain();
  			} else {
	  			alert(parseData.msgContents);
  			}
  			
  			
  		
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});	
}

function doSignUp() {
	console.log("doSignUp()");
	
	let email = document.getElementById("email").value;
	let pw = document.getElementById("pw").value;
	let pw_check = document.getElementById("pw_check").value;
	let name = document.getElementById("name").value;
	let location = document.getElementById("location").value;
	let idCheckFlag = document.getElementById("idCheckFlag").value;
	let checkedId = document.getElementById("checkedId").value;
	
	console.log("email: "+email);
	console.log("pw: "+pw);
	console.log("pw_check: "+pw_check);
	console.log("name: "+name);
	console.log("location: "+location);
	console.log("idCheckFlag: "+idCheckFlag);
	console.log("checkedId: "+checkedId);

	if(null == email || email.trim().length == 0) { document.getElementById("email").focus(); alert("E-MAIL을 입력 하세요."); return; }
	if(null == pw || pw.trim().length == 0) { document.getElementById("pw").focus(); alert("비밀번호를 입력 하세요."); return; }
	if(null == pw_check || pw_check.trim().length == 0) { document.getElementById("pw_check").focus(); alert("비밀번호 확인을 입력 하세요."); return; }
	if(pw != pw_check) { document.getElementById("pw_check").focus(); alert("동일한 비밀번호를 입력해 주십시오."); return; }
	if(null == name || name.trim().length == 0) { document.getElementById("name").focus(); alert("이름을 입력 하세요."); return; }
	if(null == location || location.trim().length == 0) { document.getElementById("location").focus(); alert("국가를 선택 하세요."); return; }
	
	if(idCheckFlag != "checked") { alert("id 중복체크를 하세요."); return; }
	if(checkedId != email) { alert("id 중복체크를 하세요."); return; }
	//if(!checkPassword()) {return;}

	$.ajax({
  		type: "POST",
  		url:"/feb/member/do_register.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			name: name,
  			email: email,
  			pw: pw,
  			location: location
  		},
  		success:function(data){//통신 성공
  			
  			let parseData = JSON.parse(data);
  			alert(parseData.msgContents);
  			window.location.href = "http://localhost:8099/feb/member/sign_in_view.do";
  			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
	
};


function doCheckDuplicatedId() {

	console.log("doCheckDuplicatedId()");
	let email = document.getElementById("email").value;
	console.log("email: "+email);
	
	if(!verifyEmail(email)) { document.getElementById("email").value = ""; return; }
	
	$.ajax({
  		type: "POST",
  		url:"/feb/member/do_check_duplicated_id.do",
  		asyn:"true",
  		dataType:"html",
  		data:{
  			email: email
  		},
  		success:function(data){//통신 성공
  			
  			let parseData = JSON.parse(data);
  			
  			if("1"==parseData.msgId){
    			alert(parseData.msgContents);
    			document.getElementById("email").value = "";
    			document.getElementById("email").focus();
    			document.getElementById("idCheckFlag").value = "";
    			document.getElementById("checkedId").value = "";
    		}else{
    			alert(parseData.msgContents);
    			document.getElementById("pw").focus();
    			document.getElementById("idCheckFlag").value = "checked";
    			document.getElementById("checkedId").value = email;
    		}
  			
  		},
  		error:function(data){//실패시 처리
  			console.log("error:"+data);
  		}
  	});
  		
}


function verifyEmail(email) { 
	let emailVal = email;
	let regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; 
	if (emailVal.match(regExp) != null) { console.log('Good!'); return true; } 
	else { alert('올바른 이메일을 입력해 주십시오.'); return false; } 
}

function checkPassword(email, pw){

	let id = email;
	let password = pw;
	
	if(!/^[a-zA-Z0-9]{7,15}$/.test(password)) { alert('비밀번호는 숫자와 영문자 조합으로 7~15자리를 사용해야 합니다.'); return false; }

	let checkNumber = password.search(/[0-9]/g);
	let checkEnglish = password.search(/[a-z]/ig);

	if(checkNumber <0 || checkEnglish <0) { alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다."); return false; }
	if(/(\w)\1\1\1/.test(password)) { alert('비밀번호에 444같은 문자를 4번 이상 사용하실 수 없습니다.'); return false; }
	if(password.search(id) > -1){ alert("비밀번호에 아이디가 포함되었습니다."); return false; }

	return true;

}

function doLogOut() {
	console.log("doLogOut()");
	window.location.href = '/feb/member/do_logoff.do';
}

