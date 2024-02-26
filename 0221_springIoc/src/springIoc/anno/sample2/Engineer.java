package springIoc.anno.sample2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engineer {

//	@Autowired
//	@Qualifier(value="emp1")

//결국에는 위에 두 가지 기능을 합쳐놓은 게 @Resource임
	@Resource(name="emp1")
	private Emp emp;
	
	private String dept;

	public Engineer() {
		System.out.println("Engineer Default 생성자 호출!");
	}
	
	@Autowired(required=false)
	public Engineer(String dept) {
		this.dept = dept;
		System.out.println("Engineer overloading 생성자 호출!");
	} 
	//생성자의 경우 required false가 안 됨 주입되는 객체가 없으면 오류를 뱉음
	//근데 지금은 주입되는 객체가 없으니까 그냥 default 생성자를 호출하고 있음
	
//	@Autowired
//	public void my_dept(String dept) { //dept라는 id를 가진 Bean을 찾아 인자로 넣어주게 됨
//		this.dept = dept;
//		System.out.println("얘는 일반 메소드에요");
//	}

//	public void setEmp(Emp emp) {
//		this.emp = emp;
//	}
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//setter는 없어도 됨 --> @Autowired는 setter 이름이 아니라 필드 이름을 id를 가진 Bean을 찾아 주입해주는 기능인 것을 알 수 있음
	
	@Override
	public String toString() {
		return emp + "," + dept;
	}
}
