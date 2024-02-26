package springIoc.sample3;

public interface UserService {
	
	void addUser(User user);
	
//1. Service의 기능을 구현할 때 method 이름의 통일성을 부여하기 위해서 interface 형태로 만들고 이것을 implements하는 형태로 많이들 구현한다고 함
//--> 당연히 method명이 통일되어 있기 때문에 유지보수성이 높아지는 효과가 있음
//2. Service 객체를 Injection 해줘야 하는 경우 어제 수업했던 것처럼 클래스 간의 의존성을 떨어뜨리기 위해서 사용하기도 함(이게 가장 큰 이유일 것이라는 게 교수님의 결론)
}
