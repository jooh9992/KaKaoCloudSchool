package kakao.cloud.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		//정수 배열
		int [] ar = {60, 30, 20, 75, 11};
		
		//문자열 배열
		String [] br = {"닝닝", "윈터", "지젤", "카리나"};
		
		//배열의 데이터 확인
		System.out.println(Arrays.toString(ar));
		
		//정수 배열 정렬
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		
		//문자열 배열 정렬
		Arrays.sort(br);
		System.out.println(Arrays.toString(br));
		
		//VO 클래스의 인스턴스 5개를 소유하는 배열
//		VO [] datas = new VO[5];
//		datas[0] = new VO(1, "배수지", 28);
//		datas[1] = new VO(2, "이지은", 29);
//		datas[2] = new VO(3, "배주현", 31);
//		datas[3] = new VO(4, "박수영", 26);
//		datas[4] = new VO(5, "유지민", 22);
//		
//	    System.out.println(Arrays.toString(datas));
//	    Arrays.sort(datas);
//	    System.out.println(Arrays.toString(datas));
	    
	    String [] names = {"닝닝", "윈터", "카리나", "지젤"};
	    System.out.println(Arrays.toString(names));
	    
	    //복사본 만들기
	    String[] copy = Arrays.copyOf(names, names.length);
	    Arrays.sort(copy);
	    System.out.println(Arrays.toString(copy));
	    
	    Arrays.sort(copy, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
	    });
	    System.out.println(Arrays.toString(copy));
	    
	    int[] ar1 = {30, 20, 50, 10, 40};
	    //정렬을 수행하지 않고 하면 논리적인 오류가 발생
	    System.out.println(Arrays.binarySearch(ar1, 20));
	    Arrays.sort(ar1);
	    System.out.println(Arrays.binarySearch(ar1, 20));
	    //sort가 된 상태이므로 0이 아니고 2
	    System.out.println(Arrays.binarySearch(ar1, 30));
	    
	    //정수를 저장하기 위한 ArrayList
	    List <Integer> al = new ArrayList<>();
	    //정수를 저장하기 위한 LinkedList
	    List <Integer> li = new LinkedList<>();
	    
	    al.add(1);
	    al.add(3);
	    
	    li.add(1);
	    li.add(3);
	    
	    long start;
	    long end;
	    
//	    start = System.currentTimeMillis();
//	    for(int i=0; i<100000; i++) {
//	    	Integer integer = al.get(i);
//	    }
//	    end = System.currentTimeMillis();
//	    System.out.println("ArrayList 조회 시간:" +(end-start));
//	    
//	    start = System.currentTimeMillis();
//	    for(int i=0; i<100000; i++) {
//	    	Integer integer = li.get(i);
//	    }
//	    end = System.currentTimeMillis();
//	    System.out.println("LinkedList 조회 시간:" +(end-start));
	    
//	    start = System.currentTimeMillis();
//	    for(int i=0; i<100000; i++) {
//	    	al.add(1,2);
//	    }
//	    end = System.currentTimeMillis();
//	    System.out.println("ArrayList 중간에 추가하는 시간:" +(end-start));
//	    
//	    start = System.currentTimeMillis();
//	    for(int i=0; i<100000; i++) {
//	    	li.add(1,2);
//	    }
//	    end = System.currentTimeMillis();
//	    System.out.println("LinkedList 중간에 추가하는 시간:" +(end-start));
	    
	    List <String> list = new ArrayList<>();
	    list.add("지성");
	    list.add("재민");
	    list.add("마크");
	    list.add("해찬");
	    list.add("런쥔");
	    
	    //순회
	    for(String temp : list) {
	    	System.out.println(temp);
	    }
	    //데이터 정렬
	    list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
	    });
	    
	    Stack <String> stack = new Stack<>();
	    //스택에 데이터 추가
	    stack.push("마리오 캠페스");
	    stack.push("디에고");
	    stack.push("가브리엘");
	    stack.push("메시");
	    System.out.println(stack);
	    System.out.println(stack.pop());
	    
	    //데이터를 sort 된 것처럼 저장
	    Queue <String> queue = new PriorityQueue<>();
	    queue.offer("조규성");
	    queue.offer("손흥민");
	    queue.offer("김영권");
	    queue.offer("이강인");
	    queue.offer("이승우");
	    System.out.println(queue);
	    //맨 앞 데이터를 지우면서 리턴
	    System.out.println(queue.poll());
	    
	    //저장 순서를 알 수 없는 Set 인스턴스 생성
	    Set <String> set = new HashSet<>();
	    //데이터 추가
	    set.add("백현");
	    set.add("준면");
	    set.add("세훈");
	    set.add("민석");
	    //동일한 데이터를 삽입 - equals 메서드로 비교해서
	    //true이면 삽입하지 않음
	    //Set은 데이터 삽입에 실패하면 false를 리턴하고
	    //성공하면 true를 리턴함
	    set.add("백현");
	    set.add("종인");
	    System.out.println(set);
	    set.add("경수");
	    System.out.println(set);
	    
	    //로또 번호 생성기 처럼
	    //1-45까지의 숫가 6개를 입력받아서 저장한 후 출력
	    //입력을 받을 때 1 ~ 45 사이의 숫자가 아니면 다시 입력하도록
	    //중복되는 숫자를 입력하면 다시 입력하도록 함
	    //데이터를 출력할 때는 정렬을 해서 출력
	    
	    //숫자 6개를 저장할 공간을 생성
	    //중복 검사가 수월하고 정렬을 수행하면서 삽입하는 TreeSet을 이용
	    
	    //배열을 이용하는 경우
	    
	    //입력받기 위한 인스턴스 생성
	    /*Scanner sc = new Scanner(System.in);
	    //6개의 정수를 저장할 배열을 생성
	    int[] lotto = new int[6];
	    
	    int len = lotto.length;
	    for(int i=0; i<len; i++) {
	    	try {
	    		System.out.print("로또 번호 입력:");
	    		lotto[i] = sc.nextInt();
	    		
	    		//1부터 45사이의 숫자만 입력받도록하기
	    		if(lotto[i] <1 || lotto[i] >45) {
	    			System.out.println("1-45 사이의 숫자만 입력하세요.");
	    			i--;
	    			//중복검사를 하지 않고 패스하기 위해서
	    			continue;
	    		}
	    		
	    		//데이터 중복 검사
	    		//첫번째부터 현재 데이터 앞까지 비교
	    		//중복이 발생했는지 체크하기 위한 변수
	    		boolean flag = false;
	    		int j=0;
	    		for(; j<i; j++) {
	    			//2개의 데이터가 같음
	    			if(lotto[i] == lotto[j]) {
	    				//중복되었다고 표시
	    				flag = true;
	    				break;
	    			}
	    		}
	    		//중복된 경우
	    		if(flag == true) {
	    			System.out.println("중복된 숫자 입니다.");
	    			i--;
	    		}
	    		
	    	}catch(Exception e) {
	    		//이번은 무효 - 인덱스를 뒤로 
	    		i--;
	    		sc.nextLine();
	    		System.out.println("숫자를 넣으세요 !!!");
	    	}
	    }
	    
	    //배열의 데이터 정렬
	    Arrays.sort(lotto);
	    //배열의 데이터를 출력
	    System.out.println(Arrays.toString(lotto));
	    
	    
	    //스캐너 정리
	    sc.close(); */
	    
	    /*//Set을 이용해서 구현
	    Scanner sc = new Scanner(System.in);
	    //중복된 데이터를 저장하지 않고 데이터를 정렬해서 저장하는
	    //자료구조 클래스
	    Set<Integer> set1 = new TreeSet<>();
	    //set에 6개의 데이터가 저장되지 않은 경우
	    while(set1.size()<6) {
	    	System.out.print("로또 번호 입력:");
	    	int temp1 = sc.nextInt();
	    	if(temp1 <1 || temp1 >45) {
    			System.out.println("1-45 사이의 숫자만 입력하세요.");
    			continue;
    		}
	    	//중복 검사
	    	boolean result = set1.add(temp1);
	    	//삽입에 실패하면 - 중복된 데이터라면
	    	if(result == false) {
	    		System.out.println("중복된 숫자를 입력하면 안됨");
	    	}
	    }
	    
	    System.out.println(set1);
	    
	    //배열로 사용
	    Integer [] lotto = (Integer[])set1.toArray();
	    System.out.println(Arrays.toString(lotto));
	    
	    //스캐너 정리
	    sc.close();*/
	    
	    //Map의 활용
	    //데이터의 종류가 1가지라면 Object 대신에 그 자료형을
	    //기재해도 됨
	    Map <String, Object> map = new HashMap<>();
	    //데이터 추가
	    map.put("name", "adam");
	    //데이터 가져오기
	    System.out.println(map.get("name"));
	    //중복된 키를 이용한 데이터 삽입 - 수정
	    map.put("name", "군계");
	    System.out.println(map.get("name"));
	    //없는 키를 이용해서 가져왔을 때 - 자바는 null
	    System.out.println(map.get("num"));
	    
	    //Value를 Object로 설정했을 때 사용
	    //Value를 삽입할 때 String 이지만
	    //Map을 만들때 Value의 type을 Object로 설정했기 떄문에
	    //get을 해서 데이터를 원상 복구하고자 하면 강제 형 변환을 해야함
	    String value = (String) map.get("name");
	    
	    //모든 키를 가져오는 것
	    Set <String> keys = map.keySet();
	    System.out.println(keys);
	}
}
