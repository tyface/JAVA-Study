package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import api.PublicDataAPI;
import dao.PublicDataDao;
import vo.EntInfo;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException {

		PublicDataDao dao = PublicDataDao.getInstance();
		PublicDataAPI api = new PublicDataAPI();
		// 검색할 야식리스트 불러오기
		List<Map<String, String>> entList = dao.getEntList();
		Map<String, Object> resultData;
		for (Map<String, String> ent : entList) {
			resultData = api.getBassInfoSearch(ent);
			if (resultData.get("resultCode").equals("01")) {
				List<EntInfo> entInfoList = (List<EntInfo>) resultData.get("entInfoList");
				
				for(EntInfo entInfo :entInfoList) {
					
					api.getDetailInfoSearch(entInfo.getSeq(),entInfo.getEntIdx());
					
				}
				
				for(EntInfo entInfo :entInfoList) {
					api.getPdAcctoSttusInfoSearch(entInfo.getSeq(),entInfo.getEntIdx(),entInfo.getDataCrtYm());
					
				}
			}

		}
	}
}
