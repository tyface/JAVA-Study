package network;

public class ChatServerTest {

	public static void main(String[] args) {
		ChatServer server = new ChatServer(5000);
		server.runServer();
	}

}
