package com.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	private File file;

	public DownloadView(File file) {
		this.file = file;

		setContentType("application/download; utf-8");

	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		res.setContentType(getContentType());
		res.setContentLengthLong(file.length());

		String fullName = file.getName();
		int idx = fullName.indexOf("_") + 1;
		String tmpName = fullName.substring(idx);

		String fileName = null;

		String userAgent = req.getHeader("User-Agent");
		
		boolean isIE = userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("rv:") > -1;
		
		if (isIE) {
			fileName = URLEncoder.encode(tmpName, "utf-8");
		} else {
			fileName = new String(tmpName.getBytes("utf-8"), "ISO-8859-1");
		}

		res.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		res.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = res.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
		}
		out.flush();
	}

}
