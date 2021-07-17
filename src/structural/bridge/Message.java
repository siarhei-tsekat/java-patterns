package structural.bridge;

public interface Message {
    String getBody();

    String getHeader();

    void sendMessage();
}
