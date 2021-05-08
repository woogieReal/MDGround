package com.sist.feb.cmn;

public class MDTest {

    public static void main(String[] args) {
    	
    	String parseStr = MDParser.parserFromMD("This is *Sparta* <p>이건?</p>");
    	System.out.println("parser result: "+parseStr);
    	
    }

}
