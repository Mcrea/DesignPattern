package observer;

public class Client{
    public static void main(String[] args) {
        Subject simpleSubject = new SimpleSubject();
        new SimpleObserver(simpleSubject, "observer1");
        new SimpleObserver(simpleSubject, "observer2");
        simpleSubject.notifyObservers(new Message("Alex", "Michael"));
    }
}