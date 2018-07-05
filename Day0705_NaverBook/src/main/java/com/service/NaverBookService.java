package com.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.model.Book;

@Service
public class NaverBookService {

	private static final String CLIENT_ID = "jhIuTjMfg_04WyRuiSvE"; // 애플리케이션 클라이언트 아이디값";
	private static final String CLIENT_SECRET = "eBNw7AzIAC"; // 애플리케이션 클라이언트 시크릿값";

	public List<Book> searchBooks(String keyword) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		String text = URLEncoder.encode(keyword, "UTF-8");
		String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text; // json 결과
		URL url = new URL(apiURL);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
		con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
		
		int responseCode = con.getResponseCode();
		BufferedReader br;
		
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		String inputLine;
		StringBuffer sb = new StringBuffer();
		
		while ((inputLine = br.readLine()) != null) {
			sb.append(inputLine);
		}
		JSONObject jObject = new JSONObject(sb.toString());
		//응답받은 json 객체에서 실제 책 정보를 포함하고 있는 jsonarray 가져오기
		JSONArray items = jObject.getJSONArray("items");
		
//		System.out.println(items);TODO test
		System.out.println(items);
		for(int i =0;i<items.length();i++) {
			//json array(책 여러권 정보) 반복하면서 한권의 데이터 꺼내오기 
			JSONObject item = items.getJSONObject(i);
			Book book = new Book();
			book.setTitle(item.getString("title"));
			book.setAuthor(item.getString("author"));
			book.setDescription(item.getString("description"));
			book.setDiscount(item.getString("discount"));
			book.setImage(item.getString("image"));
			book.setIsbn(item.getString("isbn"));
			book.setLink(item.getString("link"));
			book.setPrice(item.getString("price"));
			book.setPubdate(item.getString("pubdate"));
			book.setPublisher(item.getString("publisher"));
			book.setPubdate(item.getString("pubdate"));
			
			bookList.add(book);
		}
		
		br.close();

		return bookList;
	}
}
