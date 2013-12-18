package com.ftp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 测试使用ftp 上传下载文件 使用commons-net-3.3.jar ftp ubuntu搭建查看ftp.txt
 * 
 * @author Administrator
 * 
 */
public class TestFtp {

	private static final String HOST = "192.168.2.232";
	private FTPClient ftp = new FTPClient();
    private static final String LOACL_DIR = "D://";
	
	public static void main(String[] args) {
		TestFtp f = new TestFtp();
		// f.testFTPUpload("D://color.txt", "color.txt", "ting", "123");//成功
		//f.testFTPUploadFromString("刘一江的111", "document.txt", "ting", "123");// 成功
		f.testFTPDownload("liuyijiang.jpg", "color.jpg", "ting", "123");// 成功
		
	}

	/**
	 * ftp上传文件
	 * 
	 * @param file
	 *            本地文件路径
	 * @param ftpfileName
	 *            上传到ftp服务器文件名
	 * @param username
	 * @param passwrod
	 */
	public void testFTPUpload(String file, String ftpfileName, String username,
			String passwrod) {
		try {
			FileInputStream in = new FileInputStream(new File(file));
			ftp.connect(HOST);// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) { // 连接错误的时候报错
				ftp.disconnect();
			}
			showState();
			ftp.login(username, passwrod);// 登录
			showState();
			ftp.setFileType(FTP.BINARY_FILE_TYPE);// 设置传输文件类型
			ftp.setControlEncoding("utf8");// 设置字符集，可能会帮助你解决远程服务器上中文文件名的问题
			ftp.changeWorkingDirectory("/home/ting/ftp/");// 切换文件夹
															// 这个文件必须是登录用户可读性的
			showState();
			ftp.enterLocalPassiveMode();//不加上这句，碰到有些ftp服务器还真的不能列取服务器上的文件名. 而且提示你connection reset。
			ftp.storeFile(ftpfileName, in);
			showState();
			in.close();
			ftp.logout();
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在ftp服务器上生成一个文件
	 * 
	 * @param txt
	 *            文件的内容
	 * @param ftpfileName
	 *            上传到ftp服务器文件名
	 * @param username
	 * @param passwrod
	 */
	public void testFTPUploadFromString(String txt, String ftpfileName,
			String username, String passwrod) {
		try {
			InputStream in = new ByteArrayInputStream(txt.getBytes("utf-8"));
			ftp.connect(HOST);// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) { // 连接错误的时候报错
				ftp.disconnect();
			}
			showState();
			ftp.login(username, passwrod);// 登录
			showState();
			ftp.setFileType(FTP.BINARY_FILE_TYPE);// 设置传输文件类型
			ftp.setControlEncoding("utf8");// 设置字符集，可能会帮助你解决远程服务器上中文文件名的问题
			ftp.changeWorkingDirectory("/home/ting/ftp/");// 切换文件夹
															// 这个文件必须是登录用户可读性的
			showState();
			ftp.enterLocalPassiveMode();//不加上这句，碰到有些ftp服务器还真的不能列取服务器上的文件名. 而且提示你connection reset。
			ftp.storeFile(ftpfileName, in);
			showState();
			in.close();
			ftp.logout();
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从ftp上下载文件
	 * @param file 保存到本地的文件名
	 * @param ftpfileName ftp上文件名
	 * @param username
	 * @param passwrod
	 */
	public void testFTPDownload(String file, String ftpfileName,
			String username, String passwrod) {
		try {
			ftp.connect(HOST);// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) { // 连接错误的时候报错
				ftp.disconnect();
			}
			showState();
			ftp.login(username, passwrod);// 登录
			showState();
			ftp.setControlEncoding("utf8");// 设置字符集，可能会帮助你解决远程服务器上中文文件名的问题
			ftp.changeWorkingDirectory("/home/ting/ftp/");// 切换文件夹
			ftp.enterLocalPassiveMode();//不加上这句，碰到有些ftp服务器还真的不能列取服务器上的文件名. 而且提示你connection reset。
			FTPFile[] fs = ftp.listFiles();  
			for(FTPFile f : fs){
				//System.out.println(f.getName());
				 if(f.getName().equals(ftpfileName)){  //ftp上文件名
		                File localFile = new File(LOACL_DIR+file);  
		                OutputStream is = new FileOutputStream(localFile);   
		                ftp.retrieveFile(f.getName(), is);  
		                is.close();  
		            }  
			}
			ftp.logout();  
			if (ftp.isConnected()) {
				ftp.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 显示状态
	 */
	private void showState() {
		int reply = ftp.getReplyCode();// 获得ftp状态码
		System.out.println("ftp状态码 ：" + reply);
	}
}
