package e7.command_chain.command;


import e7.command_chain.CommandVO;
import e7.command_chain.command_name1.CommandName;
import e7.command_chain.command_name1.ls.AbstractLS;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class LSCommand extends Command {

	@Override
	public String execute(CommandVO vo) {
		// 返回链表的首节点
		CommandName firstNode = super.buildChain(AbstractLS.class).get(0);
		return firstNode.handleMessage(vo);
	}

	public static void main(String[] args) {
		System.out.println(LSCommand.class.getName());
	}
}
