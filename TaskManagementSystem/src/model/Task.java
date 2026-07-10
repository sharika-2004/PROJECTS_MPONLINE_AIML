package model;

public class Task {

    private int taskId;
    private String employeeName;
    private String taskDescription;
    private String completed;

    public Task() {

    }

    public Task(int taskId, String employeeName,
            String taskDescription, String completed) {

        this.taskId = taskId;
        this.employeeName = employeeName;
        this.taskDescription = taskDescription;
        this.completed = completed;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

}