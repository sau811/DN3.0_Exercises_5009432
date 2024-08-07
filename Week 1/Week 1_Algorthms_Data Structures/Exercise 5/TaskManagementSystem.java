class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    
    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while (temp.next != null && temp.next.task.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            return false;
        }
        temp.next = temp.next.next;
        return true;
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        
        taskList.addTask(new Task(1, "Task 1", "Pending"));
        taskList.addTask(new Task(2, "Task 2", "Completed"));
        taskList.addTask(new Task(3, "Task 3", "In Progress"));

        
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("\nTask found: " + task);
        } else {
            System.out.println("\nTask not found.");
        }

        
        boolean deleted = taskList.deleteTask(1);
        if (deleted) {
            System.out.println("\nTask deleted successfully.");
        } else {
            System.out.println("\nFailed to delete task.");
        }

        
        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}
