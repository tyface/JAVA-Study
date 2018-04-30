package guiChat;

public class ServerTest {
	public static void main(String[] args) {
		ChatServer server = new ChatServer(8000);
		server.runServer();
	}
}
