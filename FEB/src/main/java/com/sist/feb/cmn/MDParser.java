package com.sist.feb.cmn;

import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MDParser {

	public static String parserFromMD(String MDStr) {
		MutableDataSet options = new MutableDataSet();
		
		Parser parser = Parser.builder(options).build();
	    HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		
	    Node document = parser.parse(MDStr); 
	    String html = renderer.render(document);
	     
		return html;
	}
	
}
