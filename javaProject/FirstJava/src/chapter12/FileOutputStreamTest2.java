package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest2 {

	public static void main(String[] args) {

		try {
			OutputStream fout = new FileOutputStream("D:\\test\\test1.txt");

			
		
			String str = "HI";

			byte[] arr = str.getBytes();//  getBytes()역할은 String 클래스에서 문자열의 byte배열을 반환
			fout.write(arr);
			
			fout.close(); // I/O에서는 스트림 사용 후 반드시 닫아준다!!!!
			System.out.println("파일에 데이터 쓰기 성공!!");
		} catch (FileNotFoundException e) { // FileNotFoundException없어도됨 why? FileNotFoundException이 IOException을 상속해서
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
