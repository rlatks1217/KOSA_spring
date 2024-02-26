package springIoc.sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml", Monday.class);
		 //추상 클래스는 Bean으로 만들 수 없음 --> 생성자를 호출할 수 없는 상태이기 때문에 그래서 Factory-method를 이용한다.
		 AbstractDay day = context.getBean("day", AbstractDay.class);
		 String today = day.dayInfo();
		 
		 System.out.println(today);
		 
		 ((ClassPathXmlApplicationContext)context).close();
		 
	}
}
