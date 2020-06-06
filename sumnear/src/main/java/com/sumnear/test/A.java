package test;

 class B {
   public B(){
	   System.out.println("b cus");
	   Test();
   }
   public void Test(){
	   System.out.println("B");
   }

}

 public class A extends B{
	 public A(){
		 System.out.println("a cus");
		   Test();
	   }
		public void Test(){
			System.out.println("A");
		}
		public static void main(String[] args) {
			A a  = new A();

		}
	}