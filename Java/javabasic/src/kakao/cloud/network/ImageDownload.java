package kakao.cloud.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownload {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				try {
					//다운로드 받을 URL을 생성
					String addr = "http://image.newsis.com/2022/12/02/NISI20221202_0001144236_web.jpg";
					//확장자 추출
					//.은 \와 함께 기재해야 함
					String [] ar = addr.split("\\.");
					String ext = ar[ar.length-1];
					System.out.println(ext);
					
					URL url = new URL(addr);
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("GET");
					con.setConnectTimeout(30000);
					con.setUseCaches(false);
					
					//읽어올 바이트 스트림 생성
					InputStream in = con.getInputStream();
					//읽은 내용을 저장할 파일 스트림을 생성
					FileOutputStream fos = new FileOutputStream("candy."+ext);
					File f = new File("candy."+ext);
					if(f.exists()) {
						System.out.println("이미 파일이 존재함");
						return;
					}
					
					while(true) {
						//데이터를 저장할 바이트 배열 생성
						byte [] raster = new byte[512];
						//바이트 배열에 읽어서 저장
						int len = in.read(raster);
						//읽은 데이터가 없으면 종료
						if(len <= 0) {
							break;
						}
						//읽은 내용을 파일에 기록
						fos.write(raster, 0, len);
					}
					in.close();
					fos.close();
					con.disconnect();
					
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		}.start();
	}
}
