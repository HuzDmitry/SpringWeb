package by.SpringThymeleaf.model;

import java.time.LocalDateTime;

public class Task {
    public enum Status{
        TO_DO,
        PROCESS,
        END

    }
    private static int count;
    private Integer id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime dateTime;

    public Task(String name, String description) {
        this.id = ++count;
        this.name = name;
        this.description = description;
        this.status = Status.TO_DO;
        this.dateTime = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Task.count = count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
