package kakao.cloud.oop;

public class Main {
	public static void main(String[] args) {
		//Student 클래스의 인스턴스 생성
		Student student = new Student();
		//자신의 속성에 접근
		student.num = 1;
		student.name = "아이린";
		student.kor = 32;
		student.eng = 19;
		student.mat = 40;
		
		Student student1 = new Student();
		student1.num = 2;
		//인스턴스 속성은 인스턴스 별로 별도로 소유
		System.out.println(student.num);
		System.out.println(student1.num);
		

		/*//자바는 static 속성에 인스턴스가 접근 가능
		student.schooleName = "명덕고등학교";
		student1.schooleName = "제일중학교";
		//static 속성은 모든 인스턴스가 공유하므로 동일한 데이터가 출려됨
		System.out.println(student.schooleName);
		System.out.println(student1.schooleName);*/
		
		//final int x;
		//x = 10;
		
		//static 메서드는 클래스 이름으로 호출 가능
		MethodClass.method1();
		//클래스 이름을 가지고 메서드 호출 불가
		//MethodClass.method2();
		
		//인스턴스 메서드 호출
		MethodClass methodClass = new MethodClass();
		methodClass.method2();
		//자바는 인스턴스를 이용해서 static 메서드 호출 가능
		methodClass.method1();
		
		//참조형 변수를 만들지 않고 인스턴스를 만들어서 메서드 호출
		//한 번만 사용하는 인스턴스는 이름을 만들지 않는 것이 좋음
		new MethodClass().method2();
		
		MethodClass.noArgsMethod();
		MethodClass.oneArgsMethod(3);
		MethodClass.twoArgsMethod(2, "Message");
		MethodClass obj = new MethodClass();
		//리턴된 결과 가져오기
		int result = obj.addWithInteger(10, 30);
		System.out.println("결과: " +result);
		//리턴된 결과를 가지고 다른 작업을 수행할 수 있음
		result = obj.addWithInteger(result, 90);
		System.out.println("결과: " +result);
		
		
		int x =10;
		MethodClass.callByValue(x);
		//기본형을 메서드에게 넘겨준 경우는 데이터가 변경되지 않음
		System.out.println("x:"+x);
		
		int [] br = {10,20,30};
		MethodClass.callByReference(br);
		//배열을 메서드에게 넘기면 배열의 내용이 변경될 수 있음
		//메서드의 리턴이 없는 경우라면 print 메서드를 제외하고는
		//원본을 변경해주는 것
		System.out.println("br[0]:" + br[0]);
		
		MethodClass  o1 = new MethodClass();
		o1.thisMethod();
		
		//20번째 피보나치 수열의 값
		int f = MethodClass.noRecursionFibonacci(100);
		System.out.println("f:"+f);
		
		f = MethodClass.recursionFibonacci(100);
		System.out.println("f:" +f);
		
		//매개변수의 개수를 가변으로 설정
//		public static void diasau() {
//			for string
//		}
		
	}
}
