package kakao.cloud.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class ByteStreamMain {
	public static void main(String[] args) {
		/*
		//파일에 바이트 단위로 기록
		try(FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\user\\Documents\\KaKaoCloudSchool\\Java\\javabasic\\sample.txt", true)) {
			//파일에 기록할 내용만들기
			String msg = "Hello Java";
			fos.write(msg.getBytes());
			fos.flush();
		} catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}*/
		
		//파일의 내용을 바이트탄위로 읽기
		/*try(FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\KaKaoCloudSchool\\Java\\javabasic\\sample.txt")){
			while(true) {
				//읽을 수 있는 크기로 바이트 배열 생성
				byte [] b = new byte[fis.available()];
				int len = fis.read(b);
				if(len <= 0) {
					System.out.println("읽은 데이터 없음");
					break;
				}else {
					//숫자 배열 출력 - 텍스트가 아닌 경우
					System.out.println(Arrays.toString(b));
					//문자열로 변환해서 출력 - 텍스트인 경우
					System.out.println(new String(b));
				}
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}*/
		
		/*try(PrintStream ps = new PrintStream(
				new FileOutputStream("C:\\Users\\user\\Documents\\stream.txt", true))){
			String msg = "Hello Stream";
			//write는 바이트 단위 기록
			ps.write(msg.getBytes());
			//print는 문자열을 스스로 바이트로 변환해서 기록
			ps.print(msg);
			ps.flush();
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}*/
		
		/*try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream("C:\\\\Users\\\\user\\\\Documents\\\\stream.txt"))){
			while(true) {
				//파일에서 읽을 수 있는 크기로 바이트 배열을 생성
				byte [] b = new byte[bis.available()];
				//읽기
				while(bis.read(b)>0) {
					System.out.println(Arrays.toString(b));
					//문자열로 변환
					System.out.println(new String(b));
				}
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}*/
		
		try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream("C:\\\\Users\\\\user\\\\Documents\\\\stream.txt"))){
			//나누어서 읽기 - 웹에서 파일 다운로드 받을 때 사용	
			while(true) {
				//16바이트 단위로 읽어오기
				//일반적으로 128 또는 128의 배수를 많이 이용
				byte [] b = new byte[16];

				int len = bis.read(b, 0, b.length);
				if(len <= 0) {
					break;
				}
				//받은 내용을 가지고 작업
				//다운로드라면 파일에 기록
				//문자열이라면 하나로 모아서 읽어야 함
				System.out.println(new String(b));
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
