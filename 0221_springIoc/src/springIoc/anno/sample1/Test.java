package springIoc.anno.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", Food.class);
		
		MyFoodMgr obj = context.getBean("myFood", MyFoodMgr.class);
		
		System.out.println(obj);
		//System.out.println()은 문자열로 찍어야 하기 때문에 괄호 안에서 자동으로 toString()을 호출함 그래서 obj.toString()이 1차로 호출됨 -> 이걸 overriding 한 거임
		//그런데 반환되는 값은 favoriteFood + " , " + unFavoriteFood인데 여기서 원래 문자열이 아닌 favoriteFood, unFavoriteFood은 각각 또다시 toString()을 호출함
		//결국에는 toString을 총 3번 호출하게 되는 거지(1번은 MyFoodMgr에서 오버라이딩한 toString(), 나머지 두 번은 Food에서 오버라이딩한 toString())
		((ClassPathXmlApplicationContext)context).close();
	}
}
