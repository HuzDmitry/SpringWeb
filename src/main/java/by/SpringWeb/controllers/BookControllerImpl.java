package by.SpringWeb.controllers;

import by.SpringWeb.models.Book;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public interface BookControllerImpl {

    @GetMapping("/all")
    List<Book>findAll();

    @GetMapping("/{id}")
    Book getByIdBook(@PathVariable Long id);

    @GetMapping()
    Book getByTitleBook(@RequestParam String title);

    @PostMapping
    String saveBook(@RequestBody Book book);

    @DeleteMapping("/{id}")
    void deleteByIdBook(@PathVariable Long id);
}
