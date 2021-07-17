package structural.bridge;

public class MessageSenderImpl implements MessageSender {
    @Override
    public void sendMessage(Message message) {
        System.out.println("sending message with header: " + message.getHeader() + ". with body: " + message.getBody());
    }
}
