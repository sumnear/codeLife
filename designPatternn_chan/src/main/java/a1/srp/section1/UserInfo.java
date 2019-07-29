package a1.srp.section1;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 * 用户管理的实现类
 */
public class UserInfo implements IUserInfo {
	private String userName;
	private String userID;
	private String password;

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String getUserID() {
		return userID;
	}
	
	@Override
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 修改用户密码
	 * @param oldPassword
	 * @return
	 */
	@Override
	public boolean changePassword(String oldPassword){
		System.out.println("密码修改成功...");
		return true;
	}

	/**
	 * 删除用户
	 */
	@Override
	public boolean deleteUser(){
		System.out.println("删除用户成功...");
		return true;
	}

	/**
	 * 用户映射
	 */
	@Override
	public void mapUser(){
		System.out.println("用户映射成功...");
	}
}
