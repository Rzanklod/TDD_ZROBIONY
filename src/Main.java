import kanban.Board;
import kanban.Task;
import kanban.TaskStatus;
import user.User;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        User u1 = new User(1, "kamil", "kowalski");
        User u2 = new User(2, "kamil", "slimak");
        Task task = new Task("11111");
        Task task2 = new Task("222222");
        Task task3 = new Task("333333");
        Task task4 = new Task("444444");
        Task task5 = new Task("555555");
        task.assignUser(u1);
        task3.assignUser(u2);
        task4.complete();
        board.addTask(task);
        board.addTask(task2);
        board.addTask(task3);
        board.addTask(task4);
        board.addTask(task5);
        board.print();
        System.out.println("-----------");
        System.out.println("Zadania ze statusem DONE");
        board.getTasksByStatus(TaskStatus.DONE).forEach((Task::print));
        System.out.println("-----------");
        System.out.println("Zadania ze statusem NEW");
        board.getTasksByStatus(TaskStatus.NEW).forEach((Task::print));
        System.out.println("-----------");
        System.out.println("Zadania ze statusem IN PROGRESS");
        board.getTasksByStatus(TaskStatus.IN_PROGRESS).forEach((Task::print));
        System.out.println("-----------");
        System.out.println("Zadania uzytkownika u1");
        board.getTasksByUser(u1).forEach((Task::print));
        System.out.println("-----------");
        System.out.println("Zadanie1 usuniete:");
        board.removeTask(task);
        board.print();
    }
}