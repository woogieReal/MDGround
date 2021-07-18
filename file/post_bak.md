change element id and name

## 자바스크립트 id & name 값 변경하는 방법
---

### `setAttribute`
---

document.getElementById("기존 id").setAttribute("name", "새로운 name");  
document.getElementById("기존 id").setAttribute("id", "새로운 id");

id와 name값을 동시에 변경할 때는 name을 먼저 바꾸는 것이 좋다.  
id를 지정해서 변경하는 것이기 때문에 실수를 할 수도 있기 때문.

``` javascript
function doSelectPost(no) {

	var frm = document.getElementById("imageFrm"+no+"");
	frm.action = "/feb/post/do_select_post.do";
	
	document.getElementById("postNo"+no+"").setAttribute("name", "postNo");
	document.getElementById("postNo"+no+"").setAttribute("id", "postNo");
	document.getElementById("postNo").value = no;
	
	frm.submit();
}
```

key event

## 자바스크립트 key 이벤트
---

### `window.event.keyCode`  
### `window.event.shiftKey|ctrlKey|altKey`
---

하나의 키만 입력받아 이벤트를 실행할 경우 window.event.keyCode를 사용  
두 개를 조합해서 사용할 경우 ctrl, shift, alt를 이용. window.event.shiftKey | ctrlKey | altKey

``` java
function ctrEnterkey() {
	
	if (window.event.keyCode == 13 && window.event.ctrlKey){
		console.log("ctrEnterkey()");
		doConvert();
        }		
}
```

file delete

## 자바 파일 삭제하는 법
---

### `Files.deleteIfExists(file)`
---

Path 객체를 만들 때는 이미지의 이름을 포함한 Full Path를 넣어서 만들어야 함.  
그러므로 이미지를 관리하는 테이블에는 Full Path를 저장하는 것이 좋다.

``` java
Path file = Paths.get(imageFullPath);  
Files.deleteIfExists(file);
```

Object null check

## 자바 객체 null 체크
---

### `Objects.isNull(객체)`
---

객체가 null 이면 true,  
null 이 아니면 false 를 반환한다.

---

``` java
for(PostVO postVO : postList) {
	ImageVO imageVO = imageService.doSelectMainImage(postVO);
	if(Objects.isNull(imageVO)) {
		//LOG.debug("************null****************");
		switch (postVO.getCategory()) {
		case "daily life": postVO.setThumbNail("/resources/image_source/markdown.png"); break;
		case "java": postVO.setThumbNail("/resources/image_source/java.png"); break;
		case "javascript": postVO.setThumbNail("/resources/image_source/javascript.png"); break;
		}
	LOG.debug("postVO.getThumbNail(): "+postVO.getThumbNail());
	} else {
		postVO.setThumbNail(imageVO.getPath()+imageVO.getSaveName());
	}
}
```

window.onload

## 페이지가 모두 로드 된 후 스크립트를 읽도록 하기
---

### `window.onload`
---

페이지가 다 로드되기 전에 스크립트를 읽어 들이면 document.getElementById('id 값'); 에서  
id 값을 가진 태그가 정의 되기 이전이므로 오류가 일어날 수 있다.  
가장 쉬운 방법은 스크립트를 html 문서의 가장 아래에 두는 것.  
아니면 **window.onload** 사용한다.  

``` javascript
window.onload = function() { 스크립트 }
```

웹브라우저 자체를 담당하는 window라는 객체가 웹 문서를 불러 올 때, 문서가 사용되는 시점에 실행되는 onload 라는 함수를 내가 다시 정의한 다는 개념이다.

[참고](https://wiserloner.tistory.com/380) 


window.location.reload()

## 자바스크립트 화면 리프레쉬 함수
---

### `window.location.reload()`
---

* 화면을 reload하는 함수.  
* cache를 먼저 찾아보고 없으면 서버에서 다시 페이지 호출

**window.location.reload(true)**  
cache와는 상관없이 무조건 서버에서 다시 페이지 호출

[참고](http://mwultong.blogspot.com/2006/08/html-windowlocationreloadtrue.html)


Pepsi zero sugar

## 처음으로 마셔보는 **펩시 제로**
---

오늘 햇빛이 강해서 굉장히 더웠다...  
그래서 집에 오늘 길에 처음으로 **펩시 제로**를 사봤다!  
**제로콜라**는캔은 1500원, 페트는 2000원 이어서 참 애매하다.  
캔 사기엔 돈이 아깝고 페트는 너무 많아  
그래서 **1+1** 인 펩시를 샀다.
마셔보니까 음 차이를 모르겠다 ㅋㅋㅋ  
그냥 나는 아무거나 마셔야겠다!  


SOONHARI LEMON JIN

## 순하리 레몬 진
---

오늘은 **순하리 레몬 진**을 마셔봤다!  
원래는 **클라우드** 한 캔을 마시려고 했는데 편의점에 큰 캔밖에 안 팔아서 한 번 새로운 도전을 해봤다.  
맥주는 아니고 과실주 였는데 처음 마시자 순하리 레몬 소주 맛의 느낌이 확 다가왔다. 
 
내가 순하리를 처음 마셔본 것은 **2015년** 대학교 2학년 때였다.  
출시와 동시에 대학생들 사이에서 폭발적인 인기를 끌었었다. 당시 쓰디 쓴 **소주**만 들이켰던 나와 동기들은 신세계를 맛보고 왜 1년 더 빨리 나와주지 않았는지 아쉬워 했었다. 하지만 과 행사의 뒷풀이에서는 술술 넘어가는 순하리는 술값이 너무 많이 나온다는 이유로 주문금지 당했던 기억이 난다.  

갑자기 과거 회상을 했는데 아무튼 맛은 꽤 맛있었다. 첫 맛 빼고는 평범하게 **달달한 과실주**의 맛 이여서 부담 없이 목으로 넘어 갔다. 살짝 식어서 아쉬웠는데 다음에는 냉동고에 넣어놨다가 살얼음 살짝 얼 즈음에 마셔봐야겠다.


G-SHOCK 5600 in THOA cafe with Umi

## 도아 카페에서 **5600** 사진!
---

오늘은 **레트로**하게 5600을 차봤다!  
오랜만에 알람을 맞춰봤는데 이렇게 하는게 맞던가....?  
이따 한 번 찾아봐야 겠다.  
삑삑 소리 좋아


Noduel island

## 석양지는 노들섬
---

카페 그로잉에서 나와서 **행복은 간장밥**에서 연어동을 먹은 후에 **노들섬**에 갔다.  
올해 2월에 영웅이랑 왔던 곳인데 문화시설도 많고 경치도 좋아서 우미와 함께 다시 찾았다.   
영웅이랑 왔을 때는 광장(?)에 앉아서 잠깐 시간을 보낸 후에 전시장과 화원, 서점에서 주로 시간을 보냈었다. 그래서 한강 쪽은 안가봤었는데 오늘 우미와 가보니 **석양** 지는 풍경이 정말 아름다웠다.  
많은 사람들이 돗자리를 깔고 시간을 보내고 있었고 우리는 한강을 따라 걷다 야경을 보고 돌아 갔다.  


Cafe growing not browing

## 그로잉 카페
---

오늘은 우미하고 카페 **그로잉**에서 커피를 마셨다.  
학원을 다닐 때 쉬는 시간에 산책하다가 발견한 카페였다.  
카페 로고를 보고 당연히 이름이 **브로잉**인 줄 알았는데 **그로잉**이였다...  
오늘 같이 날씨가 좋은 날에는 창문이 열려있는 곳에서 시원한 커피 한 잔을 하고 싶어진다.  
아직 5월인데 이렇게 덥다니 다가올 **여름**이 벌써 두렵다.

[인스타그램](https://www.instagram.com/cafe_growing/)



---------------------------------------------------
## Hello!
안녕하세요 개발자 **김재욱**입니다!  
이 웹사이트는 <u>마크다운</u> 언어로 작성하는 게시물을 테마로 하고 있습니다.  
궁금하신 점이 있으시면 아래의 이메일로 연락바랍니다.  
`plagis@daum.net`