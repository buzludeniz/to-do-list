# To-Do List (Java + MySQL)

A console to-do list application in Java that stores tasks in a MySQL
database over JDBC. It was an early university project (October 2023); the
menu text is in Albanian.

## Features

From the main menu you can:

1. Add a task with a description, priority (High/Medium/Low) and deadline (`yyyy-MM-dd`)
2. List tasks sorted by priority
3. List tasks sorted by deadline
4. Delete a task by its id
5. Mark a task as completed
6. Exit

On start-up the app connects to MySQL and creates the `tasks` table if it does
not exist. Listing tasks reloads them from the database before sorting.

## Tech stack

- Java 8 (Maven project)
- MySQL 8 via `mysql-connector-java` 8.0.33
- Plain JDBC (`DriverManager`, prepared statements)

## Project layout

```
to-do-list/                      Maven project
  pom.xml
  src/main/java/org/example/
    Main.java                    console menu loop
    ToDoList.java                JDBC connection and CRUD operations
    Task.java                    task model
to_do_list_tasks.sql             MySQL dump of the `tasks` table
```

## Running locally

Requires a JDK, Maven and a local MySQL server.

1. Create the database: `CREATE DATABASE to_do_list;` (optionally import
   `to_do_list_tasks.sql`).
2. Set your MySQL URL, username and password in the constructor of
   `to-do-list/src/main/java/org/example/ToDoList.java`.
3. Build and run from the `to-do-list/` directory, for example from your IDE,
   or:

   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass=org.example.Main
   ```
