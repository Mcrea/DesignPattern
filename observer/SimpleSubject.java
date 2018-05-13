package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleSubject implements Subject
 */
public class SimpleSubject implements Subject {
	//observerList也可以上移至父类，因为主题类必须要有一个指向observer列表的引用。
    private List<Observer> observerList = new ArrayList<Observer>();
    @Override
    public void registerObserver(Observer observer){
        this.observerList.add(observer);
    };
    @Override
    public void cancelObserver(Observer observer){
        int i = this.observerList.indexOf(observer);
        if (i > 0){
            this.observerList.remove(observer);
        }
    }
    @Override
    public void notifyObservers(Message message){
        for (Observer observer : observerList){
            observer.update(message);
        }
    }
}