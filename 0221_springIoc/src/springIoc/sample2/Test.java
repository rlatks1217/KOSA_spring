package springIoc.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml", Foo.class);
		
		((ClassPathXmlApplicationContext)context).close();
		//닫아주지 않으면 Warning 뜸
	}
}
