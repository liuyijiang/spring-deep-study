package com.spring.fileupload.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

@Service
public class FileUploadService {

	public void uploadFile(InputStream inputStream,String name){
		BufferedOutputStream out = null;
		try{
			String realPath = "D://"+name + ".png";
			File uploadFile = new File(realPath);
			byte[] bit = new byte[1024] ;
			int len = -1;
			out = new BufferedOutputStream(new FileOutputStream(uploadFile));
			while((len = inputStream.read(bit)) != -1){
				out.write(bit,0,len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
