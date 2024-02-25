package by.SpringPattern.model;

public class TaskBuilder {

    Task task;

    public TaskBuilder(){}

    public TaskBuilder(Task task) {
        this.task = task;
    }

    public TaskBuilder createTask(){
        task = new Task();
        return this;
    }
    public TaskBuilder setName(String name){
        task.setName(name);
        return this;
    }
    public TaskBuilder setContent(String content){
        task.setContent(content);
        return this;
    }
    public TaskBuilder setToDo(String toDo){
        task.setToDo(toDo);
        return this;
    }
    public Task getTask(){
        return task;
    }
}
