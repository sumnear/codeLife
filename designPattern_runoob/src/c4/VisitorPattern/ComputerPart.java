package designPattern_runoob.c4.VisitorPattern;

public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}
