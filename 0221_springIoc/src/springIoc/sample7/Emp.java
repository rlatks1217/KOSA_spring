package springIoc.sample7;

public class Emp {
	
	private String name;
	private int salary;
	
	public Emp() {
		System.out.println("Emp default 생성자 호출");
	}
	public Emp(String name, int salary) {
		this.name = name;
		this.salary = salary;
		System.out.println("Emp 오버로딩 생성자 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
