package structural.bridge;

public class EmailMessage implements Message {

    private MessageSender sender;

    public EmailMessage(MessageSender sender) {
        this.sender = sender;
    }

    @Override
    public String getBody() {
        return "Email message body";
    }

    @Override
    public String getHeader() {
        return "Email message header";
    }

    public void sendMessage() {
        sender.sendMessage(this);
    }
}
