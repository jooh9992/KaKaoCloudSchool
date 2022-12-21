package kakao.cloud.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//데이터 클래스 - VO
class VO1{
	private int number;
	private String name;
	public VO1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VO1(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "VO1 [number=" + number + ", name=" + name + "]";
	}
	
}

public class MapMain {
	public static void main(String[] args) {
		//데이터 생성 - 모델
		VO1 vo = new VO1(1, "main");
		
		//데이터 출력 - View
		//모델의 근원이 되는 VO 클래스 안에 속성 이름을 변경하면
		//View도 수정이 되어야 함
		//관계형 데이터베이스는 VO 클래스를 활용
		//System.out.println("번호:" + vo.getNum());
		//System.out.println("이름:" + vo.getName());
		
		//VO 클래스의 인스턴스 역할을 수행하는 Map을 생성
		/*Map <String, Object> map = new HashMap<>();
		//데이터 저장
		map.put("번호", 1);
		map.put("이름", "adam");
		
		//map의 모든 키를 가져와서 출력
		Set <String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key));
		}*/
		
		//배열의 배열 - 2차원 배열 : Matrix - 태그가 없음
		String [] f = {"리즈", "민지", "카리나"};
		String [] s = {"원영", "하니", "윈터"};
		String [] t = {"유진", "다니엘", "닝닝"};
		//이차원 배열 생성
		//팀이 추가되면 태그를 수정해야 함
		String[][] volley = {f, s, t};
		
		int i =0;
		for(String [] temp : volley) {
			if(i ==0) {
				System.out.print("최애:\t");
			}else {
				System.out.print("차애:\t");
			}
			for(String imsi : temp) {
				System.out.print(imsi + "\t");
			}
			System.out.println();
		}
		//이차원 배열 대신에 Map의 배열 - Table
		Map <String, Object> map1 = new HashMap<>();
		map1.put("name", "최애");
		map1.put("team", f);
		
		Map <String, Object> map2 = new HashMap<>();
		map2.put("name", "차애");
		map2.put("team", s);
		
		Map <String, Object> map3 = new HashMap<>();
		map3.put("name", "그담");
		map3.put("team", t);
		
		Map [] v = {map1, map2, map3};
		
		for(Map map : v) {
			System.out.print(map.get("name")+"\t");
			String[] temp = (String [])map.get("team");
			for(String imsi: temp) {
				System.out.print(imsi + "\t");
			}
			System.out.println();
		}
	}
}
