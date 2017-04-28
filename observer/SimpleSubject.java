/**
 * SimpleSubject implements Subject
 */
public class SimpleSubject implements Subject {
    private List<Observer> observerList = new ArrayList<Observer>();
    @Override
    public void registerObserver(Observer observer){
        this.observerList.add(observer);
    };
    @Override
    public void cancelObserver(Observer observer){
        int i = this.observerList.indexOf(observer);
        if( i > 0 ){
            this.observerList.remove(observer);
        }
    };
    @Override
    public void notifyObservers(Message,message){
        for( Observer observer:observerList ){
            observer.update(message);
        }
    };
}