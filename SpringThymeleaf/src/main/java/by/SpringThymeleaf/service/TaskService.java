package by.SpringThymeleaf.service;

import by.SpringThymeleaf.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        if (!task.getName().isEmpty() || task.getDescription().isEmpty())
            tasks.add(task);
    }

    public List<Task>getAllTasks(){
        //Task ts = new Task("gigi", "gigigigi");
        //tasks.add(ts);
        return tasks;
    }

    public Task getTask(Integer id){
        return tasks.stream().filter(t->t.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteTask(Integer id){
      tasks.removeIf(t->t.getId().equals(id));
        Task.setCount(Task.getCount()-1);
    }

    public Task updateTask(int id, Task task){
        Task task1 = getTask(id);
        if (task1 != null){
            task1.setName(task.getName());
            task1.setDescription(task.getDescription());
            task1.setStatus(task.getStatus());
            task1.setDateTime(task.getDateTime());
            deleteTask(task.getId());


        }
        return task1;
    }


}
