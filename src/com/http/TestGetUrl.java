package com.http;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 爬取url 
 * @author Administrator
 *
 */
public class TestGetUrl {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		TestGetUrl t = new TestGetUrl();
		//t.testUrl();
		t.testGetUrlByParm("http://music.baidu.com/song/10525914/download", ".mp3");
		//t.testGetUrlByParm("http://music.baidu.com/song/1008046/download", ".mp3");
		//t.testGetUrlByParm("http://music.baidu.com/song/7300733/download", ".mp3");
        //t.testHttp(); //http://music.baidu.com/song/7300733/download
	}
	
	/**
	 * 过的url下后缀名名为parm的链接
	 */
	//NBID=0DEFBC1D2548DC51C4656F9243E817BF:FG=1; Hm_lvt_d0ad46e4afeacf34cd12de4c9b553aa6=1386900253,1387157528,1387158476,1387173530; u_lo=0; u_id=; u_t=; bdshare_firstime=1386743904297; SFSSID=df994fc83ba6b496e571a699b308900a; SIGNIN_UC=70a2711cf1d3d9b1a82d2f87d633bd8a01371697155; H_PS_PSSID=4535_1445_4405_4262_4202_4450; Hm_lpvt_d0ad46e4afeacf34cd12de4c9b553aa6=1387182189; tracesrc=-1%7C%7C-1; u_vip=1; batch=1
	public void testGetUrlByParm(String url,String parm){
		Map<String, String> head = new HashMap<String, String>();
		Set<String> set = new HashSet<String>();
		Connection conn = Jsoup.connect(url);
		conn.cookie("Cookie", "	BAIDUID=447A19077A8C8BCFAC7A138A210EF4A0:FG=1; MCITY=-240%3A; BDUSS=RwMEM1and1SlA2YUg0aWp3dlZHSFBlbmRBa3piZ0hZZm9ZTnJEMUxTU0laa0pTQVFBQUFBJCQAAAAAAAAAAAEAAADKKvcWxua8o-bD5sMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIjZGlKI2RpSZE;");
		conn.timeout(5000);
		try {
			Document doc = conn.get();
			Elements a = doc.select("a[href~=.mp3]"); // 具有 href 属性的链接
			//Elements a = doc.select("a[href]"); // 具有 href 属性的链接
			System.out.println(1);
			for (Element e : a) {
				System.out.println(e.attr("href"));
				//set.add(e)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testUrl(){
		String url1 = "http://www.11816912.cn/music/101505.mp3";
		String u = "/data/music/file?link=http://zhangmenshiting.baidu.com/data2/music/10525915/105259141387184461128.mp3?xcode=69bee0bed75698cba0e58adaeb5dcbd60fb35909493b340e&song_id=10525914";
	    String ss = u.substring(u.indexOf("http"),u.length());
	    String ss2 = url1.substring(url1.indexOf("http"),url1.length());
	    System.out.println(ss);
	    System.out.println(ss2);
	}
	
	
	public void testHttp() throws ClientProtocolException, IOException{
		 File f = new File("c:\\word.html");  
		    Writer out = null;  
		    try{  
		        out= new FileWriter(f);  
		    }catch(IOException e){  
		        e.printStackTrace();  
		    }  
		String t = Request.Post("music.baidu.com/song/1299094/download?__o=%2Fsong%2F1299094").bodyForm(Form.form().add("mob",  "18779862686").build()).execute().returnContent().toString();  
		try{out.write(t);  
		}catch(IOException e){  
		    e.printStackTrace();  
		}  
		try{  
		    out.close();  
		}catch(IOException e){  
		    e.printStackTrace();  
		    }  
		System.out.println( t);  
		  
		System.out.println("============================================");  
		System.out.println(Request.Post("http://haoma.imobile.com.cn/index.php?mob=")  
		    .bodyForm(Form.form().add("mob",  "15926590042").build())  
		    .execute().returnContent());  
		  
		}  
}
