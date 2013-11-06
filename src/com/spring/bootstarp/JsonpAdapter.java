package com.spring.bootstarp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

public class JsonpAdapter extends MappingJacksonHttpMessageConverter{
  
	
	@Override  
    protected void writeInternal(Object o, HttpOutputMessage outputMessage)  
            throws IOException, HttpMessageNotWritableException {  
        super.writeInternal(o, outputMessage);  
    }  
	
}
