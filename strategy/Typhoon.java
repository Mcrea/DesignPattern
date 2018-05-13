package strategy;

public class Typhoon extends BattleShip{
	private String name = "TYPHOON";

	@Override
	protected String getName() {
		return this.name;
	}
	@Override
	public void activeStealth(){
		System.out.println("typhoon active its stealth device after jump");
        super.activeStealth();
    }
    
}