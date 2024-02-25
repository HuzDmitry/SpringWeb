package by.SpringPattern.service;

import by.SpringPattern.model.Task;

import java.util.List;

public interface TaskServiceFacade {

    List<Task>getTaskAll();

    List<Task>genTask(int count);

    List<Task>putTask(int task);

    String GetMessageTask();
}
