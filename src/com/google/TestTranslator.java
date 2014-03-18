package com.google;

import java.util.HashMap;
import java.util.Map;


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
	威特格夫特中将带领着旗舰太子号(Tsesarevich) 列特维山号(Retvisan)  佩列斯维特号(Peresviet)胜利号(Pobieda)波尔塔瓦号(Poltava)和塞瓦斯托波尔号(Sevastopol)这六艘战列舰还有...
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String txt = " Прошлогодняя новинка китайской фирмы. Собиралась почти без доработок. Были проблемы по стыковке, но некритичные.Основные стойки шасси укорочены на ~2,5мм, добавлены шланги гидравлики.Посадочные фары - Эльф.Крыльевые АНО - Хобби+."
//     +" Краски - Mr.Color. Серый цвет взят готовый, С308, с лёгким осветлением. Серо-зелёный намешан из С306 и зелёного, с добавлением капли синего."
//    +"Окраска сопел - AlcladII и Акан серии 6хххх."
//    +"Глянцевый лак - Future, матовый - акрил Tamiya."
//    +"Декали - Бегемот."
//    +"Огромная благодарность Тимуру Таратухину за фотосессию модели!";
		//String txt = " Прошлогодняя новинка китайской фирмы. Собиралась почти без доработок. Были проблемы по стыковке, но некритичные.Основные стойки шасси укорочены на ~2,5мм, добавлены шланги гидравлики.Посадочные фары - Эльф.Крыльевые АНО - Хобби+.Краски - Mr.Color. Серый цвет взят готовый, С308, с лёгким осветлением. Серо-зелёный намешан из С306 и зелёного, с добавлением капли синего.";
		
		String txt = "DD-658 USS Colahan ";
		//String txt = "SMS Baden (1918)";
		//String txt = "HMCS Calgary K231 ca 1942";
		String sss[] = txt.split(" ");
		Map<String,String> zy = new HashMap<String,String>();
		zy.put("sms", "德意志第二帝国海军");
		zy.put("tsessarevich", "太子号");
		StringBuffer sb = new StringBuffer();
		for(String s : sss){
			String t = zy.get(s.toLowerCase());
			if(t != null){
				sb.append(t + " ");
			}else{
				sb.append(TranslatorUtil.translator(TranslatorUtil.TranslatorType.ENGLISH, s)+ " ");
			}
		}
		System.out.println(sb.toString());
		
		
//		String ss = TranslatorUtil.translator(TranslatorUtil.TranslatorType.ENGLISH, txt);
//        System.out.println(ss);
//        String s2 = TranslatorUtil.professionalTranslator(ss);
//        System.out.println(s2);
	}
	
   //
}
