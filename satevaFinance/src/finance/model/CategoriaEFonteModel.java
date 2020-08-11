/*
* Classe responsavel por trabalhar as categorias da base de Dados
*
*
* */


package finance.model;

import finance.classes.Categoria;
import finance.model.database.SQLiteDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaEFonteModel extends SQLiteDB {


    public ArrayList<String> listarCategoria() {

        conectar();
        {
            try {

                String query = "SELECT* FROM categoria";
                ArrayList<String> categorias = new ArrayList<>();
                PreparedStatement stm = conection.prepareStatement(query);
                ResultSet resultado = stm.executeQuery();
                while (resultado.next()) {
                    String categoria = resultado.getString("tipo");//A cada iteracao Cria uma Nova instancia
                    //De Categoria

                    categorias.add(categoria);
                }
                return categorias;

            } catch (SQLException erro) {

                System.out.println("Erro ao tentar aceder a Base de Dados");

            }
            return null;
        }

    }

    public ArrayList<String> listarFonte() {
        conectar();
        {
            try {

                String query = "SELECT* FROM fonteReceita";
                ArrayList<String> fontes = new ArrayList<>();
                PreparedStatement stm = conection.prepareStatement(query);
                ResultSet resultado = stm.executeQuery();
                while (resultado.next()) {
                    String fonte = resultado.getString("fonte");//A cada iteracao Cria uma Nova instancia
                    //De Categoria
                    fontes.add(fonte);
                }
                return fontes;

            } catch (SQLException erro) {

                System.out.println("Erro ao tentar aceder a Base de Dados");

            }
            return null;
        }

    }
}