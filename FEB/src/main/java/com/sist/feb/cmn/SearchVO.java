package com.sist.feb.cmn;

public class SearchVO extends DTO {
	
	private String searchDiv;  //검색구분
	private String searchWord; //검색어
	private String searchDiv2;      //페이지 사이즈
	private String searchWord2;       //페이지 num
	
	public SearchVO() {
		
	}

	public SearchVO(String searchDiv, String searchWord, String searchDiv2, String searchWord2) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.searchDiv2 = searchDiv2;
		this.searchWord2 = searchWord2;
	}

	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchDiv2() {
		return searchDiv2;
	}

	public void setSearchDiv2(String searchDiv2) {
		this.searchDiv2 = searchDiv2;
	}

	public String getSearchWord2() {
		return searchWord2;
	}

	public void setSearchWord2(String searchWord2) {
		this.searchWord2 = searchWord2;
	}

	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", searchDiv2=" + searchDiv2
				+ ", searchWord2=" + searchWord2 + ", toString()=" + super.toString() + "]";
	}


}
