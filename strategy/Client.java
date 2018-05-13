package strategy;

public class Client{
	public static void main(String[] args) {
	    BattleShip typhoon = new Typhoon();
	    BattleShip panther = new Panther();
	    typhoon.setStealthBehavior(new OrdinaryStealth());
	    panther.setStealthBehavior(new CovertActionDevice());
	    typhoon.jump();
	    panther.jump();
	    panther.activeStealth();
	    System.out.println("both of them reach destination");
	    typhoon.activeStealth();
	    System.out.println("obviously,panther detects typhoon and typhoon detects nothing");
	}
}
