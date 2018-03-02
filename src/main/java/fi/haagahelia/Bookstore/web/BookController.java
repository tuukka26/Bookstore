package fi.haagahelia.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// Login screen
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// Show all books
	@RequestMapping("/booklist")
	public String books(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// Delete book
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../booklist";
	}
	
	// Add book
	@RequestMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	// Add category
	@RequestMapping("/addcat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcat";
		
	}
	
	// Save book
	@RequestMapping("/savebook")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	// Save category
	@RequestMapping("/savecat")
	public String saveCat(Category category) {
		crepository.save(category);
		return "redirect:booklist";
	}
	
	// Edit book
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	// RESTful service to get all books
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		
		return (List<Book>) repository.findAll();
	}
	
	// RESTful service to get book by id
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
		
		return (Book) repository.findOne(bookId);
	}
	
}
