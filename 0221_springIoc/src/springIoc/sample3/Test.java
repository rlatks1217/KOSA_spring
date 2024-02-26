package springIoc.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		 //Application Context를 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml", User.class);
		
		UserService service = context.getBean("userService_1", UserService.class);
		
		User user = context.getBean("obj2", User.class);
		
		service.addUser(user);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
