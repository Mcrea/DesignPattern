package template;

public class Client {

	public static void main(String[] args) {
		System.out.println("小希舰队");
		HeavyAssaultCruiser hac = new Cerberus();
		hac.decisiveBattle();
		System.out.println("银鹰舰队");
		hac = new Eagle();
		hac.decisiveBattle();
		System.out.println("伊什塔舰队");
		hac = new Ishtar();
		hac.decisiveBattle();

	}
}
