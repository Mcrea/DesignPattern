/**
 * SimpleObserver implements Observer
 */
public class SimpleObserver implements Observer {
    private String name;
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
        System.out.println(this.+"监听到了"+message.toString());
    };
}