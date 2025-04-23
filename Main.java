package Projetos;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        String csvPath = "data/tasks.csv";

        while(true){
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Salvar tarefas em CSV");
            System.out.println("6. Carregar tarefas do Csv");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int option = input.nextInt();
            input.nextLine();

            switch(option){
                case 1:
                    System.out.println("Descrição da tarefa(categoria e nivel de prioridade:");
                    String desc = input.nextLine();
                    String ctg = input.nextLine();
                    int lvl = input.nextInt();
                    manager.addTask(desc, ctg, lvl);
                    break;

                case 2:
                    manager.showTasks();
                    break;

                case 3:
                    System.out.println("ID da tarefa a marcar como concluída: ");
                    int idToCompleted = input.nextInt();

                    if(manager.markAsCompleted(idToCompleted)){
                        System.out.println("Tarefa marcada como concluída");
                    } else {
                        System.out.println("Tarefa não encontrada");
                    }
                    break;

                case 4:
                    System.out.println("Informe o ID da tarefa a ser removida: ");
                    int idRemove = input.nextInt();

                    if(manager.removeTaskById(idRemove)){
                        System.out.println("Tarefa removida com sucesso!");
                    }else {
                        System.out.println("Tarefa não encontrada");
                    }
                    break;

                case 5:
                    File pasta = new File("data");
                    if(!pasta.exists()){
                        pasta.mkdir();
                    }
                    manager.saveTasksToCsv(csvPath);
                    break;

                case 6:
                    manager.loadTaskToCsv(csvPath);
                    break;


                case 0:
                    System.out.println("Saindo...Até já já!");
                    return;

                default:
                    System.out.println("Opção inválida, digite novamente!");
            }
        }


    }
}
