package designPattern_runoob.b4.CommandPattern.test2;

public class CommandFun3 extends Command {

	public CommandFun3(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.function3();
	}

}
