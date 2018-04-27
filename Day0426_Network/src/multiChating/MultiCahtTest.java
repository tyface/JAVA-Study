package multiChating;

public class MultiCahtTest {
	public static void main(String[] args) {
		ChatServer chat = new ChatServer(5000);
		chat.runServer();
	}
}
