package designPattern_runoob.b4.CommandPattern.test2;

public class CommandFun2 extends Command {

	public CommandFun2(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.function2();
	}

}
