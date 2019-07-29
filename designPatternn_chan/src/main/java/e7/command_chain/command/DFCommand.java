package e7.command_chain.command;


import e7.command_chain.CommandVO;
import e7.command_chain.command_name1.df.AbstractDF;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class DFCommand extends Command {

	@Override
	public String execute(CommandVO vo) {
		return super.buildChain(AbstractDF.class).get(0).handleMessage(vo);
	}

}
