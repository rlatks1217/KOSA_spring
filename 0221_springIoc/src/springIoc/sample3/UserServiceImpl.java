package springIoc.sample3;

//인터페이스를 구현하는 클래스명을 작성할 때는 인터페이스명+Impl을 붙여서 짓는 게 관용적임
public class UserServiceImpl implements UserService {

	//원래는 Service 역할을 하는 객체에는 필드가 존재하면 안됨(Service도 원래는 Bean으로 등록하여 공유해서 사용하므로)
	private User user;
	
	public UserServiceImpl() {
		
	}
	
	public UserServiceImpl(User user) {
		this.user = user;
		System.out.println("UserServiceImpl 생성자 호출"+ user);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void addUser(User user) {
		//일반적인 Bussiness Logic 처리가 나오면 돼요! 지금은 테스트니까 sysout만 있는 거임
		System.out.println("UserServiceImpl - addUser() 메소드 호출!" + user);
	}

	
}
