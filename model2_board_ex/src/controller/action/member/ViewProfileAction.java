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

public class ViewProfileAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userIdx = req.getParameter("user_idx");
		MemberDao memberDao = MemberDaoImp.getInstance();
		String fileName = memberDao.selectOne(userIdx).getProfile();
		
		if(fileName != null){
			File imgFile = new File(Commons.DEFAULT_FILE_PASS + fileName);

			FileInputStream ifo = new FileInputStream(imgFile);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int readlength = 0;
			
			while ((readlength = ifo.read(buf)) != -1) {
				baos.write(buf, 0, readlength);
			}
			
			byte[] imgbuf = null;
			imgbuf = baos.toByteArray();
			baos.close();
			ifo.close();

			int length = imgbuf.length;
			OutputStream out = resp.getOutputStream();
			out.write(imgbuf, 0, length);
			out.close();
		}
		
	}
}
