package springIoc.sample6;
//이 MessageBeanImpl 역시 어딘가에 주입될 상황이 있을 수 있으니 클래스 간의 의존성을 떨어뜨리기 위해 인터페이스를 구현하는 형태로 작성하고 있음
public class MessageBeanImpl implements MessageBean{

	private String name;
	private String phone;
	private Output output; //이 변수가 어떤 구현 객체를 가리키느냐에 따라 찍는 문자열이 달라질 것
	//Class 간의 의존성을 줄이기 위해 interface 타입으로 받는다.
	
	public MessageBeanImpl() {
		System.out.println("MessageImpl default 생성자 호출");
	}
	
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("MessageImpl 생성자 호출 " + name);
	}
	
	//생성자로 다 받아도 상관은 없지만 이것도 해보자 라는 의미해서 setter로 받을 거임
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("MessageImpl  phone setter 호출 " + phone);
	}

	public void setOutput(Output output) {
		this.output = output;
		System.out.println("MessageImpl output setter 호출 " + output);
	}

	@Override
	public void sayHello() {
		String msg = name + " : " + phone;
		
		//어디선가는 결국 exception 처리를 해야 하므로 그냥 여기서 해주자
		try {
			output.print(msg);
			//output이 가리키는 파일 안에다가 문자열을 적을 수 있음 
			// output.print(입력할 문자열)할 때 output이 가리키는 파일 경로에 파일이 없으면 오류가 날 수 있음 그래서 예외처리가 강제됨
			System.out.println("메세지 출력 종료!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
