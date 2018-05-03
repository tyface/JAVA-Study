//package guiChatEx;
//
//import java.io.EOFException;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.SocketException;
//import java.util.ConcurrentModificationException;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.Vector;
//
//public class ServerTread extends Thread{
//	// 멀티 채팅 서버
//	ObjectOutputStream out = null;
//	ObjectOutputStream tmpOut = null;
//	ObjectInputStream in = null; // 리더
//	Map<String, Object> dataMap;
//	Protocol ptc;
//	Iterator<ObjectOutputStream> it; // socketSet 모든 값에 접근하기위한 Iterator객체변수
//	try {
//
//		out = new ObjectOutputStream(socket.getOutputStream());
//		in = new ObjectInputStream(socket.getInputStream());
//
//		ptc = new Protocol();
//		ptc.setType("#conn");
//
//		dataMap = new HashMap<String, Object>();
//		dataMap.put("msg", "< 채팅서버에 접속 하셨습니다 >");
//		ptc.setData(dataMap);
//		
//		out.writeObject(ptc);
//		out.flush();
//		
//		while (true) {
//			// 접속자의 메세지를 읽어오는 리더생성
//
//			ptc = (Protocol) in.readObject();
//
//			switch (ptc.getType()) {
//			case "#join":
//				System.out.println("#join");
//				System.out.println(out);
//				ptc = join((Account) ptc.getData("join"));
//
//				out.writeObject(ptc);
//				out.flush();
//				out.reset();
//				break;
//			case "#sign":
//				System.out.println("#sign");
//				System.out.println(out);
//				ptc = sign((Account) ptc.getData("sign"), out);
//				sendOnlineList();
//				out.writeObject(ptc);
//				out.flush();
//				out.reset();
//				break;
//			case "#msg":
//				Protocol outPtc = new Protocol();
//				it = onlineUserList.keySet().iterator(); // socketSet을 Iterator로 변환
//				// Iterator 객체를 사용하는동안 변동이 없게하기위한 synchronized
//				synchronized (it) { // TODO 확실하게 필요한지 잘 모르겠음..
//
//					while (it.hasNext()) {
//						tmpOut = it.next(); // 소켓 객체를 임시변수에 삽입
//						if (tmpOut == out) { // 메세지를 보낼때 접속자 본인에게는 메세지를 보내지 않게하기위한 조건문
//							continue;
//						}
//						dataMap = new HashMap<String, Object>();
//						dataMap.put("msg", onlineUserList.get(out) + " : " + ptc.getData("msg"));
//						outPtc.setType("#msg");
//						outPtc.setData(dataMap);
//
//						tmpOut.writeObject(outPtc);
//						tmpOut.flush();
//						tmpOut.reset();
//					}
//				}
//				break;
//			case "#exit":
//				System.out.println("#exit");
//				System.out.println(out);
//				onlineUserList.remove(out);
//				System.out.println("소켓 종료 : " + socket);
//				socketSet.remove(socket); // socketSet에서 소켓 삭제
//				System.out.println("현제 인원 : " + onlineUserList.size());
//				socket.close();
//				sendOnlineList();
//				break;
//			default:
//				System.out.println("default");
//				break;
//			}
//
//		}
//	} catch (SocketException e) {
//	} catch (EOFException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	} catch (ConcurrentModificationException e) {
//		System.out.println("리스트 변경 오류");
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} finally {
//		try {
//			if (socket != null) {
//				System.out.println("finally");
//				onlineUserList.remove(out);
//				System.out.println("소켓 종료 : " + socket);
//				socketSet.remove(socket); // socketSet에서 소켓 삭제
//				System.out.println("현제 인원 : " + onlineUserList.size());
//				socket.close();
//				sendOnlineList();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
