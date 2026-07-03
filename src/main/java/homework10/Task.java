package homework10;

import java.util.Objects;

public class Task {
    private String taskName;
    private boolean isDone;

    public Task(String taskName, boolean idDone) {
        this.taskName = taskName;
        this.isDone = idDone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isDone == task.isDone && Objects.equals(taskName, task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, isDone);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", isDone=" + isDone +
                '}';
    }

    public void setTaskDone() {
        isDone = true;
        System.out.println("Перевели задачу в Done");
    }

    public boolean getTaskStatus() {
        return isDone;
    }

    public String getTaskName() {
        return taskName;
    }

    public void printTaskInfo() {
        if (isDone) {
            System.out.println("[х] Проверить регистрацию");
        } else {
            System.out.println("[] Проверить авторизауию");
        }
    }
}
