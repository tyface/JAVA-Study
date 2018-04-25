package network;

public class UDPThreadTest {
	public static void main(String[] args) {
//		Thread sender = new Thread(new UDPSenderThread2());
		Thread receiver = new Thread(new UDPReceiverThread2());
		
//		sender.start();
		receiver.start();
	}
}
