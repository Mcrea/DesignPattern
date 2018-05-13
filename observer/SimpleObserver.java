package observer;

/**
 * SimpleObserver implements Observer
 */
public class SimpleObserver implements Observer {
    private String name;
    //simpleSubject可以上移至父类，便于实现多态observer
    private Subject simpleSubject;
    public SimpleObserver(Subject subject, String name){
        this.simpleSubject = subject;
        this.name = name;
        this.register();
    }
    @Override
    public void register(){
        this.simpleSubject.registerObserver(this);
    };
    @Override
    public void logout(){
        this.simpleSubject.cancelObserver(this);
    };
    @Override
    public void update(Message message){
        System.out.println(this.name + "监听到了" + message.toString());
    };
}