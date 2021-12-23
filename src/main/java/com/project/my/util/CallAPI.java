package com.project.my.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CallAPI {

	private String kobis_key = "08fe9327eb466a04a4592345c7c94ee0";
	private String kmdb_key = "8D1LXCEKGQ3NTF7KRT9K";
	private String clientId = "VVLYlK0bYSJZj_ZKb15A";
	private String clientSecret = "aRH8FyN82I";
	
	private List<String> titleList = null;
	
	// 일별박스오피스 api 호출
	public List<String> callBoxOfiice() {
	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);
		String tdate = sdf.format(cal.getTime());
		
		try {
			
			// URL 연결 객체 생성
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key="
					 + kobis_key + "&targetDt=" + tdate);	
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");	// GET방식으로 요청
//			conn.setConnectTimeout(3000);	// 연결 제한시간 30초
//			conn.setReadTimeout(1000);	// 컨텐츠 조회 제한시간 10초
			
			// response 구조 작성
			BufferedReader rd;
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); 
			} 
			else { 
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
			}
			
			StringBuilder sb= new StringBuilder();
			
			String line = "";
			
			while ((line = rd.readLine()) != null) { 
				sb.append(line); 
			} 
			
			rd.close();
			 
			conn.disconnect();
			
			String result = sb.toString();
//			System.out.println(result);
			
			// JSON 파싱
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
			
			JSONObject boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult");
			JSONArray array = (JSONArray) boxOfficeResult.get("dailyBoxOfficeList");
			
			titleList = new ArrayList<String>();
			
			for(int i=0; i < array.size(); i++) {
				JSONObject entity = (JSONObject) array.get(i);
				
				String title = entity.get("movieNm").toString();
				titleList.add(title);
			}
			
//			for(Object object : titleList) {
//				String ele = (String) object;
//				System.out.println(ele);
//			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return titleList;
	}
	
	// 영화상세정보 api 호출
	// 요청인자 : title
	public String callFilmByTitle(String title) {
		
		String result = "";
		
		try {
			
			// title : UTF-8 인코딩
			String query = URLEncoder.encode(title, "UTF-8");
			
			// URL 연결 객체 생성
			URL url = new URL("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&ServiceKey="
					 + kmdb_key + "&title=" + query);	
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");	// GET방식으로 요청
//			conn.setConnectTimeout(3000);	// 연결 제한시간 30초
//			conn.setReadTimeout(1000);	// 컨텐츠 조회 제한시간 10초
			
			// response 구조 작성
			BufferedReader rd;
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) { 
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); 
			} 
			else { 
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
			}
			
			StringBuilder sb= new StringBuilder();
			
			String line = "";
			
			while ((line = rd.readLine()) != null) { 
				sb.append(line); 
			} 
			
			rd.close();
			 
			conn.disconnect();
			
			result = sb.toString();
//			System.out.println(result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 영화상세정보 api 호출
	// 요청인자 : genre
	public void callFilmByGenre(String genre) {
		
	}
	public List<String> getBoxOfficeImage(List<String> title) {
	
		List<String> boxofficeImg = new ArrayList();
		
//		String film = callFilmDetail(title.get(8));
//		System.out.println(film);
		
		JSONParser jsonParser;	
		JSONObject jsonObject;
		JSONArray data;
		JSONObject entity;
		JSONArray result;
		JSONObject object;
		
//		String img = (String) object.get("posters");
//		System.out.println(img);
		
		try {
			
			String img;
			
			for(int i=0; i<title.size(); i++) {
				
				String film = callFilmDetail(title.get(i));
				System.out.println(film);
				
				// JSON 파싱
				jsonParser = new JSONParser();
				
				jsonObject = (JSONObject) jsonParser.parse(film);
				data = (JSONArray) jsonObject.get("Data");
				entity = (JSONObject) data.get(0);
				result = (JSONArray) entity.get("Result");
				object = (JSONObject) result.get(0);
				img = (String) object.get("posters");
				
//				if(img.contains("|")) {
//					String imgArr[] = img.split("\\|");
//					img = imgArr[0];
//				}
				
				System.out.println(img);
				
				boxofficeImg.add(img);

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return boxofficeImg;
	}
	
	// 네이버 api 호출
	// 요청인자 : titleList
	public List<String> callPosterList(List<String> titleList) {

		List<String> posterList = new ArrayList<String>();

		try {
			URL url;
			
			for(int i=0; i<titleList.size(); i++) {
				String title = URLEncoder.encode(titleList.get(i).toString(), "UTF-8");
				
				String apiurl = "https://openapi.naver.com/v1/search/movie.json?query=" + title;
				
				url = new URL(apiurl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("X-Naver-Client-Id", clientId);
				conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				
				BufferedReader rd;
				
				int responseCode = conn.getResponseCode();
				if(responseCode == HttpURLConnection.HTTP_OK) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				}
				else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream())); 
				}
				
				StringBuilder sb= new StringBuilder();
				
				String line = "";
				
				while ((line = rd.readLine()) != null) { 
					sb.append(line); 
				}
				
				rd.close();
				 
				conn.disconnect();
				
				String result = sb.toString();
				
				// JSON 파싱
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
				JSONArray item = (JSONArray) jsonObject.get("items");
				JSONObject entity = (JSONObject) item.get(0);
				
				String poster = entity.get("image").toString();
				
				posterList.add(poster);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return posterList;
	}
	
	// 네이버 api 호출
	// 요청인자 : title
	public void callPoster(String title) {
		
		
	}
	public List<String> getBoxOfficePoster(List<String> title) {
		
		List<String> boxofficePoster = new ArrayList();
		
		
		return boxofficePoster;
	}
}
