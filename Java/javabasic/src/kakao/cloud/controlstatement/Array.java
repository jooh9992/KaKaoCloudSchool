package kakao.cloud.controlstatement;

import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		//데이터를 가지고 배열 생성
		String [] soccers= {"손흥민", "이강인", "조규성","황희찬"};
		//배열의 데이터 순회
		int len = soccers.length;
		for(int i=0; i<len; i=i+1) {
			String imsi = soccers[i];
			System.out.println(imsi);
		}
		
		//생성하고 데이터를 대입
		int [] ar = new int[3]; //숫자는 0으로 초기화
		ar[0] = 20;
		ar[1] = 30;
		
		//배열의 순회
		for(int temp:ar) {
			System.out.printf("%5d", temp);
		}
		
		try{
			int [] br = null;
			System.out.println(br[0]);
			
		}catch(Exception e) {
			
		}
		//System.out.println(soccers[20]);
		System.out.println("종료");
		
		//2차원 배열
		String [][] programmers = {{"데니스", "비야네", "아네르스"},{"로섬", "고슬링", "톰슨"}};
		System.out.println(programmers.length);//행의 개수
		System.out.println(programmers[0].length); //열의 개수
		
		for(String [] arr: programmers) {
			for(String designer : arr) {
				System.out.print(designer + "\t");
			}
			System.out.println();
		}
		
		String[] langugeDesigner = {"데니스", "비야네", "아네르스","로섬", "고슬링", "톰슨"};
		for (int i=0; i<langugeDesigner.length; i++) {
			System.out.print(langugeDesigner[i] +"\t");
			if(i%3 ==2) System.out.println();
		}
		
		String [] arr2 = {"카리나", "웬디", "지젤"};
		//위의 배열의 내용을 가지고 데이터를 1개 추가한 배열을 생성
		String [] br = new String[ar.length +1];
		//배열의 요소 복제
		for(int i =0; i<arr2.length; i++) {
			br[i] = arr2[i];
		}
		//배열 복제
		String [] cr = Arrays.copyOf(arr2, arr2.length+1);
		cr[3] = "닝닝";
		//배열을 요소들을 하나의 문자열로 생성
		System.out.println(Arrays.toString(cr));
		
		//문자열을 오름차순 정렬
		Arrays.sort(cr);
		System.out.println(Arrays.toString(cr));
		
	}
}
