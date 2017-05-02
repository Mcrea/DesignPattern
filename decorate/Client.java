package decorate;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BattleShip tempest = new Tempest();
		System.out.println("我是一条"+tempest.getDescription()+"，造价"+tempest.getCost());
		tempest = new NOS(tempest);
		System.out.println("我是一条"+tempest.getDescription()+"，造价"+tempest.getCost());
		tempest = new Wrap(tempest);
		System.out.println("我是一条"+tempest.getDescription()+"，造价"+tempest.getCost());
	}

}
