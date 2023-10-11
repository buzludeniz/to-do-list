package org.example;

class Task {
    private String description;
    private String priority;
    private String dueDate;

    public Task(String description, String priority, String dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Getters for task properties
    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}