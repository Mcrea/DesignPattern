package template;
/**
 * 希尔博拉斯级：加达里合众国重型突击巡洋舰之一，导弹平台，护盾防御*/
public class Cerberus extends HeavyAssaultCruiser {

	@Override
	protected void entrance() {
		System.out.println("所有人过星门后舰队长带跳至目标位置，不要私自起跳跃迁。");

	}

	@Override
	protected void activeEquipment() {
		System.out.println("激活主动防御护盾和导弹加成装备。");

	}

	@Override
	protected void aroundCommand() {
		System.out.println("环绕舰队长500m");

	}

	@Override
	protected void fire() {
		System.out.println("锁定舰队长指定目标，开火");

	}

}
