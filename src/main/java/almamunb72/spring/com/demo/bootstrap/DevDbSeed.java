package almamunb72.spring.com.demo.bootstrap;


import almamunb72.spring.com.demo.model.Author;
import almamunb72.spring.com.demo.model.Book;
import almamunb72.spring.com.demo.model.Publisher;
import almamunb72.spring.com.demo.repositories.AuthorRepository;
import almamunb72.spring.com.demo.repositories.BookRepository;
import almamunb72.spring.com.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DevDbSeed implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevDbSeed(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.seedDb();
    }

    private void seedDb(){

        //publisher green book
        Publisher gbook = new Publisher();
        gbook.setName("Green Book");
        gbook.setRegistrationNo("GBBDX2243234");
        gbook.setAddress("Nilkhet, Dhaka");
        publisherRepository.save(gbook);

        //publisher knowledge hub
        Publisher khub = new Publisher();
        khub.setName("Knowledge Hub");
        khub.setRegistrationNo("KHBDX2243XTM");
        khub.setAddress("Globe Super Market, New Market, Dhaka");
        publisherRepository.save(khub);


        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", gbook);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", khub );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
