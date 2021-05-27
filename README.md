# MDGround
> **마크다운** 언어를 사용하여 게시물을 작성하는 개발자들을 위한 웹사이트
> [링크](http://3.36.223.73:8080/feb/main/main_view.do)

 * **마크다운** 언어를 사용하여 일반적인 SNS와 다른 방식의 포스팅 방식 제공
 * Bootstrap을 사용하여 PC와 Mobile에서 동시에 이용할 수 있는 **반응형** 웹사이트 구축
 * 일상생활 + 프로그래밍 카테고리별로 사용자의 기호에 따라 일상생활을 공유하는 **SNS** 또는 자신의 개발정보를 기록하는 **Blog**로 이용 가능
 * 클라우드 컴퓨팅(AWS)를 사용한 웹서비스 제공

​
## 개발환경
 * Java 1.8
 * Oracle 11g express edition
 * Ubuntu Server 18.04 LTS
<img src="/README_file/development_environment.png" width="70%" />

​
## 마크다운 언어 변환 라이브러리
flexmark-java (0.62.2 version)   
 * Github [링크](https://github.com/vsch/flexmark-java)
 * Maven Repository [링크](https://mvnrepository.com/artifact/com.vladsch.flexmark/flexmark-all/0.62.2)

​
## 업데이트 내역
 * 1차 완성 및 배포 **(2021-05-17)**

 * 모바일 브라우저에서 이미지 업로드 시 새로운 브라우저가 열려 불편 **(2021-05-18)**
   + 팝업창을 모달창으로 변경 **(2021-05-19)**
 
 * 게시물 등록 시 썸네일 이미지 선택을 업로드한 이미지의 이름 목록을 보고 선택하는 것은 이미지 이름을 일일히 확인 하여야 해서 불편하다는 동료 개발자 의견 **(2021-05-19)**
   + 이미지의 이름 대신 이미지 자체를 출력하여 고를 수 있도록 수정 **(2021-05-20)**
 
 * 게시물에서 코드구역으로 설정한 부분이 다른 텍스트와 별다른 차이가 없어서 보기에 깔끔하지 않음 **(2021-05-24)**
   + &lt;pre&gt;&lt;code&gt; ... &lt;/code&gt;,&lt;/pre&gt; 태그 부분 옅은 회색의 배경색을 추가 **(2021-05-24)**
 
 * 마크다운 언어를 모르는 사용자는 게시물 작성이 불편하다는 일반 사용자 의견 **(2021-05-24)**
   + 게시물 작성 텍스트 박스 위에 셀렉트 박스를 추가
   + 드롭다운 옵션 중에서 요소(ex. title, list)를 선택해 add 버튼을 누르면 텍스트 박스에 추가 되는 방식
   + 선택 가능 요소: title, bold, italic, underline, code line, code block, list, link **(2021-05-25)**
 * 보안 관련 **(2021-05-26~)**
   + spring-security-web 라이브러리를 사용하여 사용자 비밀번호 암호화 **(2021-05-27)**

​
## 웹사이트 이용
 * **MDGround** [링크](http://3.36.223.73:8080/feb/main/main_view.do)
 * 게시글은 회원가입 후에 작성가능 합니다 (빠른 이용을 원하시는 분은 아래의 테스트 계정을 이용바랍니다)
 * 테스트 계정 
   + ID: test@gmail.com
   + PW: test1234
 * 작성하신 게시물은 삭제시 업로드한 이미지를 포함하여 어떤 관련 데이터도 보관하지 않으니 안심하고 이용바랍니다
 * 마크다운 언어를 이용한 포스트 예시 (Ctrl + Enter로 작성하면서 빠르게 미리보기가 가능합니다)
 <img src="/README_file/markdown_post_example.gif" width="70%" />

​
## 작동모습

### 포스트
* PC
<img src="/README_file/post_example_pc.png" width="70%" />

* Mobile
<img src="/README_file/post_example_mobile.png" width="70%" />

### 메인 페이지
* PC
<img src="/README_file/main_pc.png" width="70%" />

* Mobile
<img src="/README_file/main_mobile.png" width="70%" />

### 게시물 상세
* PC
<img src="/README_file/post_view_pc.png" width="70%" />

* Mobile
<img src="/README_file/post_view_mobile.png" width="70%" />

### 마이페이지
* PC
<img src="/README_file/my_page_pc.png" width="70%" />

* Mobile
<img src="/README_file/my_page_mobile.png" width="70%" />

* PC
<img src="/README_file/intro_pc.png" width="70%" />
<img src="/README_file/follow_pc.png" width="70%" />
<img src="/README_file/profile_image_pc.png" width="70%" />

* Mobile
<img src="/README_file/profile_follow_intro_mobile.png" width="70%" />


