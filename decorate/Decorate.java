package decorate;
/**
 * 提供一个存储被装饰对象的容器及其get/set方法。*/
public class Decorate {
	private BattleShip bs;

	public BattleShip getBs() {
		return this.bs;
	}

	public void setBs(BattleShip bs) {
		this.bs = bs;
	}

}
