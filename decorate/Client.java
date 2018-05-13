package decorate;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BattleShip tempest = new Tempest();
		iPrint(tempest);
		tempest = new NOS(tempest);
		iPrint(tempest);
		tempest = new Wrap(tempest);
		iPrint(tempest);
	}
	static void iPrint(BattleShip tempest) {
		System.out.println("我是一条" + tempest.getDescription() + "，造价" + tempest.getCost());
	}

}
