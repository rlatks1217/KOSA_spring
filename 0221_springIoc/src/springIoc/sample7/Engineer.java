package springIoc.sample7;

public class Engineer {
	
	private Emp emp;
	private String dept;

	public Engineer() {
		// TODO Auto-generated constructor stub
	}
	
	//상속을 통한 사용보다 이렇게 필요한 객체를 주입받아 사용하는 게 더 좋아요!
	public Engineer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}
	
}
