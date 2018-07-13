//package controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//public class MyHandler extends TextWebSocketHandler {
//	//클라이언트당 하나의 WebSocketSession
//	//다른 클라이언트에 메시지 전달하기 위해서 클라이언트의 WebSocketSession을 리스트로 관리
//	
//	private List<WebSocketSession> connectedUser;
//	private Map<String, WebSocketSession> usersMap;
//	public MyHandler() {
//		connectedUser = new ArrayList<WebSocketSession>();
//		usersMap = new HashMap<String, WebSocketSession>();
//	}
//	
//	//연결요청 처리 , 메시지 받기, 메시지 전달 
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		System.out.println("TextWebSocketHandler : 연결 종료" );
//		System.out.println("status:" + status );
//		System.out.println(usersMap);
//		//연결이 끊기면 session 삭제
//		connectedUser.remove(session);
//	}
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		System.out.println("TextWebSocketHandler : 연결 생성");
//		//연결할 때마다 session 저장
//		connectedUser.add(session);
//			
//	}
//
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		System.out.println("TextWebSocketHandler : 메시지 받음");
//		System.out.println("Payload:" + message.getPayload());
//		
//		JSONParser parser = new JSONParser();
//		JSONObject json = (JSONObject)parser.parse(message.getPayload());
//		
//		if(json.get("type")!=null && json.get("type").equals("register")) {
//			//사용자등록: 사용자가 보낸 id랑 session 짝궁 맞춰주기
//			usersMap.put(json.get("memberid").toString(), session);
//		}else {
//			String targetUser = json.get("target").toString();
//			WebSocketSession targetSession = usersMap.get(targetUser);
//			if(targetSession != null) {					
//				targetSession.sendMessage(new TextMessage(json.get("message").toString()));
//			}
//		}
//		
//	}	
//}
//
//
//
//
//
