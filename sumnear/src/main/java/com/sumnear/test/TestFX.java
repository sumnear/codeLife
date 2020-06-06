package test;

import java.util.ArrayList;
import java.util.List;

class ClassA {
	public String field1;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

}

class ClassB extends ClassA {
	private String field2;

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
}

public class TestFX {
	public static void main(String[] args) {
		List<ClassA> list = new ArrayList<>();
		ClassB b1 = new ClassB();
		b1.setField2("aaa");
		b1.setField1("bbb");
		list.add(b1);
		ClassA a = list.get(0);
		System.out.println(a.getField1());
		if (a instanceof ClassB) {
			System.out.println(((ClassB) a).getField2());
		}
	}
}
