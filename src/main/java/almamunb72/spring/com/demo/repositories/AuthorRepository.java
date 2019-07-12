package almamunb72.spring.com.demo.repositories;

import almamunb72.spring.com.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
