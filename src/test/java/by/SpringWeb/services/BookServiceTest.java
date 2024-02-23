package by.SpringWeb.services;
import by.SpringWeb.models.Book;
import by.SpringWeb.models.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Spy
    private BookRepository bookRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        bookService.findAll();

        Mockito.verify(bookRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testSave(){
        Book book = new Book();
        bookService.saveBook(book);

        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }
    @Test
    public void testFinByTitle(){
        bookService.findByTitle("title");
        Mockito.verify(bookRepository, Mockito.times(1)).findByTitle("title");
    }
    @Test
    public void testFindById(){
        Long id = 1L;
        bookService.findById(id);
        Mockito.verify(bookRepository).findById(id);
    }
    @Test
    public void testDeleteById(){
        Long id = 1L;
        bookService.deleteBook(id);
        Mockito.verify(bookRepository).deleteById(id);
    }
}
