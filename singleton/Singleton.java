package singleton;
/**
 * 单例类*/
public class Singleton {
	//饿汉式加载，虽然占用了资源，但是避免了线程安全的问题。
	private static Singleton singleton = new Singleton();
	/**
	 * 在不考虑反射的情况下，禁止其他地方的代码执行构造函数*/
	private Singleton() {
		
	}
	/**
	 * 获取单例对象的方法*/
	public static Singleton getIntance() {
		return singleton;
	}
	

}
