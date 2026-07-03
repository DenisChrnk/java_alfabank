package homework10;

public class Task {
    private String taskName;
    private boolean isDone;

    public Task(String taskName, boolean idDone) {
        this.taskName = taskName;
        this.isDone = idDone;
    }

    public void getTheTaskDone() {
        isDone = true;
        System.out.println("Перевели задачу в Done");
    }

    public void getTaskStatus() {
        System.out.println("Статус задачи: " + isDone);
    }

    public void getTaskName() {
        System.out.println("Название задачи: " + taskName);
    }

    public void printTaskInfo() {
        if (isDone) {
            System.out.println("[х] Проверить регистрацию");
        } else {
            System.out.println("[] Проверить авторизауию");
        }
    }
}
