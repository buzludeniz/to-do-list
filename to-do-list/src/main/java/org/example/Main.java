package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public void viewTasks(Comparator<Task> comparator) {
        Collections.sort(tasks, comparator);
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks by Priority");
            System.out.println("3. View Tasks by Due Date");
            System.out.println("4. Delete Task");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter due date (yyyy-MM-dd, or leave blank): ");
                    String dueDate = scanner.nextLine();
                    Task task = new Task(description, priority, dueDate);
                    toDoList.addTask(task);
                    break;
                case 2:
                    toDoList.viewTasks(Comparator.comparing(Task::getPriority));
                    break;
                case 3:
                    toDoList.viewTasks(Comparator.comparing(Task::getDueDate));
                    break;
                case 4:
                    System.out.print("Enter the task number to delete: ");
                    int taskNumber = scanner.nextInt();
                    toDoList.deleteTask(taskNumber - 1); // Adjust for 0-based index
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
