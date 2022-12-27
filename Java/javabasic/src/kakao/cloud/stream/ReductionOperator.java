package kakao.cloud.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionOperator {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("박지성", "이해찬", 
				"이민형", "황런쥔", "나재민","이제노", "천러","박지성"
		);
		//스트림 생성
		Stream <String> stream = list.stream();
		//전체 출력
		list.forEach((temp) -> System.out.print(temp+"\t"));
		System.out.println();
		
		//2개빼고 출력
		//stream.skip(2).forEach((temp) -> System.out.print(temp+"\t"));
		//System.out.println();
		//2개 건너뛰고 3개 사용
		//stream.skip(2).limit(3).forEach((temp) -> System.out.print(temp+"\t"));
		//중복 제거
		//stream.distinct().forEach((temp) -> System.out.print(temp+"\t"));
		//필터링
		//매개변수가 1개이고 Boolean을 리턴하는 함수를 대입
		//stream.filter(name -> name.charAt(0)=='박').forEach((temp) -> System.out.print(temp+"\t"));
	
		//ㅇ 으로 시작하는 
		stream.filter(name -> name.charAt(0) >='아' && name.charAt(0)<'자').sorted().forEach((temp) -> System.out.print(temp+"\t"));
	}
}	
