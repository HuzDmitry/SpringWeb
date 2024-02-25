package by.SpringPattern.controller;

import by.SpringPattern.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface TaskController {

    @GetMapping("/all")
    List<Task> getTaskAll();

    @GetMapping("/gen/{count}")
    List<Task> genTask(@PathVariable int count);

    @GetMapping("/put/{task}")
    List<Task>putTask(@PathVariable int task);

    @GetMapping
    String getMessageByTask();

}
