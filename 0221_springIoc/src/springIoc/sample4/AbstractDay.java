package springIoc.sample4;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractDay {

	public abstract String dayInfo();
	
	//static 메소드는 추상 메소드가 될 수 없음! 왜? Method Area에 올라가는 시점에 실행될 수 있는 상태가 되어야 하는데 그러려면 그 시점에 초기화가 되어야 하기 때문에
	//반면에 추상 메소드는 하위 클래스가 구현부를 구현하고 그 클래스가 인스턴스가 될 때 메소드가 완성되는 방식

	
	
	//이 메소드를 통해 하위 클래스를 가지고 인스턴스를 만듦으로써 이 클래스에 대한 인스턴스도 만들어지는 것임
	//추상 클래스는 원래 생성자를 통해 객체로 만들 수 없지만 특정 메소드를 이용하여 객체를 생성하게 되는 것임 --> 이런 메소드를 Factory Method라고 함(말 그대로 객체를 공장처럼 찍어내는 역할을 하는 메소드라고 보면 됨)
	public static AbstractDay getInstance() {
		//오늘 날짜의 요일을 알아보아요
		GregorianCalendar calendar = new GregorianCalendar(); 
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		//해당 날짜에 대한 요일을 숫자로 알려줘요 1:월 /2:화/3:수/4:목 /5:금 이런 식
		
		AbstractDay myDay = null;
		
		switch (day) {
		case 1:
			myDay = new Sunday();
			break;
		case 2:
			myDay = new Monday();
			break;
		case 3:
			myDay = new Tuesday();
			break;

		default:
			break;
		}
	
		return myDay;
	}


}
