package fi.haagahelia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;
import fi.haagahelia.Bookstore.domain.CategoryRepository;
import fi.haagahelia.Bookstore.domain.User;
import fi.haagahelia.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			log.info("Save a few categories and books");
			Category c1 = new Category("Fiction");
			Category c2 = new Category("Satire");
			Category c3 = new Category("Beat generation");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			
			Book book1 = new Book("A Farewell to Arms", "Ernest Hemingway", "12341234-12", 1929, 9.99, c1);
			Book book2 = new Book("The Master and Margarita", "Mikhail Bulgakov", "0-14-118014-5", 1967, 19.99, c2);
			Book book3 = new Book("On the Road", "Jack Kerouac", "121234-99", 1929, 12.99, c3);
			
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			// Creating users: admin/admin, user/user
			User user1 = new User("user", "$2a$04$lmpTqGqAZ3I2T9lO5aHW.ejGxIoSOUlgwQvoal2xhWtn3BSLr82E.", "USER");
			User user2 = new User("admin", "$2a$04$jjqsv31kBksv0rnU84HtEONzbIEnGUQAss50vC01.a59NhN8jTm.i", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
