package kakao.cloud.controlstatement;

public class While {
	public static void main(String[] args) {
		int tot = 0;
		int i = 0;
		
		 do{
			//반복할 내용
			tot = tot + i;
			i = i+1;
		}while(i<=10);
		System.out.println("합계: " + tot);
		
		for(int i1 =0, j1=0; i1<10&&j1<5; i1++, j1=j1+2) {
			System.out.println(i1);
			System.out.println(j1);
		}
		
		String[] names = {"aespa", "redvelvet", "f(x)"};
		for(String name : names) {
			System.out.println(name);
		}
		
		int x1 =10;
		/*메서드 안에서 만든 변수를 다시 만들려고 하면 에러
		for(int x = 0; x<10; x++) {
			System.out.println(x);
		}*/	
		//제어문 안에서 만든 변수는 자신의 제어문 수행이 끝나면 소멸됨
		for(int y=0; y<10; y++) {
			System.out.println(y);
		}
		for(int y=0; y<10; y++) {
			System.out.println(y);
		}
		int y =100;
		
		switch(y) {
			//int k=1; switch는 안에서 변수 만드는게 안됨
			case 1:
				break;
		}
		
		for(int i1=0; i1<10; i1++) {
			System.err.println(i1);
			if(i1 == 3) 
				break;
			//뒤에 코드를 실행 할 필요가 없다면 return으로 대체 가능
			//return;
		}
		
	}
}
