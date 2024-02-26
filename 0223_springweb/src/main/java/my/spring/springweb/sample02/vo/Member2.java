package my.spring.springweb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//보통 이렇게만 쓴다
public class Member2 {

	private String name;
	private String phone;
	private String id;
	private String pw;
}
