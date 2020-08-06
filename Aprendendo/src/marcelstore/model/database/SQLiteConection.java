package marcelstore.model.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConection implements Database {

    protected Connection conection=null;

    @Override
    public Connection conectar() {
        try{
            conection= DriverManager.getConnection("jdbc:sqlite:database/marcelstore.db");
            System.out.println(conection);
            return conection;
        }
        catch (SQLException erro){

            JOptionPane.showMessageDialog(null, "Erro\n");
            erro.printStackTrace();
        }
        return null;
    }

    @Override
    public void desconectar() {
        if(conection!=null){
            try {
                conection.close();
            }
            catch (SQLException erro){

                System.out.println("Erro ao tentar fechar o Banco de Dados!");

            }
        }

    }
}
