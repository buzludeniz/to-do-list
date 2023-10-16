package org.example;

public class Task {
    private String description;
    private String priority;
    private String dueDate;
    private int completed;

    public Task(String description, String priority, String dueDate,int completed) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int isCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Pershkrimi: " + description + ", Prioriteti: " + priority + ", Deadline: " + dueDate;
    }
}
