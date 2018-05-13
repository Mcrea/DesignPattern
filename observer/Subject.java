package observer;

/**
 * Subject主题接口
 */
public interface Subject {
	/**
	 * 登记观察者*/
    void registerObserver(Observer observer);
    /**
	 * 剔除观察者*/
    void cancelObserver(Observer observer);
    /**
	 * 广播信息*/
    void notifyObservers(Message message);
}