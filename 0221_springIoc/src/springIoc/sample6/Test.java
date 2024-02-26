package springIoc.sample6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		//Application Context 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", Output.class);
		
		MessageBean bean = context.getBean("myBean", MessageBean.class);//MessageBean 형태로 형변환(형변환할 타입이 인터페이스 타입이더라도 .class라고 씀)
		
		bean.sayHello();
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
