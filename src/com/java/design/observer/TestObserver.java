package com.java.design.observer;
import java.util.Observable;
import java.util.Observer;
/**
 * 测试java 设计模式之观察者模式
 * 在Java中通过Observable类和Observer接口实现了观察者模式。Observer对象是观察者，Observable对象是被观察者。
 * @author Administrator
 * 
 * 实例：
 * 比如像当当网、京东商城一类的电子商务网站，如果你对某件商品比较关注，可以放到收藏架，那么当该商品降价时，
 * 系统给您发送手机短信或邮件。这就是观察者模式的一个典型应用，商品是被观察者，有的叫主体；关注该商品的客户就是观察者。
 */
public class TestObserver {

	/**
	 * 观察者模式是对象的行为模式，又叫发布-订阅(Publish/Subscribe)模式、模型-视图(Model/View)模式、源-监听器(Source/Listener)模式或从属者(Dependents)模式。
	 */
	public static void main(String[] args) {
		TestObserver t = new TestObserver();
		t.test();
	}

	public void test(){
		try{
        	MyObservable my = new MyObservable();//被观察者
        	my.addObserver(new MyObserver());
        	my.addObserver(new MyUseArgObserver());
        	my.setData(2);
        	Thread.sleep(1000);
        	my.setData(22);
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	public class MyObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			MyObservable m = (MyObservable) o;
			System.out.println("arg: "+arg);
			System.out.println(m.getData());
			
		}
		
	}
	
	public class MyUseArgObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			if("ok".equals( arg.toString())){
				System.out.println("**************ok");
			}
			MyObservable m = (MyObservable) o;
			System.out.println("arg: "+arg);
			System.out.println(m.getData());
			
		}
		
	}
	
	public class MyObservable extends Observable {
		
		private int data = 0;

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
			setChanged();
			//notifyObservers();//不带参数
			notifyObservers("ok");//带参数
		}
		
		
	}
	
}
