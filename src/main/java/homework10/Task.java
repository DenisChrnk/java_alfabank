package homework10;

public class Task {
    private String taskName;
    private boolean isDone;

    public Task(String taskName, boolean idDone) {
        this.taskName = taskName;
        this.isDone = idDone;
    }


    public void setTaskDone() {
        isDone = true;
        System.out.println("Перевели задачу в Done");
    }

    public boolean getTaskStatus() {
        System.out.println("Статус задачи: " + isDone);
        return isDone;
    }

    public String getTaskName() {
        System.out.println("Название задачи: " + taskName);
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
