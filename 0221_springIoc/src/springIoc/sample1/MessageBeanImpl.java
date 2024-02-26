package springIoc.sample1;

public class MessageBeanImpl implements MessageBean{
	
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 객체로 생성");
		//생성자 injection을 하면서 객체를 생성할 경우 이것은 호출되지 않을 것임
	}
	
	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
		System.out.println("오버로딩된 MessageBeanImpl 생성자 호출 /  과일이름은 : " + fruit);
	}
	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
		System.out.println("오버로딩된 MessageBeanImpl 생성자 호출 /  과일이름은 : " + fruit +" 가격은 : "+ cost);
	}
	
	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setter 호출!! " + cost);
	}

	@Override
	public void sayHello() {
		System.out.println(fruit + ", " + cost);
	}
//원래는 Bean은 안에 상태값(필드 같은 애들)이 없어야 하지만 일단은 제껴두고 생각하자
}
