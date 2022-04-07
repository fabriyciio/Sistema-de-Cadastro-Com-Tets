import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroDeAlunos {

    public static void main(String[] args) {
        System.out.println("Bem vindo(a)! Escolha uma das opções abaixo:");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("1 - Cadastrar novo(a) aluno(a)");
        System.out.println("2 - Listar todos os alunos");
        System.out.println("3 - Listar informações de um(a) aluno(a)");
        System.out.println("4 - Atualizar informações de um(a) aluno(a)");
        System.out.println("5 - Remover cadastro de um(a) aluno(a)");

        // Entrada da opção do usuário

        Scanner sc = new Scanner(System.in);
        System.out.print("Insira sua opção: ");
        String opcao = sc.nextLine();

        // Conexão com Banco de Dados

        BancoDeDados db = new BancoDeDados();

        Aluno aluno = null;
        List<Aluno> alunos = new ArrayList<>();
        int id = 0;

        switch (opcao) {
            case "1":
                System.out.println("Cadastrando novo(a) aluno(a)...");
                System.out.println("---------------------------------------------------------------------------");

                aluno = new Aluno();

                System.out.println("Digite as informações solicitadas a seguir:");

                System.out.println("ID do aluno(a): ");
                aluno.setId(Integer.parseInt(sc.nextLine()));

                System.out.println("Nome do aluno(a): ");
                aluno.setNome(sc.nextLine());

                System.out.println("Curso do aluno(a): ");
                aluno.setCurso(sc.nextLine());

                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Salvando informações no banco de dados...");

                db.adicionarAluno(aluno);

                imprimir(sc, db);
                
                sc.close();
                
                break;
            case "2":
                System.out.println("Listando alunos cadastrados...");
                System.out.println("---------------------------------------------------------------------------");

                alunos = db.getAlunos();

                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println("ID: " + alunos.get(i).getId() + " - Nome: " + alunos.get(i).getNome()
                            + " - Curso: " + alunos.get(i).getCurso());
                }

                System.out.println("---------------------------------------------------------------------------");

                sc.close();
                break;
            case "3":
                System.out.println("Buscar aluno(a) pelo ID...");
                System.out.println("---------------------------------------------------------------------------");

                System.out.println("Digite as informações solicitadas a seguir:");
                System.out.println("ID do aluno(a): ");
                id = Integer.parseInt(sc.nextLine());

                if (id > db.getAlunos().size()) {
                    System.out.println("Erro 404: Aluno(a) não encontrado!");
                } else {
                    aluno = db.getAluno(id);

                    System.out.println(
                            "ID: " + aluno.getId() + " - Nome: " + aluno.getNome() + " - Curso: " + aluno.getCurso());
                }

                imprimir(sc, db);
                
                sc.close();
                
                break;
            case "4":
                System.out.println("Atualizar informações do(a) aluno(a)...");
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Digite as informações solicitadas a seguir:");
                System.out.println("ID do aluno(a): ");
                id = Integer.parseInt(sc.nextLine());

                if (id > db.getAlunos().size()) {
                    System.out.println("Erro 404: Aluno(a) não encontrado!");
                } else {
                    aluno = db.getAluno(id);

                    System.out.println("Nome do aluno(a): ");
                    aluno.setNome(sc.nextLine());
                    System.out.println("Curso do aluno(a): ");
                    aluno.setCurso(sc.nextLine());

                    System.out.println("Salvando informações no banco de dados...");

                    db.updateAluno(id, aluno);

                    System.out.println("Aluno(a) atualizado com sucesso!");
                }

                imprimir(sc, db);
                
                sc.close();
                
                break;
            case "5":
                System.out.println("Atualizar informações do(a) aluno(a)...");
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Digite as informações solicitadas a seguir:");
                System.out.println("ID do aluno(a): ");
                id = Integer.parseInt(sc.nextLine());

                if (id > db.getAlunos().size()) {
                    System.out.println("Erro 404: Aluno(a) não encontrado!");
                } else {
                    db.deletarAluno(id);

                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Cadastro de aluno(a) removido com sucesso!");
                }

                imprimir(sc, db);

                sc.close();

                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    private static void imprimir(Scanner sc, BancoDeDados db) {
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Deseja imprimir lista atualizada de alunos? (S/N)");
        String imprimir = sc.nextLine();

        System.out.println("---------------------------------------------------------------------------");

        if (imprimir.equalsIgnoreCase("s")) {
            List<Aluno> alunos = db.getAlunos();

            for (int i = 0; i < alunos.size(); i++) {
                System.out.println("ID: " + alunos.get(i).getId() + " - Nome: " + alunos.get(i).getNome() + " - Curso: "
                        + alunos.get(i).getCurso());
            }
        }

        System.out.println("---------------------------------------------------------------------------");
    }
}

// lista de bugs
// 1 - procurar por ID e nao por Id -1
// 2 - condicao no IF (id >= db.getAlunos().size())
// 3 -