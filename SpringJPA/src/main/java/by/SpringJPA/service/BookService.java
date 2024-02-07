package by.SpringJPA.service;


import by.SpringJPA.model.Book;
import by.SpringJPA.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
    public Book updateBook(Book book, Long id){
        Book bk = bookRepository.findById(id)
                .orElseThrow();
        bk.setAuthor(book.getAuthor());
        bk.setTitle(book.getTitle());
        bk.setIsbn(book.getIsbn());
        bk.setPublicationYear(book.getPublicationYear());
        return bookRepository.save(bk);
    }
}
