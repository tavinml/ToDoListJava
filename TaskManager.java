package Projetos;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public boolean removeTaskById(int id){
        for(int i = 0; i < tasks.size();i++){
            if(tasks.get(i).getId() == id){
                tasks.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean markAsCompleted(int id){
        for(Task task: tasks){
            if(task.getId() == id){
                task.setCompleted(true);
                return true;
            }
        }
        return false;
    }


    public void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("Nenhuma tarefa encontrada!");
            return;
        }

        for(Task task: tasks){
            String status = task.isCompleted()? "[✔]" : "[ ]";
            System.out.println(task.getId() + " - " + status + " " + task.getDescription());
        }
    }

}
