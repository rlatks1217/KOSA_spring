package my.spring.springweb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	//이 클래스가 Bean으로 만들어지면 이 메소드가 자동을 호출됨
	//Root application Context가 인자로 들어옴

}
