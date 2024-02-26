package my.spring.springweb.sample01.vo;

//JavaBean 규약
//1. 기본 생성자는 쓰지 않더라도 있어야 함
//2. 모든 field는 private이어야 함
//3. 각 field를 사용하기 위해 public으로 되어 있는 setter, getter

//그리고 이 규약에 맞춰서 클래스를 만들고 클래스를 이용해서 인스턴스를 만들었을 때 이 필드를 property라고 한다.
public class User {
	
	private String name;
	private int age;
	
	public User() {
		
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



}
