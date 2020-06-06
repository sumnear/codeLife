package designPattern_runoob.b4.CommandPattern.test;

public class CommandImpl extends Command {

	public CommandImpl(Receiver receiver) {
		super(receiver);
	}

	public void execute() {
		receiver.receive();
	}
}
