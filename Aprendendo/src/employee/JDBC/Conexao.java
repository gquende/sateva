package employee.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private  String url="jdbc:mysql://localhost/quende?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private  String user="root";
    private  String password="adolfo";
private  Connection connection;

    public Connection getConnection() throws ClassNotFoundException {


        try {

            connection=DriverManager.getConnection(url,user,password);
            System.out.println(connection);
            return  connection;
        }

        catch (SQLException e){

            e.printStackTrace();
        }

        return null;


    }



}
