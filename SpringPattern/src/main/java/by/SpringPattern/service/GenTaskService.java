package by.SpringPattern.service;

import by.SpringPattern.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenTaskService {

    Task createTask();

    List<Task>putTasks(List<Task> tasks);
}
