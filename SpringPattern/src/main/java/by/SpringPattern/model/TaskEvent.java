package by.SpringPattern.model;


import org.springframework.context.ApplicationEvent;

import java.util.List;

public class TaskEvent extends ApplicationEvent {

    private final List<Task> beforeTask;


    public TaskEvent( Object source, List<Task> beforeTask) {
        super(source);
        this.beforeTask = beforeTask;
    }

    public List<Task> getBeforeTask() {
        return beforeTask;
    }
}
