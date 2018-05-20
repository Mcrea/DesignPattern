package template;
/**
 * 伊什塔级：盖伦特联邦重型突击巡洋舰，无人机平台，装甲防御*/
public class Ishtar extends HeavyAssaultCruiser {

	@Override
	protected void entrance() {
		System.out.println("所有人过星门后舰队长带跳至目标位置，不要私自起跳跃迁。");

	}

	@Override
	protected void activeEquipment() {
		System.out.println("施放无人机，协助指定集火点名官，激活主动防御装甲和无人机加成装备。");

	}

	@Override
	protected void aroundCommand() {
		System.out.println("环绕舰队长500m");

	}

	@Override
	protected void fire() {
		System.out.println("无人机已协助点名官，看着点名官指挥就好。不需要任何操作");

	}

}
