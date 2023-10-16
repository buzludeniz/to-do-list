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
            System.out.println("1. Shto task");
            System.out.println("2. Shiko renditjen  ne baze te prioritetit");
            System.out.println("3. Shkio renditjen ne baze te deadline");
            System.out.println("4. Fshi Taskun");
            System.out.println("5. Sheno si te perfunduar");
            System.out.println("6. Dil");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Shto pershkrimin: ");
                    String description = scanner.nextLine();

                    System.out.print("Vendos nivelin e prioritetit (High/Medium/Low): ");
                    String priority = scanner.nextLine();

                    System.out.print("Vendos deadline (yyyy-MM-dd): ");
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
                    System.out.print("Vendo numrin e taskut qe do te fshish: ");
                    int indexToDelete = scanner.nextInt();
                    toDoList.deleteTask(indexToDelete); // Adjust for 0-based index
                    break;

                case 5:
                    System.out.println("Shot numrin e taskut qe do te shenosh si te perfunduar: ");
                    int indexToModify = scanner.nextInt();
                    toDoList.MarkasComplete(indexToModify);
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Zgjidhje e pamundur.Provo Serish.");
            }
        }

        toDoList.closeConnection();
        scanner.close();
    }
}
