import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDadosDAO {
    public Connection conexaoBD() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;

        
        String url = "jdbc:mysql://localhost:3306/cadastrodealuno?user=root&password=";
        con = DriverManager.getConnection(url);
        return con ;


        
    }
}
