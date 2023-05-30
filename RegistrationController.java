package ineuron.SpringBoot03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegistrationController 
{
	  @GetMapping("/registration")
	  public String showRegistrationForm(Model model) 
	  {
	    model.addAttribute("user", new User());
	    return "registration";
	  }
	  
	  @PostMapping("/register")
	  public String register(User user) 
	  {
	    return "redirect:/login";
	  }
}
