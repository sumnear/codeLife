package test.temp;

import java.util.HashMap;

public class Test3 {

	public static void main(String[] args) {
		int a =1/0;
		new F().funA();
		System.out.println(test1());
	}
	private static int test1(){
		int a = 1;
		try{
			return a;
		}finally{
			a+=1;
		}
	}

}
interface A{
	
}
interface B{
	
}
interface C{
	
}
interface D extends A,B,C{
	
}
abstract class E{
	synchronized void funA(){
		System.out.println("ddd");
		
	}
	
}

class F extends E{
	
}