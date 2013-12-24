package com.util;

import java.util.Date;

import net.sf.cglib.beans.BeanMap;

import com.model.Ship;
import com.util.function.Tuple2;


public class BeanUtil {

	/**
	 * 查找 old 中为空， new 中存在 的字段 填充新字段
	 * @param beanOld
	 * @param beanNew
	 * @param out
	 * @return <Boolean： 是否有新字段； T:新填充对象>
	 */
	public static <T> Tuple2<Boolean, T> fillNullColumn(T beanOld, T beanNew, T out) {
		BeanMap oldMap = BeanMap.create(beanOld);
		BeanMap newMap = BeanMap.create(beanNew);
		BeanMap outMap = BeanMap.create(out);
		int count = 0;
		for (Object key : newMap.keySet()) {
			Object value = newMap.get(key);
			if (value != null && oldMap.get(key) == null) {
				outMap.put(key, value);
				count++;
			}
		}
		return Tuple2.create(count > 0, out);
	}
	
    public static void main(String[] args) {
//		Ship ship1 = new Ship();
//		Ship ship2 = new Ship();
    	Ship ship1 = new Ship();
    	ship1.setCreate(new Date());
    	ship1.setId(2);
    	ship1.setName("kkis");
    	BeanMap map = BeanMap.create(ship1);
    	System.out.println(1);
    	map.put("sex", "female");//放不进去
    	Object obj = map.getBean();
    	System.out.println(2);
	}
}
