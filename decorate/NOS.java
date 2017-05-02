package decorate;

public class NOS extends Decorate implements BattleShip{
	public NOS (BattleShip bs) {
		super.setBs(bs);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "拥有毁电能力的"+super.getBs().getDescription();
	}

	@Override
	public float getCost() {
		// TODO Auto-generated method stub
		return 0.1F+super.getBs().getCost();
	}
}
