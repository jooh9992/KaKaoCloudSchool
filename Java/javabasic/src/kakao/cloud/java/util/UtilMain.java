package kakao.cloud.java.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilMain {
	public static void main(String[] args) {
		Random r = new Random();
		int lotto = r.nextInt(45) + 1;
		System.out.println(lotto);
		
		String[] card = {"스페이드", "다이아", "하트", "클로버"};
		String myCard = card[r.nextInt(card.length)];
		System.out.println(myCard);
		
		//관계형 데이터베이스에서는 하나의 테이블에 기본키를
		//설정하면 이 기본키에 배열로 매핑되는 데이터는 삽입할 수 없음
		//제 1정규형(NF): 모든 속성의 값은 원자 값이어야 함
		//Atomic Value(원자 값): 더 이상 분해할 수 없는 값
		//하나의 게시글에 여러 개의 첨부 파일을 삽입하는 경우
		//첨부 파일 테이블을 별도로 만듬
		//이렇게 별도의 테이블로 만들면
		//게시글을 가져와서 첨부파일명을 출력할려면
		//join을 해야 함
		//관계형 데이터베이스에서 가장 많이 시간을 소비하는 것이 join
		//이럴 때 join 시간을 아끼고자 하면 첨부파일이름들을 
		//하나로 묶어서 저장해도 됨
		
		//ArrayList: 데이터를 물리적으로 연속해서 저장
		//LinkedList 보다 조회속도는 빠르지만
		//LinkedList 보다 삽입 및 삭제 속도는 느림
		List <String> list = new ArrayList<>();
		list.add(null);
		list.add("image1.png");
		list.add("image3.png,image5.png,image7.png");
		//list 순회
		for(String temp:list) {
			if(temp == null) {
				System.out.println("첨부 파일 없음");
			}else {
				String[] imsi = temp.split(",");
				System.out.println(Arrays.toString(imsi));
			}
		}
		String[] image0 = null;
		String[] image1 = {"image100.png"};
		String[] image2 = {"image101.png", "image102.png"};
		
		if(image0 == null) {
			System.out.println("default.png");
		}
		
		if(image2 != null && image2.length == 1) {
			System.out.println(image2[0]);
		}else {
			String x = image2[0];
			for(int i=1; i<image2.length; i++) {
				x = x +"," + image2[i];
			}
			System.out.println(x);
		}
		
		//Calendar로 원하는 날짜를 생성하고 Date로 변환
		Calendar calendar = new GregorianCalendar(1986, 4, 5);
		Date date = new Date(calendar.getTimeInMillis());
		System.out.println(date);
		
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy년MM월dd일 EEEE a hh:mm:ss");
		System.out.println(format.format(date));
		
		//정규 표현식 객체 사용
		//문자열 배열에서 a로 시작하고 c로 끝나는 3글자 조회
		String [] ar = {"abc", "asc", "alic"};
		//정규식 생성 - a로 시작하고 아무 글자나 하나 있고 c로 끝나는
		Pattern p = Pattern.compile("^a.c$");
		for(String str : ar) {
			//정규식 패턴과 일치하는지 조사
			Matcher matcher = p.matcher(str);
			System.out.println(str +":" + matcher.find());
		}
	}
}
