package my.spring.springweb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//0227
//Lombok - diet library
//코드의 양을 줄이기 위해 사용하는 library

//java bean 규약에 의해서 클래스가 정의되어야 함
//몇 개 되지 않으면 그냥 지금까지 쓰던대로 쓰면 됨
//사용을 위해 dependency 설정 해줘야 함

//하지만 필드가 많아지면 그만큼 코드가 길어짐
//그래서 lombok을 사용함

//lombok이 제공해주는 것
//@Getter / @Setter / @NoArgsConstructor / @AllArgsConstructor / @RequiredArgsConstructor / @NonNull
//@ToString / @EqualsAndHashCode

//클래스 위에만 쓸 수 있는 것은 아니고 각 필드에 대해서 개별적으로 적용해줄 수도 있음
@Getter
@Setter
@NoArgsConstructor //인자 없는 생성자 즉, default 생성자를 만들어주는 annotation
@AllArgsConstructor //현재 클래스 안에 있는 모든 필드들을 초기화할 수 있는 인자가 있는 생성자를 만들어줌
//특정 필드들만 초기화하는 생성자는 어떻게 만듬?
@RequiredArgsConstructor //이거 사용 @NonNull을 초기화하고 싶은 특정 필드를 선택해서 위에다가 붙여줌/당연히 @NonNull을 1개도 안 쓰면 default 생성자를 만들게 됨/@NoArgsConstructor 와 겹침
@ToString 
//일반적으로 toString에는 내가 가진 필드를 출력하기 위해서 사용
//오버라이딩된 toString Method를 자동으로 만들어줌(이 메소드 안의 내용은 자동으로 내가 가진 필드를 출력하는 내용이 담김)

@EqualsAndHashCode //객체의 내용을 비교하기 위한 Equals를 자동으로 생성해줌
//----------------------------------------------------------------------------------------------------------------------------------------------------
//그런데 이렇게 쓰는 것도 좀 많대 그래서 @Data가 등장 --> @Data만 써주면 @Getter / @Setter / @RequiredArgsConstructor / @ToString / @EqualsAndHashCode를 자동으로 적용
//@NoArgsConstructor / @AllArgsConstructor는 포함되지 않음

public class Member {

	@NonNull
	private String memberName;
	@ToString.Exclude //ToString으로 출력하고 싶지 않은 필드 위에다가 이런식으로 써줌
	private int memberAge;
	@NonNull
	private String memberAddr;
	

	
	
}
