package fi.haagahelia.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/index")
	public String books(Model model) {
		model.addAttribute("books");
		return "index";
	}
}
