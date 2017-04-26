public class Client{
	public static void main(String[] args) {
	    BattleShip typhoon = new Typhoon();
	    BattleShip panther = new Panther();
	    typhoon.setStealthBehavior(new OrdinaryStealth());
	    panther.setStealthBehavior(new CovertActionDevice());
	    typhoon.jump();
	    panther.jump();
	    System.out.println("panther active its stealth device while jumping ");
	    panther.stealth();
	    System.out.println("both of them reach destination");
	    System.out.println("typhoon active its stealth device after jump ");
	    typhoon.stealth();
	    System.out.println("obviously,panther detects typhoon and typhoon detects nothing");
	}
}
