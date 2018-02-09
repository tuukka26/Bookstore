package fi.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.Bookstore.domain.Book;
import fi.haagahelia.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			
			Book book1 = new Book("A Farewell to Arms", "Ernest Hemingway", "12341234-12", 1929, 9.99);
			Book book2 = new Book("The Master and Margarita", "Mikhail Bulgakov", "0-14-118014-5", 1967, 19.99);
			Book book3 = new Book("On the Road", "Jack Kerouac", "121234-99", 1929, 12.00);
			
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
		};
	}
}
