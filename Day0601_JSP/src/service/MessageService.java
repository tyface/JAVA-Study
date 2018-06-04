package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MessageDao;
import model.Message;

public class MessageService {
	// Dao 객체를 멤버로 가지면서 사용
	private MessageDao dao;
	private static MessageService INSTANCE;
	// 한페이지에 표시될 메시지의 개수
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	// 한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 5;

	private MessageService() {
		dao = MessageDao.getInstance();
	}

	public static MessageService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MessageService();
		}
		return INSTANCE;
	}

	public int writeMessage(Message message) {
		return dao.insertMessage(message);
	}

	// public boolean modify(Message message) {
	//
	// if(dao.updateMessage(message)>0) {
	// return true;
	// }
	// return false;
	// }

	public boolean removeMessage(int id, String pw) {

		if (!dao.selectOne(id).getPw().equals(pw)) {
			return false;
		}
		dao.deleteMessage(id);
		return true;
	}

	public Message getMessage(int id) {

		return dao.selectOne(id);
	}

	public List<Message> getAllMessages() {

		return dao.selectAll();
	}

	public Map<String, Object> getMessageList(int pageNum) {

		int firstRow = (pageNum - 1) * NUM_OF_MESSAGE_PER_PAGE + 1;
		int endRow = pageNum * NUM_OF_MESSAGE_PER_PAGE;
		int totalCount = dao.selectCount();

		Map<String, Object> viewData = new HashMap<String, Object>();
		viewData.put("messageList", dao.selectBetween(firstRow, endRow));
		viewData.put("lastPage", calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNum));
		viewData.put("endPage", getEndPage(pageNum,calPageTotalCount(totalCount)));

		return viewData;
	}

	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if (totalCount != 0) {
			pageTotalCount = (int) Math.ceil(((double) totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}

	public int getStartPage(int pageNum) {
		int stratPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + 1;
		return stratPage;
	}

	public int getEndPage(int pageNum, int totalCount) {
		int EndPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + NUM_OF_NAVI_PAGE;
		System.out.println("EndPage"+EndPage);
		System.out.println("totalCount"+totalCount);
		if(EndPage >= totalCount) {
			EndPage = totalCount;
		}
		return EndPage;
	}
}
