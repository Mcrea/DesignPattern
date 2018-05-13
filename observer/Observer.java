package observer;

/**
 * Observer接口
 */
public interface Observer {
	/**
	 * 订阅*/
    void register();
    /**
	 * 退订*/
    void logout();
    /**
	 * 处理广播信息*/
    void update(Message message);
}