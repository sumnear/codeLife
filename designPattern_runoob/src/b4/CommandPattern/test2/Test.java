package designPattern_runoob.b4.CommandPattern.test2;

public class Test {
	public static void main(String[] args) {
		Receiver rec = new Receiver();
		Command cmd1 = new CommandFun1(rec);
		Command cmd2 = new CommandFun2(rec);
		Command cmd3 = new CommandFun3(rec);
		Invoker i = new Invoker();
		i.setCommand(cmd1);
		i.execute();
	}

}
