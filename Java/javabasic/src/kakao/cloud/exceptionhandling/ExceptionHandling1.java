package kakao.cloud.exceptionhandling;

public class ExceptionHandling1 {
	//이 메서드를 다른 곳에서 호출할 떄는 ArithmeticException을 핸들링해야함
	//실제로는 이 메서드 안에서 ArithmeticException
	public static void exception() throws ArithmeticException {
		int kor = 10;
		int eng = 120;
		if(kor > 100 || eng > 100) {
			//강제로 예외를 발생시키는 것
			throw new ArithmeticException("점수는 100보다 작거나 같아야 함");
		}
		double avg = (kor + eng) /2;
		System.out.println(avg);
	}
	public static void main(String[] args) throws Exception {
		exception();
		//Thread 클래스의 sleep이라는 메서드는
		//지정한 시간 동안 현재 스레드의 수행을 중지하는 역할을 해주는 메서드임
		//public static void sleep(long millis) throws InterruptedException
		//이 메서드를 사용할 떄는 Interrupted Exception을 처리해야 함
		Thread.sleep(3000);
	}
}
