package strategy;

public class Panther extends BattleShip{
	private String name = "PANTHER";

	@Override
	protected String getName() {
		return this.name + " and who is dad";
	}
	@Override
	public void activeStealth(){
		System.out.println("panther active its stealth device while jumping");
        super.activeStealth();
    }
    
}