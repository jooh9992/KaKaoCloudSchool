package kakao.cloud.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class KakaoBookSearch {
	public static void main(String[] args) {
		//카카오 도서 검색 API
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//url 만들기
					//GET 방식에서 파라미터는 반드시 인코딩되어야 함
					String address = "http://dapi.kakao.com/v3/search/book";
					address += "?query=";
					address += URLEncoder.encode("자바의정석", "utf-8");
					//Connection 만들기
					URL url = new URL(address);
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setConnectTimeout(30000);
					con.setUseCaches(false);
					con.setRequestMethod("GET");
					//키 설정
					con.setRequestProperty(
							"Authorization", 
							"KakaoAK 카카오RESTAPI키");
					//데이터 읽어오기
					BufferedReader br = new BufferedReader(
							new InputStreamReader(
									con.getInputStream()));
					StringBuilder sb = new StringBuilder();
					while(true) {
						String imsi = br.readLine();
						if(imsi ==null) {
							break;
						}
						sb.append(imsi + "\r\n");
					}
					String result = sb.toString();
					System.out.println(result);
					br.close();
					con.disconnect();
							
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
				
			}
		}).start();
	}
}
