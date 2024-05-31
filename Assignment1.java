package com.aait.assignment1;
// Task class represents a task with a title, description, and completion status
class Task {
    private String title;
    private String description;
    private boolean completed;

    // Constructor to initialize a task with a title and description
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter method to retrieve the title of the task
    public String getTitle() {
        return title;
    }
    // Getter method to retrieve the description of the task
    public String getDescription() {
        return description;
    }
    // Getter method to check if the task is completed
    public boolean isCompleted() {
        return completed;
    }
    // Method to mark the task as completed
    public void markCompleted() {
        completed = true;
    }
}
// Node class represents a node in the linked list containing a task and reference to the next node
class Node {
    Task task;
    Node next;

    // Constructor to initialize a node with a task
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
// ToDoList class manages tasks using a linked list
class ToDoList {
    private Node head; // Reference to the head of the linked list

    // Constructor to initialize an empty ToDoList
    public ToDoList() {
        this.head = null;
    }

    // Method to add a new task to the end of the linked list
    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to mark a task as completed based on its title
    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title " + title + " not found.");
    }

    // Method to display the list of tasks in the to-do list
    public void viewToDoList() {
        Node current = head;
        System.out.println("To-Do List:");
        while (current != null) {
            System.out.println("Title: " + current.task.getTitle());
            System.out.println("Description: " + current.task.getDescription());
            System.out.println("Completed: " + (current.task.isCompleted() ? "Yes" : "No"));
            System.out.println("---------------------");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        // Test the implementation
        ToDoList toDoList = new ToDoList();

        // Adding tasks
        toDoList.addToDo(new Task("Task 1", "Description of Task 1"));
        toDoList.addToDo(new Task("Task 2", "Description of Task 2"));
        toDoList.addToDo(new Task("Task 3", "Description of Task 3"));

        // Viewing initial to-do list
        toDoList.viewToDoList();

        // Marking a task as completed
        toDoList.markToDoAsCompleted("Task 6");

        // Viewing updated to-do list
        toDoList.viewToDoList();
    }
}