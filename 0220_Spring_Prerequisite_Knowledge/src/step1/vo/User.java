package step1.vo;

//JavaBeans라는 규약이 있음(쉽게 말해 클래스를 작성하는 규칙임)
//1. 인자가 없는 기본생성자가 존재해야 함(명시되어야 함) -> 쓰던 쓰지 않던 무조건 명시하기
//2. 필드는 private으로 설정
//3. getter,setter도 당연히 필요함/접근제어자는 public으로 설정되어야 함

//즉, 우리가 여태 만들고 있던 VO들은 사실 모두 Java Bean이라고 할 수 있음
public class User {
	
	private String id;
	private String password;
	private String name;
	
	public User() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
