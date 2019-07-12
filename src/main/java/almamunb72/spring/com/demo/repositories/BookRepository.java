package almamunb72.spring.com.demo.repositories;

import almamunb72.spring.com.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
