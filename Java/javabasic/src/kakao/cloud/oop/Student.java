package kakao.cloud.oop;

public class Student {
	public static String schoolName;
	
	//static 초기화
	static {
		System.out.println("로고 출력");
		//static 변수 사용 가능
		schoolName ="";
		//인스턴스 속성 사용 불가
		//num =1;
	}
	public final int x;
	public Student() {
		x =10;
	}
	
	//인스턴스 속성 생성
	//접근 지정자가 public이므로 외부에서 인스턴스를 통해서 접근
	protected int num;
	//protected도 사용가능 
	public String name;
	public int kor;
	public int eng;
	public int mat;

}
