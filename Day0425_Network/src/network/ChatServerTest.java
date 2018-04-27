package network;



public class ChatServerTest {

	public static void main(String[] args) {
		Thread server = new Thread(new ChatServer(5000,5000));
		Thread mySender = new Thread(new UDPSenderThread());
		server.start();
		mySender.start();
	}

}
