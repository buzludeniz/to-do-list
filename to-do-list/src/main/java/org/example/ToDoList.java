package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ToDoList {
    private ArrayList<Task> tasks;
    private Connection connection;





    public ToDoList() {
        tasks = new ArrayList<>();
            try {
                // Establish connection
                String url = "jdbc:mysql://localhost:3306/to_do_list"; // Replace with your database URL
                String username = "root"; // Replace with your MySQL username
                String password = "root"; // Replace with your MySQL password

                connection = DriverManager.getConnection(url, username, password);

                if (connection != null) {
                    System.out.println("Connection successful");
                    initDatabase(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void loadFromDatabase() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks");

            while (resultSet.next()) {
                String description = resultSet.getString("description");
                String priority = resultSet.getString("priority");
                String dueDate = resultSet.getString("due_date");
                int completed = resultSet.getInt("completion");

                Task task = new Task(description, priority, dueDate, completed);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO tasks (description, priority, due_date, completion) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, task.getDescription());
            statement.setString(2, task.getPriority());
            statement.setString(3, task.getDueDate());
            statement.setInt(4, task.isCompleted());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initDatabase(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id int  NOT NULL AUTO_INCREMENT," +
                "description varchar(255)," +
                "priority varchar(255)," +
                "due_date varchar(255)," +
                "completion int(1)," +
                "PRIMARY KEY (id)" +
                ")";

        connection.createStatement().execute(createTableSQL);
    }

    public void deleteTask(int taskid) {


        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM tasks WHERE id =?"
            );
            statement.setInt(1, taskid);

            int rowdel = statement.executeUpdate();
            if (rowdel > 0) {
                System.out.println("TASK IS DELETED");
            } else {
                System.out.println("TASK NOT FOUND PLS ENTER A VALID TASK ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewTasks(Comparator<Task> comparator) {
        loadFromDatabase(); // Load tasks from the database

        Collections.sort(tasks, comparator);
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Task " + (i + 1) + ": " + task + ", Completed: " + task.isCompleted());
        }
    }

    public void MarkasComplete(int taskid) {
        String MarkasComplete = "UPDATE tasks SET completion=1 WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(
                    MarkasComplete
            );
            statement.setInt(1, taskid);
            int rowupdated = statement.executeUpdate();
            if (rowupdated > 0) {
                System.out.println("TASK IS COMPLETED");
            } else {
                System.out.println("TASK NOT FOUND PLS ENTER A VALID TASK ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
