package guiChat3;

public class ServerTest {
	public static void main(String[] args) {
		ChatServer server = new ChatServer(8000);
		server.runServer();
	}
}
