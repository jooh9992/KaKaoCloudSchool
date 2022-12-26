package kakao.cloud.io;

import java.io.File;
import java.util.Date;

public class FileInformatingMain {
	public static void main(String[] args) {
		//File 객체 생성
		File f = new File("C:\\Users\\user\\Documents\\카카오톡 받은 파일\\thread.txt");
		//파일의 존재 여부
		if(f.exists() == true) {
			System.out.println("파일의 크기:" + f.length());
			System.out.println("마지막 수정 날짜:" + f.lastModified());
			Date date = new Date(f.lastModified());
			System.out.println("마지막 수정날짜: "+ date);
		}else {
			System.out.println("파일이 존재하지 않음");
		}
	}
}
