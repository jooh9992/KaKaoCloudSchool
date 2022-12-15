package kakao.cloud.controlstatement;

import java.util.Scanner;

public class SwitchMenu {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("메뉴 입력( 1 ~ 3): ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("중식");
				break;
			case 2:
				System.out.println("한식");
				break;
			case 3:
				System.out.println("분식");
				break;
			default:
				System.out.println("다이어트");
				break;
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
