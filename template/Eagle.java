package template;
/**
 * 银鹰级：加达里合众国重型突击巡洋舰之一，混合炮平台，护盾防御*/
public class Eagle extends HeavyAssaultCruiser {

	@Override
	protected void entrance() {
		System.out.println("所有人与泰坦保持距离1000m待命，等泰坦开启跃迁通道后立即起跳。");

	}

	@Override
	protected void activeEquipment() {
		System.out.println("激活主动防御护盾装备");

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
