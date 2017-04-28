/**
 * Observer
 */
public interface Observer {
    void register();
    void logout();
    void update(Message message);
}