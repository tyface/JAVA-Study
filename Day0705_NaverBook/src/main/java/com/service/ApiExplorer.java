package com.service;



import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=4GAO%2FPVDalQKB3%2B%2BBAKLDshwYMITY88EwIjnQKIwynZFi1i7Jc%2BRLlArsxjkPTOE7t7OESiitXN0lx2tyABuiA%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_dg_cd","UTF-8") + "=" + URLEncoder.encode("41", "UTF-8")); /*시도(행정자치부 법정동 주소코드 참조)*/
//        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_cd","UTF-8") + "=" + URLEncoder.encode("117", "UTF-8")); /*시군구(행정자치부 법정동 주소코드 참조)*/
//        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_emd_cd","UTF-8") + "=" + URLEncoder.encode("101", "UTF-8")); /*읍면동(행정자치부 법정동 주소코드 참조)*/
        urlBuilder.append("&" + URLEncoder.encode("wkpl_nm","UTF-8") + "=" + URLEncoder.encode("컨텐츠포탈", "UTF-8")); /*사업장명*/
//        urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no","UTF-8") + "=" + URLEncoder.encode("124815", "UTF-8")); /*사업자등록번호(앞에서 6자리)*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*행갯수*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}