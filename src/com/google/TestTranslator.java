package com.google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestTranslator {
	
	protected static final String URL_TEMPLATE = "http://translate.google.com/?langpair={0}&text={1}";
	protected static final String CHINA = "zh-CN"; // 簡中
	protected static final String ENGLISH = "en"; // 英
	protected static final String JAPAN = "ja"; // 日 "ru" 俄罗斯
	
	
	protected static final String ENCODING = "UTF-8";
	protected static final String ID_RESULTBOX = "result_box";
	
	/**
	 * 阿斯科尔德号（Askold），
	特维赞号（Retvisan），
	切萨列维奇号（即太子号，Cesarevic）
	保雅林号（Bojarin），
	诺瓦克号（Novik）
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String txt = "1/700 Russian Armored Cruiser Askold (White Ensign Models)";
		String ss = TranslatorUtil.translator(TranslatorUtil.TranslatorType.ENGLISH, txt);
        System.out.println(ss);
        TranslatorUtil.professionalTranslator(ss);
	}
	
   //
}
