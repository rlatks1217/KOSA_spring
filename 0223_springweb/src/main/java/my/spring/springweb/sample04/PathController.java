package my.spring.springweb.sample04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

	@RequestMapping(value = "/character/detail/{name}/{number}")
	// {name}/{number}와 같이 변수를 지정해 줄 수 있음 -- @PathVariable("변수명")로 해당 변수명을 통해 데이터를
	// 받음 -> 이 경우에는 url에 포함된 문자열을 값으로 사용할 때 사용이 가능
	public String myMethod1(@PathVariable("name") String name, @PathVariable("number") int num, Model model) {

		if (name.equals("kakao")) {
			if (num == 1) {
				model.addAttribute("img", "ryan");
			} else if (num == 2) {
				model.addAttribute("img", "apeach");
			} else if (num == 2) {
				model.addAttribute("img", "frodoneo");
			}
		}

		if (name.equals("line")) {
			if (num == 1) {
				model.addAttribute("img", "brown");
			} else if (num == 2) {
				model.addAttribute("img", "james");
			} else if (num == 2) {
				model.addAttribute("img", "cony");
			}			
		}

		return "sample04/detailView";
	}
}
