package by.SpringThymeleaf.controller;

import by.SpringThymeleaf.model.Task;
import by.SpringThymeleaf.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }


    @GetMapping
    public String getAllTask(Model model){
        List<Task>tasks = service.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks.html";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model){
        Task task = service.getTask(id);
        model.addAttribute("task", task);
        return "task.html";
    }

    @PostMapping
    public String addById( Task task, Model model){
        service.addTask(task);
        List<Task>tasks = service.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks.html";
    }

    @PostMapping("/up")
    public String updateById( @RequestParam Integer id,
                              @RequestParam String name,
                              @RequestParam String description, Model model){
        Task task = new Task(name, description);
        service.updateTask(id, task);
        List<Task>tasks = service.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks.html";
    }

    @PostMapping("/del/{id}")
    public String deleteById( @PathVariable("id") Integer id, Model model){
        service.deleteTask(id);
        List<Task>tasks = service.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks.html";
    }
}
