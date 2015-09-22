package guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping (value = "/guest")
	@ResponseStatus (value= HttpStatus.OK)
	public String addComment(@RequestParam("name") String name , @RequestParam("comment") String comment, Model model ){
		User user = new User (name, comment);
		model.addAttribute("result",userRepository.save(user));
 
		return "success";
	}
	
	
}
