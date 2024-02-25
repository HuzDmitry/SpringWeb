package by.SpringPattern.service;

import by.SpringPattern.model.Task;
import by.SpringPattern.model.TaskEvent;
import by.SpringPattern.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TaskServiceImpl implements TaskServiceFacade{

    private String message;

    private final TaskRepository repository;

    private final GenTaskService genTaskService;

    private static int taskCounts;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, GenTaskService genTaskService) {
        this.repository = repository;
        this.genTaskService = genTaskService;
    }

    @Override
    public List<Task> getTaskAll() {
        return repository.findAll();
    }

    @Override
    public List<Task> genTask(int count) {
        List<Task>tasks = new ArrayList<>();
        taskCounts += count;
        for (int i=0; i<count; i++){
            Task task = genTaskService.createTask();
            tasks.add(task);
        }
        repository.saveAll(tasks);
        return tasks;
    }

    @Override
    public List<Task> putTask(int task) {
        List<Task>tasks = new ArrayList<>();
        if (task > taskCounts)
            task = taskCounts;
        while (task != 0){
            tasks.add(repository.findById(new Random().nextInt(taskCounts)+1)
                    .orElseThrow());
            task--;
        }
        return genTaskService.putTasks(tasks);
    }

    @Override
    public String GetMessageTask() {
        return "изменились задачи: "+message;
    }

    @EventListener(TaskEvent.class)
    public void listener(TaskEvent event){
        List<Task>before = event.getBeforeTask();
        StringBuilder builder = new StringBuilder();
        builder.append("в количестве: ").append(before.size());

        for (Task task : before) {
            builder.append(" \n было: ").append(task);
        }
        message = builder.toString();
    }
}
