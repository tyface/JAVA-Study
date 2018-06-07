package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.FileService;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	FileService fileSvc;

	public UploadServlet() {
		fileSvc = FileService.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		/*
		 * 요청이 들어오면 해야할 일 1. 제대로된 요청인지 확인 (파일업로드 요청인지 아닌지) 컨텐트 타입 가져와서 확인 2. 파일이름을 DB에
		 * 저장하고 3. multipart로 전달 받은 데이터를 파일로 만들어서 저장
		 * 
		 */

		// 1. 요청 내용확인을 위해 contype 가져오기
		String contentType = req.getContentType();

		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			// 파일 요청이다.
			// 파일 이름을 DB에 저장하기 : 메서드 작성
			saveFilename(req, resp);
		}

	}

	private void saveFilename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일들은 파트들로 분리되서 전송이 되기 때문에
		// 파일들을 모두 모아서 파일로 만들어 저장

		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			if(part.getHeader("Content-Disposition")
				.contains("filename=")) {
				String fileName = part.getSubmittedFileName();
//				System.out.println("fileName : " + fileName);
				UUID uuid = UUID.randomUUID();
				
				String saveName = uuid.toString()+"_"+fileName;
				
				if(part.getSize() > 0) {
//					part.write("C:\\temp\\"+fileName);
					//web.xml에 기본 경로 지정 후 
					part.write("C:\\test\\" + saveName);
					//파일네임을 DB에 저장
					fileSvc.uploadFile(saveName);
				}
			}
		}

	}

}
