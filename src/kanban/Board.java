package kanban;

import user.User;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        if(task == null) return;
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    public List<Task> getTasksByUser(User user) {
        List<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getUser() == null) continue;
            if (task.getUser().equals(user)) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void print(){
        for(Task task : tasks){
            task.print();
        }
    }
}
