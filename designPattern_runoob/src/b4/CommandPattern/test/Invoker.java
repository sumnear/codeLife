package designPattern_runoob.b4.CommandPattern.test;

public class Invoker {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		command.execute();
	}
}
