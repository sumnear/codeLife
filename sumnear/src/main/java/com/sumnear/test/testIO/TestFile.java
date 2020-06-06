package test.testIO;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class TestFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5646862455682968266L;
	public static void main(String[] args) {
		try {
			test2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test1() throws IOException{
		FileInputStream fis = new FileInputStream("./");
		FileDescriptor fd  = fis.getFD();
		fd.sync();
	}
	private static void test2() throws IOException{
		FileOutputStream fos = new FileOutputStream("D:/aaa.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestFile tf = new TestFile();
		oos.writeObject(tf);
		oos.flush();
		oos.close();
		FileInputStream fis = new FileInputStream("D:/aaa.dat");
		byte[] a = new byte[1024];
		while(fis.read(a)!= -1){
			for(byte t : a){
				System.out.print(Integer.toHexString(t)+" ");
			}
			
		}
		}
		
		
}
