package designPattern_runoob.b4.CommandPattern.test2;

public class CommandFun1 extends Command {

	public CommandFun1(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.function1();
	}

}
