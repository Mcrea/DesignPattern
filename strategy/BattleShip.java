public abstract class BattleShip{
    private Stealth stealthBehavior;
    public void jump(){
        System.out.println("jump drive active");
    };
    public void stealth(){
        this.stealthBehavior.active();
    }
    public void setStealthBehavior(Stealth stealthBehavior){
        this.stealthBehavior = stealthBehavior;
    }
}