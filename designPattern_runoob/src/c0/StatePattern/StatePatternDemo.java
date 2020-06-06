package designPattern_runoob.c0.StatePattern;

public class StatePatternDemo {
	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		StopState stopState = new StopState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}