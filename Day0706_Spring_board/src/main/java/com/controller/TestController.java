package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {

	@RequestMapping("/imageView")
	public String imageView() {
		return "image";
	}

	@SuppressWarnings("resource")
	@RequestMapping("/image")
	@ResponseBody
	public byte[] getImageAsByteArray(String fileName) throws FileNotFoundException {
		// 특정 이미지 읽어와서 byte[] 배열로 만들어서 반환
		System.out.println("/image 요청 받음");

		File originFile = new File("C:/text/" + fileName);

		@SuppressWarnings("unused")
		InputStream targetStream = null;
		targetStream = new FileInputStream(originFile);
		return null;
	}

}
