import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BancoDeDadosTest {

    private BancoDeDados db;

    @Before
    public void init() {
        db = new BancoDeDados();
    }
 
    @Test
    public void verificaTamanhoDaListaAoAdicionarAluno() {
        // Cenário

        Aluno aluno = new Aluno(4, "Neville Longbottom", "Sistemas da Informação");

        // Ação

        db.adicionarAluno(aluno);

        // Validação

        Assert.assertEquals("4", String.valueOf(db.getAlunos().size()));
    }

    @Test
    public void verificaTamanhoDaListaAoRemoverAluno() {
        // Cenário

        int alunoId = 2;

        // Ação

        db.deletarAluno(alunoId);

        // Validação

        Assert.assertEquals("2", String.valueOf(db.getAlunos().size()));
    }
    //@Test
   // public void veri() {
        // Cenário

        //int alunoId = 2;

        // Ação

        //db.deletarAluno(alunoId);

        // Validação

       // Assert.assertEquals("2", String.valueOf(db.getAlunos().size()));
    //}


}
