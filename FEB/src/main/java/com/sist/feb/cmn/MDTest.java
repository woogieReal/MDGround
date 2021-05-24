package com.sist.feb.cmn;

public class MDTest {

    public static void main(String[] args) {
    	
    	String parseStr = MDParser.parserFromMD("This is *Sparta* ```요기```");
    	System.out.println("parser result: "+parseStr);
    	
    }

}
