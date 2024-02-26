package my.spring.springweb.sample09.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.spring.springweb.sample07.vo.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String name;
	private String addr;
}	
