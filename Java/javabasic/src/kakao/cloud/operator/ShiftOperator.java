package kakao.cloud.operator;

public class ShiftOperator {
	public static void main(String[] args) {
		int x = -29;
		System.out.println(x << 2); //1번 밀때 마다 2곱하기 
		System.out.println(x >> 3); //1번 밀때 마다 2 나누기
		System.out.println(x >>> 3); //부호 변경
		System.out.println(x << 33);
		//32로 나눈 나머지 만큼 밀기
	
	}
}
