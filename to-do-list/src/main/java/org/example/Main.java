package org.example;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Shto Task");
            System.out.println("2. Shiko Tasqet nga prioriteti");
            System.out.println("3. Shiko tasqet nga deadline");
            System.out.println("4. Fshi Task");
            System.out.println("5. EXIT");
            System.out.print("Bej zgjidhjen tende: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Shto pershkrimin e taskut: ");
                    String description = scanner.nextLine();
                    System.out.print("Vendos lvl prioritetin (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Shto deadline (yyyy-MM-dd, or leave blank): ");
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
                    System.out.print("Venos numrin e taskut qe do fshish: ");
                    int taskNumber = scanner.nextInt();
                    toDoList.deleteTask(taskNumber - 1); // Adjust for 0-based index
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Zgjedhje e pasakt .");
            }
        }
    }
}
