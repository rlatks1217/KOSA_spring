package springIoc.anno.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood") //default bean id = myFoodMgr 하지만 이렇게 괄호 안에 내가 지어주고 싶은 id를 써줄 수도 있음
public class MyFoodMgr {
	
	@Autowired
	//@Qualifier(value="favoriteFood")
	//favoritFood라는 이름을 가진(정확히는 id를 가진) Bean을 찾아서 주입하게 됨
	private Food favoriteFood;
	@Autowired
	private Food unFavoriteFood;
	
	public MyFoodMgr() {
		System.out.println("MyFoodMgr default 생성자 호출!");
	}
	
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}


	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return favoriteFood + " , " + unFavoriteFood;
	}
}
