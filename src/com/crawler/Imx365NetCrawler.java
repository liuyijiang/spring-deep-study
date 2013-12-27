package com.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 爬取 http://www.imx365.net 数据
 * http://www.imx365.net/bbs/thread-7-204656-1-1.html
 * @author Administrator
 *
 */
public class Imx365NetCrawler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Imx365NetCrawler imx = new Imx365NetCrawler();
		imx.crawler();
	}
	
	
	public void crawler(){
		Connection conn = Jsoup.connect("http://www.imx365.net/bbs/thread-7-204656-1-1.html");
		conn.timeout(5000);
		try {
			Document doc = conn.get();
			System.out.println(doc);
//			Elements e = doc.select("ul[class=text_list text_list_f14]"); //
//			
//			System.out.println(e);
			
			
		}catch(Exception e){
			
		}
	}
	

}
