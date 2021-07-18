change element id and name

## �ڹٽ�ũ��Ʈ id & name �� �����ϴ� ���
---

### `setAttribute`
---

document.getElementById("���� id").setAttribute("name", "���ο� name");  
document.getElementById("���� id").setAttribute("id", "���ο� id");

id�� name���� ���ÿ� ������ ���� name�� ���� �ٲٴ� ���� ����.  
id�� �����ؼ� �����ϴ� ���̱� ������ �Ǽ��� �� ���� �ֱ� ����.

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

## �ڹٽ�ũ��Ʈ key �̺�Ʈ
---

### `window.event.keyCode`  
### `window.event.shiftKey|ctrlKey|altKey`
---

�ϳ��� Ű�� �Է¹޾� �̺�Ʈ�� ������ ��� window.event.keyCode�� ���  
�� ���� �����ؼ� ����� ��� ctrl, shift, alt�� �̿�. window.event.shiftKey | ctrlKey | altKey

``` java
function ctrEnterkey() {
	
	if (window.event.keyCode == 13 && window.event.ctrlKey){
		console.log("ctrEnterkey()");
		doConvert();
        }		
}
```

file delete

## �ڹ� ���� �����ϴ� ��
---

### `Files.deleteIfExists(file)`
---

Path ��ü�� ���� ���� �̹����� �̸��� ������ Full Path�� �־ ������ ��.  
�׷��Ƿ� �̹����� �����ϴ� ���̺��� Full Path�� �����ϴ� ���� ����.

``` java
Path file = Paths.get(imageFullPath);  
Files.deleteIfExists(file);
```

Object null check

## �ڹ� ��ü null üũ
---

### `Objects.isNull(��ü)`
---

��ü�� null �̸� true,  
null �� �ƴϸ� false �� ��ȯ�Ѵ�.

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

## �������� ��� �ε� �� �� ��ũ��Ʈ�� �е��� �ϱ�
---

### `window.onload`
---

�������� �� �ε�Ǳ� ���� ��ũ��Ʈ�� �о� ���̸� document.getElementById('id ��'); ����  
id ���� ���� �±װ� ���� �Ǳ� �����̹Ƿ� ������ �Ͼ �� �ִ�.  
���� ���� ����� ��ũ��Ʈ�� html ������ ���� �Ʒ��� �δ� ��.  
�ƴϸ� **window.onload** ����Ѵ�.  

``` javascript
window.onload = function() { ��ũ��Ʈ }
```

�������� ��ü�� ����ϴ� window��� ��ü�� �� ������ �ҷ� �� ��, ������ ���Ǵ� ������ ����Ǵ� onload ��� �Լ��� ���� �ٽ� ������ �ٴ� �����̴�.

[����](https://wiserloner.tistory.com/380) 


window.location.reload()

## �ڹٽ�ũ��Ʈ ȭ�� �������� �Լ�
---

### `window.location.reload()`
---

* ȭ���� reload�ϴ� �Լ�.  
* cache�� ���� ã�ƺ��� ������ �������� �ٽ� ������ ȣ��

**window.location.reload(true)**  
cache�ʹ� ������� ������ �������� �ٽ� ������ ȣ��

[����](http://mwultong.blogspot.com/2006/08/html-windowlocationreloadtrue.html)


Pepsi zero sugar

## ó������ ���ź��� **��� ����**
---

���� �޺��� ���ؼ� ������ ������...  
�׷��� ���� ���� �濡 ó������ **��� ����**�� ��ô�!  
**�����ݶ�**��ĵ�� 1500��, ��Ʈ�� 2000�� �̾ �� �ָ��ϴ�.  
ĵ ��⿣ ���� �Ʊ��� ��Ʈ�� �ʹ� ����  
�׷��� **1+1** �� ��ø� ���.
���ź��ϱ� �� ���̸� �𸣰ڴ� ������  
�׳� ���� �ƹ��ų� ���ž߰ڴ�!  


SOONHARI LEMON JIN

## ���ϸ� ���� ��
---

������ **���ϸ� ���� ��**�� ���źô�!  
������ **Ŭ����** �� ĵ�� ���÷��� �ߴµ� �������� ū ĵ�ۿ� �� �ȾƼ� �� �� ���ο� ������ �غô�.  
���ִ� �ƴϰ� ������ ���µ� ó�� ������ ���ϸ� ���� ���� ���� ������ Ȯ �ٰ��Դ�. 
 
���� ���ϸ��� ó�� ���ź� ���� **2015��** ���б� 2�г� ������.  
��ÿ� ���ÿ� ���л��� ���̿��� �������� �α⸦ ��������. ��� ���� �� **����**�� �����״� ���� ������� �ż��踦 ������ �� 1�� �� ���� �������� �ʾҴ��� �ƽ��� �߾���. ������ �� ����� ��Ǯ�̿����� ���� �Ѿ�� ���ϸ��� ������ �ʹ� ���� ���´ٴ� ������ �ֹ����� ���ߴ� ����� ����.  

���ڱ� ���� ȸ���� �ߴµ� �ƹ�ư ���� �� ���־���. ù �� ����� ����ϰ� **�޴��� ������**�� �� �̿��� �δ� ���� ������ �Ѿ� ����. ��¦ �ľ �ƽ����µ� �������� �õ��� �־���ٰ� ����� ��¦ �� ������ ���ź��߰ڴ�.


G-SHOCK 5600 in THOA cafe with Umi

## ���� ī�信�� **5600** ����!
---

������ **��Ʈ��**�ϰ� 5600�� ���ô�!  
�������� �˶��� ����ôµ� �̷��� �ϴ°� �´���....?  
�̵� �� �� ã�ƺ��� �ڴ�.  
��� �Ҹ� ����


Noduel island

## �������� ��鼶
---

ī�� �׷��׿��� ���ͼ� **�ູ�� �����**���� ����� ���� �Ŀ� **��鼶**�� ����.  
���� 2���� �����̶� �Դ� ���ε� ��ȭ�ü��� ���� ��ġ�� ���Ƽ� ��̿� �Բ� �ٽ� ã�Ҵ�.   
�����̶� ���� ���� ����(?)�� �ɾƼ� ��� �ð��� ���� �Ŀ� ������� ȭ��, �������� �ַ� �ð��� ���¾���. �׷��� �Ѱ� ���� �Ȱ��þ��µ� ���� ��̿� ������ **����** ���� ǳ���� ���� �Ƹ��ٿ���.  
���� ������� ���ڸ��� ��� �ð��� ������ �־��� �츮�� �Ѱ��� ���� �ȴ� �߰��� ���� ���� ����.  


Cafe growing not browing

## �׷��� ī��
---

������ ����ϰ� ī�� **�׷���**���� Ŀ�Ǹ� ���̴�.  
�п��� �ٴ� �� ���� �ð��� ��å�ϴٰ� �߰��� ī�俴��.  
ī�� �ΰ� ���� �翬�� �̸��� **�����**�� �� �˾Ҵµ� **�׷���**�̿���...  
���� ���� ������ ���� ������ â���� �����ִ� ������ �ÿ��� Ŀ�� �� ���� �ϰ� �;�����.  
���� 5���ε� �̷��� ���ٴ� �ٰ��� **����**�� ���� �ηƴ�.

[�ν�Ÿ�׷�](https://www.instagram.com/cafe_growing/)



---------------------------------------------------
## Hello!
�ȳ��ϼ��� ������ **�����**�Դϴ�!  
�� ������Ʈ�� <u>��ũ�ٿ�</u> ���� �ۼ��ϴ� �Խù��� �׸��� �ϰ� �ֽ��ϴ�.  
�ñ��Ͻ� ���� �����ø� �Ʒ��� �̸��Ϸ� �����ٶ��ϴ�.  
`plagis@daum.net`