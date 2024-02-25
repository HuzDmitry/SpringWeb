package by.SpringPattern.controller;

import by.SpringPattern.model.Task;
import by.SpringPattern.service.TaskServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    private final TaskServiceFacade service;
    @Autowired
    public TaskControllerImpl(TaskServiceFacade service) {
        this.service = service;
    }

    @Override
    public List<Task> getTaskAll() {
        return service.getTaskAll();
    }

    @Override
    public List<Task> genTask(int count) {
        return service.genTask(count);
    }

    @Override
    public List<Task> putTask(int task) {
        return service.putTask(task);
    }

    @Override
    public String getMessageByTask() {
        return service.GetMessageTask();
    }
}
