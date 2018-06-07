package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileService;

@WebServlet("/file")
public class FileServlet extends HttpServlet {

	FileService fileSvc;

	public FileServlet() {
		fileSvc = FileService.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");

		switch (command) {
		case "fileList":
			List<String> fileList = fileSvc.getAllFileNames();

			req.setAttribute("fileList", fileList);
			req.getRequestDispatcher("fileList.jsp").forward(req, resp);
			break;
		case "download":
			System.out.println("다운로드 요청받음");
			String fileName = req.getParameter("fileName");
			String downloadPath = "C:\\test\\";
			String filePath = downloadPath + fileName;

			byte[] b = new byte[4096];

			FileInputStream fis = new FileInputStream(filePath);

			String sMimeType = getServletContext().getMimeType(filePath);
			System.out.println(sMimeType);

			if (sMimeType == null) {
				sMimeType = "application/octect-stream";
			}
			resp.setContentType(sMimeType);

			// UUID 제거
			int idx = fileName.indexOf("_");
			String orginFileName = fileName.substring(idx + 1);
			// 한글 파일명 처리
			String strEncoding = new String(orginFileName.getBytes("UTF-8"), "8859_1");

			resp.setHeader("Content-Disposition", "attachment;filename=" + strEncoding);

			ServletOutputStream sos = resp.getOutputStream();

			int readNum = 0;

			while ((readNum = fis.read(b, 0, b.length)) != -1) {
				sos.write(b, 0, readNum);
			}
			sos.flush();
			sos.close();
			fis.close();
			break;
		default:
			break;
		}

	}

}
