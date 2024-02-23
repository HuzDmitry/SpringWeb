package by.SpringWeb.services;
import by.SpringWeb.models.Book;
import by.SpringWeb.models.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book>findAll(){
        return repository.findAll();
    }

    public Optional<Book> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Book> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public void saveBook(Book book){
         repository.save(book);
    }

    public void deleteBook(Long id){
         repository.deleteById(id);
    }
}
