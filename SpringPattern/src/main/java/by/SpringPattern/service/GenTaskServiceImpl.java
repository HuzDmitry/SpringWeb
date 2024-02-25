package by.SpringPattern.service;

import by.SpringPattern.model.Task;
import by.SpringPattern.model.TaskEvent;
import by.SpringPattern.model.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GenTaskServiceImpl implements GenTaskService{

    private final TaskFactory taskFactory;

    private final ApplicationEventPublisher publisher;

    @Autowired
    public GenTaskServiceImpl(TaskFactory taskFactory, ApplicationEventPublisher publisher) {
        this.taskFactory = taskFactory;
        this.publisher = publisher;
    }

    @Override
    public Task createTask() {
        return taskFactory.getTask();
    }

    @Override
    public List<Task> putTasks(List<Task> tasks) {
        List<Task> temp = tasks.stream().map(taskFactory::getTask).toList();
        this.publisher.publishEvent(new TaskEvent(this, tasks));
        return temp;
    }
}
