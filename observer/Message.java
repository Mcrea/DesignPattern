package observer;

/**
 * Message
 */
public class Message {
    private String head;
    private String body;
    public Message(String head, String body){
        this.head = head;
        this.body = body;
    }
    //返回json格式的数据
    @Override
    public String toString(){
        return "{head:" + this.head + ",body:" + this.body +"}";
    }
}