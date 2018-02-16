package fi.haagahelia.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import fi.haagahelia.Bookstore.domain.Book;

@RestResource
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByAuthor(@Param("author") String author);
	List<Book> findByTitle(@Param("title") String title);
}
