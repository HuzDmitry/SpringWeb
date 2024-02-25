package by.SpringPattern.service;

import by.SpringPattern.model.Task;
import by.SpringPattern.model.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GenTaskServiceImpl implements GenTaskService{

    private final TaskFactory taskFactory;

    @Autowired
    public GenTaskServiceImpl(TaskFactory taskFactory) {
        this.taskFactory = taskFactory;
    }

    @Override
    public Task createTask() {
        return taskFactory.getTask();
    }

    @Override
    public List<Task> putTasks(List<Task> tasks) {
        return tasks.stream().map(taskFactory::getTask).toList();
    }
}
