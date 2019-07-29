package e7.command_chain.command_name1.ls;


import e7.command_chain.CommandVO;
import e7.command_chain.command_name1.os.FileManager;

/**
 * @author cbf4Life cbf4life@126.com I'm glad to share my knowledge with you
 *         all. 命令名后面不跟参数
 */
public class LS extends AbstractLS {

	// 最简单的ls命令
	protected String echo(CommandVO vo) {
		return FileManager.ls(vo.formatData());
	}

	// 参数为空
	protected String getOperateParam() {
		return super.DEFAULT_PARAM;
	}

}
