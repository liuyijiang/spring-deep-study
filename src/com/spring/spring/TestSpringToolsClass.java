package com.spring.spring;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/**
 * 测试spring中的工具类
 * @author Administrator
 *
 */
public class TestSpringToolsClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSpringToolsClass t = new TestSpringToolsClass();
		t.fileLoad();
	}

	/**
	 *     通过 FileSystemResource 以文件系统绝对路径的方式进行访问；
     *     通过 ClassPathResource 以类路径的方式进行访问；
     *     通过 ServletContextResource 以相对于 Web 应用根目录的方式进行访问。
	 */
	public void fileLoad(){
		Resource re = new FileSystemResource("E:\\wenhao.png");
		 //InputStream ins1 = re.getInputStream(); 
		//re.get
         System.out.println("res1:"+re.getFilename()); 
	}
	
//	public void fileCpoy(){
//		Resource res = new ClassPathResource("conf/file1.txt"); 
//        // ① 将文件内容拷贝到一个 byte[] 中
//        byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile()); 
//        // ② 将文件内容拷贝到一个 String 中
//        String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile())); 
//        // ③ 将文件内容拷贝到另一个目标文件
//        FileCopyUtils.copy(res.getFile(), 
//        new File(res.getFile().getParent()+ "/file2.txt")); 
//
//        // ④ 将文件内容拷贝到一个输出流中
//        OutputStream os = new ByteArrayOutputStream(); 
//        FileCopyUtils.copy(res.getInputStream(), os); 
//	}
}
