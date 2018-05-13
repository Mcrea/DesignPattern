package singleton;

public class Client {

	public static void main(String[] args) {
		Singleton singleton = null;
		for (int i = 0;i < 10;i++) {
			singleton = Singleton.getIntance();
			//可以看到每一次输出的对象的地址是相同的。
			System.out.println(singleton);
		}

	}

}
