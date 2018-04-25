package network;

public class UDPThreadTest {
	public static void main(String[] args) {
		Thread sender = new Thread(new UDPSenderThread());
		Thread receiver = new Thread(new UDPReceiverThread());
		
		sender.start();
		receiver.start();
	}
}
