package test;

import kanban.Board;
import kanban.Task;
import kanban.TaskStatus;
import org.junit.Test;
import user.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void nullTaskStatusTest() {
        Board board = new Board();
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        board.addTask(task2);
        List<Task> foundTasks = board.getTasksByStatus(null);
        assertEquals(0, foundTasks.size());
    }

    @Test
    public void noTasksByUserFoundTest() {
        Board board = new Board();
        User user = new User(2, "asd", "asdaaa");
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        board.addTask(task2);
        List<Task> foundTasks = board.getTasksByUser(user);
        assertEquals(0, foundTasks.size());
    }

    @Test
    public void singleTaskByUserFoundTest() {
        Board board = new Board();
        User user = new User(2, "asd", "asdaaa");
        Task task = new Task("asdasd");
        task.assignUser(user);
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        board.addTask(task2);
        List<Task> actualTasks = new ArrayList<Task>();
        actualTasks.add(task);
        List<Task> foundTasks = board.getTasksByUser(user);
        assertEquals(actualTasks, foundTasks);
    }

    @Test
    public void multipleTasksByUserFoundTest() {
        Board board = new Board();
        User user = new User(2, "asd", "asdaaa");
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        Task task3 = new Task("asdasdadasdasdsa");
        task.assignUser(user);
        task3.assignUser(user);
        board.addTask(task);
        board.addTask(task2);
        board.addTask(task3);
        List<Task> foundTasks = board.getTasksByUser(user);
        List<Task> actualTasks = new ArrayList<Task>();
        actualTasks.add(task);
        actualTasks.add(task3);
        assertEquals(actualTasks, foundTasks);
    }

    @Test
    public void nullTaskUserTest() {
        Board board = new Board();
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        board.addTask(task2);
        List<Task> foundTasks = board.getTasksByUser(null);
        assertEquals(0, foundTasks.size());
    }

    @Test
    public void noTasksByStatusFoundTest() {
        Board board = new Board();
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        board.addTask(task2);
        List<Task> foundTasks = board.getTasksByStatus(TaskStatus.DONE);
        assertEquals(0, foundTasks.size());
    }

    @Test
    public void singleTaskByStatusFoundTest() {
        Board board = new Board();
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        board.addTask(task);
        task.complete(); // zmienia status na DONE
        board.addTask(task2);
        List<Task> actualTasks = new ArrayList<Task>();
        actualTasks.add(task);
        List<Task> foundTasks = board.getTasksByStatus(TaskStatus.DONE);
        assertEquals(actualTasks, foundTasks);
    }

    @Test
    public void multipleTasksByStatusFoundTest() {
        Board board = new Board();
        Task task = new Task("asdasd");
        Task task2 = new Task("asdasdadasdasdsa");
        Task task3 = new Task("asdasdadasdasdsa");
        task.complete(); // zmienia status na DONE
        task3.complete();
        board.addTask(task);
        board.addTask(task2);
        board.addTask(task3);
        List<Task> foundTasks = board.getTasksByStatus(TaskStatus.DONE);
        List<Task> actualTasks = new ArrayList<Task>();
        actualTasks.add(task);
        actualTasks.add(task3);
        assertEquals(actualTasks, foundTasks);
    }

    @Test
    public void addTaskTest(){
        Board board = new Board();
        Task task = new Task("asdasd");
        board.addTask(task);
        assertTrue(board.getAllTasks().contains(task));
    }

    @Test
    public void nullTaskAddTest(){
        Board board = new Board();
        Task task = new Task("asdasd");
        board.addTask(task);
        List<Task> beforeList = board.getAllTasks();
        board.addTask(null);
        assertEquals(board.getAllTasks(), beforeList);
    }

    @Test
    public void removeTaskTest(){
        Board board = new Board();
        Task task = new Task("asdasd");
        board.removeTask(task);
        assertFalse(board.getAllTasks().contains(task));
    }

    @Test
    public void removeNullTaskTest(){
        Board board = new Board();
        List<Task> beforeList = board.getAllTasks();
        board.removeTask(null);
        assertEquals(board.getAllTasks(), beforeList);
    }
}
