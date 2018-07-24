package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dao.PublicDataDao;
import vo.EntDetailInfo;
import vo.EntInfo;

public class PublicDataAPI {

	private static final String SERVICEKEY = "5fTJ17jK60Sivbr%2FGt2GNQkAIL%2FFGSYjkv1LB0PqqUGhyS96tY%2B7muOuYPwFkSNOX56S1WCPhsV%2FodDyXFVqrg%3D%3D";
	private PublicDataDao dao = PublicDataDao.getInstance();

	// 사업장 정보 조회
	public Map<String, Object> getBassInfoSearch(Map<String, String> ent) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		Map<String, String> mapData = null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		EntInfo entInfo;

		try {

			/* 요철 URL 만들기 */
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + SERVICEKEY);
			/* Service Key */
			urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_dg_cd", "UTF-8") + "="
					+ URLEncoder.encode(ent.get("ADDR_BCITY_CD"), "UTF-8")); /* 시도(행정자치부 법정동 주소코드 참조) */
			urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_cd", "UTF-8") + "="
					+ URLEncoder.encode(ent.get("ADDR_SIGNGU_CD"), "UTF-8")); /* 시군구(행정자치부 법정동 주소코드 참조) */
			// urlBuilder.append("&" +
			// URLEncoder.encode("ldong_addr_mgpl_sggu_emd_cd","UTF-8") + "=" +
			// URLEncoder.encode("101", "UTF-8")); /*읍면동(행정자치부 법정동 주소코드 참조)*/
			urlBuilder.append("&" + URLEncoder.encode("wkpl_nm", "UTF-8") + "="
					+ URLEncoder.encode(ent.get("ENT_NM"), "UTF-8")); /* 사업장명 */
			// urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no","UTF-8") + "=" +
			// URLEncoder.encode("124815", "UTF-8")); /*사업자등록번호(앞에서 6자리)*/
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append(
					"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("31", "UTF-8")); /* 행갯수 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			// System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			InputSource is = new InputSource(new StringReader(sb.toString()));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			// XPathExpression expr = xpath.compile("/response/*");
			NodeList totalCount = (NodeList) xpath.evaluate("//totalCount", doc, XPathConstants.NODESET);

			if (totalCount.item(0) == null || totalCount.item(0).getTextContent().equals("0")) {

				mapData = new HashMap<String, String>();
				mapData.put("ENT_IDX", String.valueOf(ent.get("ENT_IDX")));
				mapData.put("RESULT", "NOT");

				dao.modifyEnt(mapData);
				System.out.println("기업 검색 실패");
				resultMap.put("resultCode", "04");

			} else if (Integer.parseInt(totalCount.item(0).getTextContent()) >= 33) {

				mapData = new HashMap<String, String>();
				mapData.put("ENT_IDX", String.valueOf(ent.get("ENT_IDX")));
				mapData.put("RESULT", "DUP");
				dao.modifyEnt(mapData);
				System.out.println("totalCount 33 이상 검색됨");
				resultMap.put("resultCode", "04");

			} else if (Integer.parseInt(totalCount.item(0).getTextContent()) <= 32) {
				XPathExpression expr = xpath.compile("//items/item");
				NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
				List<EntInfo> entInfoList = new ArrayList<EntInfo>();
				mapData = new HashMap<String, String>();

				for (int i = 0; i < nodeList.getLength(); i++) {
					NodeList child = nodeList.item(i).getChildNodes();

					entInfo = new EntInfo();
					entInfo.setBzowrRgstNo(child.item(0).getTextContent());
					entInfo.setDataCrtYm(child.item(1).getTextContent());
					entInfo.setLdongAddrMgplDgCd(child.item(2).getTextContent());
					entInfo.setLdongAddrMgplSgguCd(child.item(3).getTextContent());
					entInfo.setLdongAddrMgplSgguEmdCd(child.item(4).getTextContent());
					entInfo.setSeq(child.item(5).getTextContent());
					entInfo.setWkplJnngStcd(child.item(6).getTextContent());
					entInfo.setWkplNm(child.item(7).getTextContent());
					entInfo.setWkplRoadNmDtlAddr(child.item(8).getTextContent());
					entInfo.setWkplStylDvcd(child.item(9).getTextContent());
					entInfo.setEntIdx(String.valueOf(ent.get("ENT_IDX")));
					entInfoList.add(entInfo);
				}

				dao.regEntInfo(entInfoList);

				mapData.put("ENT_IDX", String.valueOf(ent.get("ENT_IDX")));
				mapData.put("RESULT", "SEC");
				dao.modifyEnt(mapData);
				System.out.println("기업등록 성공!!");
				resultMap.put("resultCode", "01");
				resultMap.put("entInfoList", entInfoList);
			} else {
				System.out.println("=======메인 로직 예외 발생======== 기업번호 : " + String.valueOf(ent.get("ENT_IDX")));
			}

		} catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException e) {
			e.printStackTrace();
		}

		return resultMap;
	}

	// 사업장 상세정보 조회
	public void getDetailInfoSearch(String seq, String entIdx) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		Map<String, String> mapData = null;

		try {

			/* 요철 URL 만들기 */
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getDetailInfoSearch"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + SERVICEKEY); /* Service Key */
			urlBuilder
					.append("&" + URLEncoder.encode("seq", "UTF-8") + "=" + URLEncoder.encode(seq, "UTF-8")); /* 식별번호 */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			// System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			InputSource is = new InputSource(new StringReader(sb.toString()));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			
			NodeList nodeList = (NodeList) xpath.evaluate("//item", doc, XPathConstants.NODESET);
			if (nodeList.item(0) == null) {

				mapData = new HashMap<String, String>();
				mapData.put("ENT_IDX", entIdx);
				mapData.put("RESULT", "FAIL_DTL");
				dao.modifyEnt(mapData);
				System.out.println("상세정보 검색 실패--------------------------------------------");

			} else {
				NodeList child = nodeList.item(0).getChildNodes();

				EntDetailInfo entDetailInfo = new EntDetailInfo();

				entDetailInfo.setAdptDt(child.item(0).getTextContent());
				entDetailInfo.setBzowrRgstNo(child.item(1).getTextContent());
				entDetailInfo.setCrrmmNtcAmt(child.item(2).getTextContent());
				entDetailInfo.setJnngpCnt(child.item(3).getTextContent());
				entDetailInfo.setLdongAddrMgplDgCd(child.item(4).getTextContent());
				entDetailInfo.setLdongAddrMgplSgguCd(child.item(5).getTextContent());
				entDetailInfo.setLdongAddrMgplSgguEmdCd(child.item(6).getTextContent());
				entDetailInfo.setScsnDt(child.item(7).getTextContent());
				entDetailInfo.setVldtVlKrnNm(child.item(8).getTextContent());
				entDetailInfo.setWkplIntpCd(child.item(9).getTextContent());
				entDetailInfo.setWkplJnngStcd(child.item(10).getTextContent());
				entDetailInfo.setWkplNm(child.item(11).getTextContent());
				entDetailInfo.setWkplRoadNmDtlAddr(child.item(12).getTextContent());
				entDetailInfo.setWkplStylDvcd(child.item(13).getTextContent());
				entDetailInfo.setSeq(seq);
				entDetailInfo.setEntIdx(entIdx);
				
				dao.regEntDetailInfo(entDetailInfo);
				Thread.sleep(100);
				System.out.println("상세정보 저장완료");
			}

		} catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	// 월별 내역 조회
	public void getPdAcctoSttusInfoSearch(String seq, String entIdx, String dataCrtYm) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		Map<String, String> mapData = null;

		try {

			/* 요청 URL 만들기 */
			StringBuilder urlBuilder = new StringBuilder(
					"http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getPdAcctoSttusInfoSearch"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + SERVICEKEY); /* Service Key */
			urlBuilder
					.append("&" + URLEncoder.encode("seq", "UTF-8") + "=" + URLEncoder.encode(seq, "UTF-8")); /* 식별번호 */
			urlBuilder.append("&" + URLEncoder.encode("data_crt_ym", "UTF-8") + "="
					+ URLEncoder.encode(dataCrtYm, "UTF-8")); /* 년월(yyyymm) */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();

			InputSource is = new InputSource(new StringReader(sb.toString()));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			NodeList nodeList = (NodeList) xpath.evaluate("//item", doc, XPathConstants.NODESET);
			NodeList child = nodeList.item(0).getChildNodes();

			if (child.item(0) == null) {

				mapData = new HashMap<String, String>();
				mapData.put("ENT_IDX", entIdx);
				mapData.put("RESULT", "FAIL_PER");
				dao.modifyEnt(mapData);
				System.out.println("월별 정보 검색 실패------------------------------");

			} else {

				Map<String, String> map = new HashMap<String, String>();

				map.put("lssJnngpCnt", child.item(0).getTextContent());
				map.put("nwAcqzrCnt", child.item(1).getTextContent());
				map.put("seq", seq);
				map.put("entIdx", entIdx);

				Thread.sleep(100);
				dao.regPeriodInfo(map);
				System.out.println("월별내역 저장완료");
			}

		} catch (IOException | ParserConfigurationException | SAXException | XPathExpressionException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
