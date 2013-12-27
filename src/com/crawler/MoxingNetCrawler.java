package com.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MoxingNetCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MoxingNetCrawler m = new MoxingNetCrawler();
		m.crawler();

	}

	public void crawler(){
		Connection conn = Jsoup.connect("http://www.moxing.net/");
		conn.timeout(5000);
		try {
			Document doc = conn.get();
			Elements e = doc.select("ul[class=text_list text_list_f14]"); //
			
			System.out.println(e);
			
			
		}catch(Exception e){
			
		}
	}
	
}
