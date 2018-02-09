package fi.haagahelia.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
