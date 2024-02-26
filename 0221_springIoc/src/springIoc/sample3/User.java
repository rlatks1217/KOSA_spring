package springIoc.sample3;

public class User {
	
	private String userName;
	
	public User() {
		System.out.println("User의 기본생성자 호출!");
	}
	
	public User(String userName) {
		this.userName = userName;
		System.out.println("User의 오버로딩된 생성자 호출!" + userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("User의 setter 호출"+ userName);
	}

	public String getUserName() {
		return userName;
	}
	//일반적으로 사용하지 않는 getter setter는 만들지 않는다.
	
	
}
