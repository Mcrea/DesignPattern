/**
 * Message
 */
public class Message {
    private String head;
    private String body;
    public Message (String head,String body) {
        this.head = head;
        this.body = body;
    }
    public String toString(){
        return "{head:"+this.head+",body:"+this.body+"}";
    }
}