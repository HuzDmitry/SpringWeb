package by.SpringWeb.controllers;

import by.SpringWeb.models.Book;
import by.SpringWeb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController implements BookControllerImpl{
    @Autowired
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @Override
    public List<Book> findAll() {
        return service.findAll();
    }

    @Override
    public Book getByIdBook(Long id) {
        return service.findById(id).orElseThrow();
    }

    @Override
    public Book getByTitleBook(String title) {
        return service.findByTitle(title).orElseThrow();
    }

    @Override
    public String saveBook(Book book) {
        service.saveBook(book);
        return "end";
    }

    @Override
    public void deleteByIdBook(Long id) {
        service.deleteBook(id);
    }
}
