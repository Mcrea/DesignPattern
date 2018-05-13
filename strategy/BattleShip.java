package strategy;
/**战列舰父类
 * 使用继承的基本原则是：实现多态而非共享内存*/
public abstract class BattleShip{
    private Stealth stealthBehavior;
    /**
     * 启动跃迁引擎*/
    public void jump(){
        System.out.println(this.getName() + " jump drive active");
    };
    /**
     * 激活隐身装置*/
    public void activeStealth(){
        this.stealthBehavior.active();
    }
    public void setStealthBehavior(Stealth stealthBehavior){
        this.stealthBehavior = stealthBehavior;
    }
    protected abstract String getName();
}