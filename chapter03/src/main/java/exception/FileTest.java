package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("hello.txt"); // 핵심
			int data = fis.read(); // 핵심
			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println("error:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
//		} catch (Exception e) {
//			System.out.println("error:" + e);
		} finally {
			try {
				if(fis != null) {
					fis.close(); // 핵심
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
