package by.SpringJPA.controller;


import by.SpringJPA.model.Book;
import by.SpringJPA.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * Получение списка всех книг
     * @return
     */
    @GetMapping
    public List<Book> findAll(){
        return service.findAll();
    }

    /**
     * Получение книги по id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book>findById(@PathVariable Long id){
        Optional<Book>book = service.findById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    /**
     * Добавление книги в репозиторий
     * @param book
     * @return
     */
    @PostMapping
    public Book save(@RequestBody Book book){
        return service.save(book);
    }

    /**
     * Обновление параметров в книге по id
     * @param book
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Book update(@RequestBody Book book,@PathVariable Long id){
        return service.updateBook(book, id);
    }

    /**
     * удаление книги по id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
