package decorate;
/**经典装饰类，可无限装饰下去*/
public class NOS extends Decorate implements BattleShip{
	public NOS (BattleShip bs) {
		super.setBs(bs);
	}

	@Override
	public String getDescription() {
		return "拥有毁电能力的" + super.getBs().getDescription();
	}

	@Override
	public float getCost() {
		return 0.1F + super.getBs().getCost();
	}
}
