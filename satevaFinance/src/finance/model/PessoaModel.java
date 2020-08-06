package finance.model;

import finance.model.database.SQLiteDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaModel extends SQLiteDB {


    Pessoa pessoa;

    public ResultSet login(String username, String password){


        String query="SELECT * FROM pessoa WHERE username=? and password=?";
        try{
           conectar();//Funcao esntendiada
            PreparedStatement stm=conection.prepareStatement(query);
            stm.setString(1,username);
            stm.setString(2,password);
            return stm.executeQuery();
        }
        catch (SQLException erro){

            System.out.println("Erro de acesso ao Banco de Dados!");
        }
return null;
    }




}


