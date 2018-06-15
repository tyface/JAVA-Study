package controller.action.member;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Commons;
import controller.action.Action;
import dao.MemberDao;
import dao.MemberDaoImp;

//로그인상태일때 프로필 사진을 출력해주는 엑션
public class ViewProfileAction implements Action {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userIdx = req.getParameter("user_idx");
		MemberDao memberDao = MemberDaoImp.getInstance();
		String fileName = memberDao.selectOne(userIdx).getProfile();
		
		if(fileName != null){
			//서버에 저장되어있는 이미지 파일의 이름과 위치.
			File imgFile = new File(Commons.DEFAULT_FILE_PASS + fileName);

			//파일 읽어오기
			FileInputStream ifo = new FileInputStream(imgFile);
			//아웃풋 스트림
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int readlength = 0;
			
			while ((readlength = ifo.read(buf)) != -1) {
				baos.write(buf, 0, readlength);
			}
			
			//버퍼
			byte[] imgbuf = null;
			imgbuf = baos.toByteArray();
			baos.close();
			ifo.close();

			int length = imgbuf.length;
			OutputStream out = resp.getOutputStream();
			
			//파일 출력
			out.write(imgbuf, 0, length);
			out.close();
		}
		
	}
}
