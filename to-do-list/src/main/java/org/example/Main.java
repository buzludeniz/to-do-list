package org.example;

import java.util.Comparator;
import java.util.Scanner;
// JUST IN CASE CONNECTION ALWAYS IN A DIFF CLASS PLS FOR SECURITY


public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks by Priority");
            System.out.println("3. View Tasks by Due Date");
            System.out.println("4. Delete Task");
            System.out.println("5.Mark as Complete");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();

                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dueDate = scanner.nextLine();

                    Task task = new Task(description, priority, dueDate, 0);
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
                    int indexToDelete = scanner.nextInt();
                    toDoList.deleteTask(indexToDelete); // Adjust for 0-based index
                    break;

                case 5:
                    System.out.println("Enter the task number to mark as complete: ");
                    int indexToModify = scanner.nextInt();
                    toDoList.MarkasComplete(indexToModify);
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        toDoList.closeConnection();
        scanner.close();
    }
}
