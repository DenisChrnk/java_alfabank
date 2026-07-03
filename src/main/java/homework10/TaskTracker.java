package homework10;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    private List<Task> tasksList;

    public TaskTracker() {
        this.tasksList = new ArrayList<>();
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
        System.out.println(tasksList);
    }

    public void doTaskDone(String taskName) {
        for (Task task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                task.setTaskDone();
            }
        }
    }

    public boolean taskIsDone(String taskName) {
        boolean result = false;
        for (Task task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                result = task.getTaskStatus();
            }
        } return result;
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

