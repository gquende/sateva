package sateva.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

protected Connection con;


public Connection open(){

try{
    con= DriverManager.getConnection("jdbc:sqlite:database.db");//Cria a conexao usando o Driver Sqlite
    return con;//Retorna a conexao caso seja bem efectivada
}

catch (SQLException error){

    error.printStackTrace();
}

return null; //Retorna null caso nao consiga criar a conexao
}

public void close(){

    try{
       con.close();
    }
    catch (SQLException error){
        error.printStackTrace();
    }
}

}
