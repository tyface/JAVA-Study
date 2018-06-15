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
	// 한페이지에 표시될 게시글의 개수
	private static final int NUM_OF_BOARD_PER_PAGE = 10;
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

	// 인자갑으로 받은 페이지 번호에 해당하는 페이지 정보를 반환하는 메서드
	public Map<String, Object> getBoardList(int pageNum) {
		BoardDao boardDao = BoardDaoImp.getInstance();

		int firstRow = (pageNum - 1) * NUM_OF_BOARD_PER_PAGE + 1; // 시작 게시글 번호
		int endRow = pageNum * NUM_OF_BOARD_PER_PAGE; // 끝 게시글 번호
		int totalCount = boardDao.selectCount(); // 전체 게시글 개수

		Map<String, Object> viewData = new HashMap<String, Object>();

		viewData.put("boradList", boardDao.selectBetween(firstRow, endRow)); // 게시글 리스트 삽입
		viewData.put("lastPage", calPageTotalCount(totalCount)); // 전체 페이지 개수 삽입
		viewData.put("startPage", getStartPage(pageNum)); // 시작 페이지 번호 삽입
		viewData.put("endPage", getEndPage(pageNum, calPageTotalCount(totalCount))); // 끝페이지 번호 삽입

		return viewData;
	}

	// 전체 게시글 개수를 받아 전체 페이지수를 구하는 함수
	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if (totalCount != 0) {
			pageTotalCount = (int) Math.ceil(((double) totalCount / NUM_OF_BOARD_PER_PAGE));
		}
		return pageTotalCount;
	}

	// 시작페이지 구하는 함수
	public int getStartPage(int pageNum) {
		int stratPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + 1;
		return stratPage;
	}

	// 끝페이지 구하는 함수
	public int getEndPage(int pageNum, int totalCount) {
		int EndPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + NUM_OF_NAVI_PAGE;
		if (EndPage >= totalCount) {
			EndPage = totalCount;
		}
		return EndPage;
	}
}
