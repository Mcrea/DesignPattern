package template;
/**
 * 重型突击巡洋舰是一种广泛应用于会战的舰种*/
public abstract class HeavyAssaultCruiser {
	//定义基本流程
	public final void decisiveBattle() {
		this.entrance();
		this.activeEquipment();
		this.aroundCommand();
		this.fire();
		System.out.println("是非成败转头空，一壶浊酒喜相逢~");
	}
	/**舰队入场*/
	protected abstract void entrance();
	/**激活主动装备*/
	protected abstract void activeEquipment();
	/**跟随舰队长走位*/
	protected abstract void aroundCommand();
	/**集火目标*/
	protected abstract void fire();

}
