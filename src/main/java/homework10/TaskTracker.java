package homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskTracker {
    private List<Task> tasksList;

    public TaskTracker() {
        this.tasksList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskTracker that = (TaskTracker) o;
        return Objects.equals(tasksList, that.tasksList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tasksList);
    }

    @Override
    public String toString() {
        return "TaskTracker{" +
                "tasksList=" + tasksList +
                '}';
    }

    public void addTaskToList(Task task) {
        tasksList.add(task);
        System.out.println("Добавили новую задачу в список задач");
    }

    public void getAllTasks() {
        for(Task task: tasksList){
            System.out.println(task);
        }
    }

    public void doTaskDone(String taskName) {
        for (Task task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                task.setTaskDone();
            }
        }
    }

    public void statusOfTask(String taskName) {
        boolean result = false;
        for (Task task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                result = task.getTaskStatus();
            }
        }
        System.out.println("Статус задачи: " + result);
    }
    public void getTasksStatistics(){
        int numberOfTasks = tasksList.size();
        int doneTasks = 0;
        int openTasks = 0;
        for (Task task: tasksList){
            if (task.getTaskStatus()){
                doneTasks++;
            } else {
                openTasks++;
            }
        }
        System.out.println("Всего задач: " + numberOfTasks);
        System.out.println("Выполнено: " + doneTasks);
        System.out.println("Открыто: " + openTasks);
    }
}

