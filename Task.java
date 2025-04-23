package Projetos;

public class Task {

    private int id;
    private String description;
    private boolean completed;
    private String category;
    private int priorityLevel;

    public Task(int id, String description, String category, int priority){
        this.id = id;
        this.description = description;
        this.completed = false;
        this.category = category;
        this.priorityLevel = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
