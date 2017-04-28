public class Client{
    public static void main(String[] args) {
        Subject simpleSubject = new SimpleSubject();
        Observer observer1 = new SimpleObserver(simpleSubject,"observer1");
        Observer observer2 = new SimpleObserver(simpleSubject,"observer2");
        simpleSubject.notifyObservers(new Message("Alex","Michael"));
    }
}