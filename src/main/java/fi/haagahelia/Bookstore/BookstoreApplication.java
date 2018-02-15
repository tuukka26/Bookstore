package fi.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;
import fi.haagahelia.Bookstore.domain.Category;
import fi.haagahelia.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
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
		};
	}
}
