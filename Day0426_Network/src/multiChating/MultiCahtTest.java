package multiChating;

public class MultiCahtTest {
	public static void main(String[] args) {
		ChatServer server = new ChatServer(5000);
		server.runServer();
	}
}
