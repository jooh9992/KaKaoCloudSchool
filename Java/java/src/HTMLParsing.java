import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParsing {
	public static void main(String[] args) {
		//웹에서 필요한 문자열 가져오기
		//API Server에서 데이터를 받아오는 부분은
		//접속방신, 파라미터 부분을 제외하면 동일
		String html = null;
		try {
			//URL 생성
			URL url = new URL("https://smtownandstore.com/");
			//다운로드 옵션 설정 - 전송 방식이나 파라미터 설정
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			//결과 다운로드
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				//파싱 할 때는  \n은 의미가 없음
				//데이터를 확인하고자 할 때 보기좋게 출력하기 위해서 삽입
				sb.append(line + "\n");
			}
			html = sb.toString();
			System.out.println(html);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//문자열에서 원하는 데이터를 추출 - Parsing
		//데이터 형식에 따라 json, xml, csv, html에 따라 다름
		if(html != null) {
			try {
				//html 문자열을 메모리에 DOM 형태로 펼쳐내기
				Document document = Jsoup.parse(html);
				
				//태그 가지고 찾기
				/*Elements elements = document.getElementsByTag("a");
				//태그는 여러 개이므로 순회
				for(int i=0; i<elements.size(); i++) {
					//한개 찾아오기
					Element element = elements.get(i);
					//텍스트 확인
					//System.out.println(element.text());
					//속성 확인
					System.out.println(element.attr("href"));
				}*/
				//선택자 이용
				Elements elements = document.select("#contents > div.xans-element-.xans-product.xans-product-detail > div.detailArea > div.infoArea > div.infoArea_fix > div.headingArea > h2");
				
				
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		
		//데이터를 사용
	}
}
