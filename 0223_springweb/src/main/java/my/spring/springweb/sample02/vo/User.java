package my.spring.springweb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//코드로 getter Setter 안 만들어주고 이 어노테이션들만 써주면 자동으로 만들어줌
//@Setter 
//@Getter
//
//@NoArgsConstructor //default 생성자 자동으로 만들어줌
//@AllArgsConstructor //필드를 이용한 오버로딩 생성자 만들어줌
//@ToString //오버라이딩된 toString 만들어줌

//얘네조차도 다 쓸 필요없이 @Data만 써주면 위에 있는 기능들 다 넣어줌
//한번에 해주는 건 좋지만 굳이 쓰지도 않는 메소드들도 같이 들어온다는 단점도 있긴 함
@Data
public class User {
	
	private String userName;
	private String userAge;
	private String userDept;
	private String userAddress;
	
}
