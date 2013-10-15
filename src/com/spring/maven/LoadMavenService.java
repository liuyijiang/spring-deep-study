package com.spring.maven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoadMavenService {

	private static final int CMD_SUCCESS = 0;
	private Set<String> successjar = new HashSet<String>();
    private static final String PACKING = ".jar";
	private static String filePath = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadMavenService serivce = new LoadMavenService();
		serivce.install();
	}

	public LoadMavenService(){
		//init(); //导入的时候打开
	}
	
	public void init(){
		String loadpath = LoadMavenService.class.getResource("/").getPath();
		filePath = loadpath.substring(0,loadpath.indexOf("y")+1) + "/WebContent/WEB-INF/lib/";
		initLoadCompleteJar();
	}
	
	public void install(){
		List<MavenBean> list = getCanInstallJar();
		if(list != null){
			for (MavenBean bean : list) {
				if(installIntoLocalMaven(bean)){
					System.out.println("导入成功");
					System.out.println("########################################");
				}
			}
		}
	}
	
	public List<MavenBean> getCanInstallJar(){
		List<MavenBean> list = new ArrayList<MavenBean>();
		File path = new File(filePath);
		File[] fileArray = path.listFiles();
		for(File file : fileArray){
			System.out.println("扫描到："+file.getName());
			String fileName = file.getName();
			String packaging = fileName.substring(fileName.lastIndexOf("."),fileName.length());
            if(PACKING.equals(packaging)){
            	if(!successjar.contains(fileName)){
            		MavenBean bean = new MavenBean();
            		bean.setGroupId("ati");
            		bean.setPackaging("jar");
            		bean.setFileName(fileName);
            		if(fileName.indexOf("-") != -1){
        				String version = fileName.substring(fileName.lastIndexOf("-")+1,fileName.lastIndexOf("."));
        				bean.setArtifactId(fileName.substring(0,fileName.lastIndexOf("-")));
        				bean.setVersion(version);
        			}else{
        				bean.setArtifactId(fileName.substring(0,fileName.lastIndexOf(".")));
        				bean.setVersion("1");
        			}
            		list.add(bean);
            	}else{
            		System.out.println("已经install到localmaven库");
            	}
            }else{
            	System.out.println("不是标准数据");
            }
			
		}
		return list;
	}
	
	public void initLoadCompleteJar(){
		try{
			String pathStr = filePath + "loadcompletejar.txt";
			System.out.println("载入install success jar:"+pathStr);
			File path = new File(pathStr);
			BufferedReader br = new BufferedReader(new FileReader(path));
			String file = null;
			while((file = br.readLine()) != null){
				successjar.add(file);
			}
			br.close();
			System.out.println("已经成功加载："+successjar.size()+" 个jar包");
		}catch(Exception e){
		   e.printStackTrace();	
		}
	}

	public void writeToFile(String fileName){
		try{
			String pathStr = filePath + "loadcompletejar.txt";
			File path = new File(pathStr);
			BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
			bw.write(fileName);
			bw.newLine();
			bw.close();
		}catch(Exception e){
			   e.printStackTrace();	
	    }
	}
	
	
	public boolean installIntoLocalMaven(MavenBean bean) {
		System.out.println("开始install jar");
		boolean success = false;
		String cmd = "cmd.exe /c mvn install:install-file -Dfile="+ filePath+bean.getFileName() +" -DgroupId="+ bean.getGroupId() +" -DartifactId="+ bean.getArtifactId() +" -Dversion="+ bean.getVersion() +" -Dpackaging=jar";
		System.out.println(cmd);
		try {
			Runtime run = Runtime.getRuntime();
			Process p = run.exec(cmd);
			int exitVal = p.waitFor();
			if (exitVal == CMD_SUCCESS) {
				writeToFile(bean.getFileName());
				success = true;
			}else{
				System.out.println("操作失败："+exitVal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public List<MavenBean> getLoadInstallJar(){
		List<MavenBean> list = new ArrayList<MavenBean>();
		try{
			String pathStr = "D://loadcompletejar.txt";
			File path = new File(pathStr);
			BufferedReader br = new BufferedReader(new FileReader(path));
			String fileName = null;
			while((fileName = br.readLine()) != null){
				MavenBean bean = new MavenBean();
        		bean.setGroupId("ati");
        		bean.setPackaging("jar");
        		bean.setFileName(fileName);
        		if(fileName.indexOf("-") != -1){
    				String version = fileName.substring(fileName.lastIndexOf("-")+1,fileName.lastIndexOf("."));
    				bean.setArtifactId(fileName.substring(0,fileName.lastIndexOf("-")));
    				bean.setVersion(version);
    			}else{
    				bean.setArtifactId(fileName.substring(0,fileName.lastIndexOf(".")));
    				bean.setVersion("1");
    			}
        		list.add(bean);
			}
			br.close();
		}catch(Exception e){
		   e.printStackTrace();	
		}
		return list;
	}
	
}
