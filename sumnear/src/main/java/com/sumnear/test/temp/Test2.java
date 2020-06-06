package test.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) throws IOException {
		File a = new File("C:\\Users\\Near\\Desktop\\a.txt");
		FileInputStream fis = new FileInputStream(a);
		byte[] b = new byte[1];
		while(fis.read(b)>-1){
			System.out.println(Arrays.toString(b));
//			for (int i = 0; i < b.length; i++) {
//				System.out.print(b);
//			}
		}
	}

	private static String convertByte2Hex(byte b) {
		String hex = "";
		try {
			int number = b & 0x00ff;
			// ²¹Áã
			if (number < 16) {
				hex = "0" + Integer.toHexString(number);
			} else {
				hex = Integer.toHexString(number);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return hex;
		}
	}
}
