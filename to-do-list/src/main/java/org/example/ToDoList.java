package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
