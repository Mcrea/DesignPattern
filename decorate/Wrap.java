package decorate;

public class Wrap extends Decorate implements BattleShip{
	public Wrap (BattleShip bs) {
		super.setBs(bs);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "拥有恐怖限制敌方速度能力的"+super.getBs().getDescription();
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return 0.1F+super.getBs().getCost();
	}
}
