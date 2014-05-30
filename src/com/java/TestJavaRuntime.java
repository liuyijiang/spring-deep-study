package com.java;

public class TestJavaRuntime {
   
    public static final String VOICE_TYPE_WAV = ".wav";
	
	public static final String VOICE_TYPE_MP3 = ".mp3";
	
	public static final String TYPE_SOX = "sox";
	
	public static final String TYPE_LAME = "lame";
	
	//将wav转换为MP3
	public int voiceTransform(String type,String fileName,String transformName){
		Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		try {  
			String cmd = createCmd(type,fileName,transformName);
			//System.out.println(cmd);
            Process p = run.exec(cmd);// 启动另一个进程来执行命令  
            if (p.waitFor() != 0) {
            	return p.exitValue();
            }
        } catch (Exception e) {  
            e.printStackTrace();
            return -1;
        }  
        return 0;
	}
	
	private String createCmd(String type,String fileName,String transformName){
		StringBuffer sb = new StringBuffer();
		if(TYPE_LAME.equals(type)){
			sb.append("lame -V2 " + fileName + " " + transformName);
		}else{
			sb.append("sox " + fileName + " -r 44100 -c 2 " + transformName);
		}
		return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime currRuntime = Runtime.getRuntime();
		int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);
        int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);
        int nMaxMemory = ( int ) (currRuntime.maxMemory() / 1024 / 1024);
        System.out.println(nFreeMemory+" _ "+nTotalMemory+" _ "+nMaxMemory);
	}

}
