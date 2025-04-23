package Projetos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description, String category, int priority){
        Task task = new Task(nextId ,description, category, priority);
        tasks.add(task);
        nextId++;
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

    public void saveTasksToCsv(String filePath){

        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if(parentDir != null && !parentDir.exists()){
            parentDir.mkdirs();
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter(file))){
            writer.println("id,description,completed,category,priorityLevel");

            for(Task task : tasks){
                writer.printf("%d,%s,%b,%s,%d%n",
                        task.getId(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getCategory(),
                        task.getPriorityLevel());
            }

            System.out.println("✅ Tarefas salvas em"  + file.getAbsolutePath());

        }catch(IOException e){
            System.out.println("❌ Erro ao salvar: " + e.getMessage());
        }
    }

    public void loadTaskToCsv(String filePath){

        File file = new File(filePath);

        if(!file.exists()){
            System.out.println("⚠️ Arquivo não encontrado em: " + file.getAbsolutePath());
            return;
        }
        tasks.clear();
        nextId = 1;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String linha;
            reader.readLine();

            while ((linha = reader.readLine()) != null){

                String[] partes = linha.split(",");

                int id = Integer.parseInt(partes[0]);
                String desc = partes[1];
                boolean completed = Boolean.parseBoolean(partes[2]);
                String category = partes[3];
                int priority = Integer.parseInt(partes[4]);

                Task task = new Task(id,desc,category,priority);
                task.setCompleted(completed);
                tasks.add(task);
                if(id >= nextId) nextId = id + 1;

            }

            System.out.println("✅ Tarefas carregadas com sucesso de " + file.getAbsolutePath());
        } catch (IOException e){
            System.out.println("❌ Erro ao carregar tarefas: " + e.getMessage());
        }
    }

}
