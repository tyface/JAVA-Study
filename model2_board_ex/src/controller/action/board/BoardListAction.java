package controller.action.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardListAction implements Action {
	// 한페이지에 표시될 메시지의 개수
	private static final int NUM_OF_BOARD_PER_PAGE = 5;
	// 한번에 표시될 네비게이션의 개수
	private static final int NUM_OF_NAVI_PAGE = 5;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int pageNum = 1;
		if (req.getParameter("page_num") != null) {
			pageNum = Integer.parseInt(req.getParameter("page_num"));
		}

		Map<String, Object> boradData = getBoardList(pageNum);
		
		req.setAttribute("boardList", boradData.get("boradList"));
		req.setAttribute("lastPage", boradData.get("lastPage"));
		req.setAttribute("startPage", boradData.get("startPage"));
		req.setAttribute("endPage", boradData.get("endPage"));
		req.setAttribute("pageNum", pageNum);
		req.getRequestDispatcher("jsp/board_list.jsp").forward(req, resp);

	}

	public Map<String, Object> getBoardList(int pageNum) {
		BoardDao boardDao = BoardDaoImp.getInstance();

		int firstRow = (pageNum - 1) * NUM_OF_BOARD_PER_PAGE + 1;
		int endRow = pageNum * NUM_OF_BOARD_PER_PAGE;
		int totalCount = boardDao.selectCount();

		Map<String, Object> viewData = new HashMap<String, Object>();
		viewData.put("boradList", boardDao.selectBetween(firstRow, endRow));
		viewData.put("lastPage", calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNum));
		viewData.put("endPage", getEndPage(pageNum, calPageTotalCount(totalCount)));

		return viewData;
	}

	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if (totalCount != 0) {
			pageTotalCount = (int) Math.ceil(((double) totalCount / NUM_OF_BOARD_PER_PAGE));
		}
		return pageTotalCount;
	}

	public int getStartPage(int pageNum) {
		int stratPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + 1;
		return stratPage;
	}

	public int getEndPage(int pageNum, int totalCount) {
		int EndPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + NUM_OF_NAVI_PAGE;
		System.out.println("EndPage" + EndPage);
		System.out.println("totalCount" + totalCount);
		if (EndPage >= totalCount) {
			EndPage = totalCount;
		}
		return EndPage;
	}
}
