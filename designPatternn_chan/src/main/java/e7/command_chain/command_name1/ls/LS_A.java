package e7.command_chain.command_name1.ls;


import e7.command_chain.CommandVO;
import e7.command_chain.command_name1.os.FileManager;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all.
 */
public class LS_A extends AbstractLS {
	// ls -a命令
	protected String echo(CommandVO vo) {
		return FileManager.ls_a(vo.formatData());
	}

	protected String getOperateParam() {
		return super.A_PARAM;
	}

}
