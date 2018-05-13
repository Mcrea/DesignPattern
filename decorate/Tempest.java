package decorate;
/**
 * 实现BattleShip接口的类，这是一个基础的类，之后的类都是在此类的基础上进行方法装饰*/
public class Tempest implements BattleShip {

	private String description = "狂暴级战列舰";
	private float cost = 6.5F;
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public float getCost() {
		return this.cost;
	}

}
