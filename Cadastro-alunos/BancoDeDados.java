import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BancoDeDados {

    private List<Aluno> alunos;
    
    public BancoDeDados() {
        this.alunos = new ArrayList<>();

        this.alunos.add(new Aluno(1, "Harry Potter", "Ciência da Computação"));
        this.alunos.add(new Aluno(2, "Hermione Granger", "Engenharia da Computação"));
        this.alunos.add(new Aluno(3, "Ronald Weasley", "Análise e Desenvolvimento de Sistemas"));
    }

    // CRUD - Create, Read, Update and Delete

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public Aluno getAluno(int id) {
        return this.alunos.get(id - 1);
    }

    public Aluno updateAluno(int id, Aluno aluno) {
        Aluno alunoObj = this.alunos.get(id - 1);

        alunoObj.setNome(aluno.getNome());
        alunoObj.setCurso(aluno.getCurso());

        // Remove e adiciona o aluno na lista (solução temporária)

        this.alunos.remove(alunoObj);
        this.alunos.add(alunoObj);

        // Orderna a lista de alunos pelo ID

        Collections.sort(alunos, new Comparator<Aluno>() {

            @Override
            public int compare(Aluno aluno1, Aluno aluno2) {
                return aluno1.getId() - aluno2.getId();
            }

        });

        return alunoObj;
    }

    public void deletarAluno(int id) {
        Aluno aluno = this.alunos.get(id - 1);

        this.alunos.remove(aluno);
    }

}