/**
 * Subject
 */
public interface Subject {
    void registerObserver(Observer observer);
    void cancelObserver(Observer observer);
    void notifyObservers(Message,message);
}