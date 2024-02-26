package springIoc.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		//Application Context 부터 만들자
		//설정정보를 담은 것이 xml파일일 경우 ClassPathXmlApplicationContext라는 클래스를 이용하여 Application Context를 만듬 
//		ApplicationContext context = new ClassPathXmlApplicationContext("springIoc/sample1/applicationContext.xml");
		//원래는 이렇게 경로를 쭉 줘야 함
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", MessageBean.class);
		//하지만 컴마를 사용하여 컴마 뒤에 힌트를 줌 --> 즉, 컴마 뒤에 나오는 클래스가 있는 경로에서 xml를 찾도록 만들게 되는 것임
		
		MessageBean myBean = context.getBean("messageBean", MessageBean.class);
		MessageBean myBean1 = context.getBean("messageBean", MessageBean.class);
		//singleton인 경우 프로그램이 시작할 때 이미 만들어졌던 객체를 찾아서 리턴할 것이고
		//prototype인 경우는 이 시점에 Bean객체를 생성해서 리턴함/또한 후자의 경우 getBean을 사용할 때마다 새로운 객체를 만들어서 리턴하게 될 것(같은 설정으로 만들었지만 서로 별도로 존재하는 객체임)
		//id 식별자 뒤에 오는 클래스이름은 앞서 언급했듯이 형변환(casting)될 클래스임
		
		myBean.sayHello();
		
		System.out.println(myBean);
		System.out.println(myBean1);
		
		((ClassPathXmlApplicationContext)context).close();
		//ApplicationContext는 interface라서 close()를 가지고 있지 않아서 형변환하여 사용해야 함
		//casting보다 .close()가 우선순위가 높기 때문에 casting을 먼저 해주고 싶으면 괄호로 묶어줘야 함
		
	}
}
