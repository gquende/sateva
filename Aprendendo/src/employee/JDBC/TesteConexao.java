package employee.JDBC;

public class TesteConexao {


    public static void main(String[] args) throws ClassNotFoundException{

        Conexao conn=new Conexao();
        conn.getConnection();
    }



}
