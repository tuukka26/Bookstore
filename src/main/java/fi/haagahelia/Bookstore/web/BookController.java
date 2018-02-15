package fi.haagahelia.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;
import fi.haagahelia.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	CategoryRepository crepository;

	@RequestMapping("/index")
	public String books(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../index";
	}
	
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping("/addcat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcat";
		
	}
	
	@RequestMapping("/savebook")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	@RequestMapping("/savecat")
	public String saveCat(Category category) {
		crepository.save(category);
		return "redirect:index";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	
}
