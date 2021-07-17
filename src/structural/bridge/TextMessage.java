package structural.bridge;

public class TextMessage implements Message {
    private MessageSender sender;

    public TextMessage(MessageSender sender) {
        this.sender = sender;
    }

    @Override
    public String getBody() {
        return "Text message body";
    }

    @Override
    public String getHeader() {
        return "Text message header";
    }

    @Override
    public void sendMessage() {
        sender.sendMessage(this);
    }
}
