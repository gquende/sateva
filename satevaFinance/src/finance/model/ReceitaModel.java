package finance.model;

import finance.classes.Receita;
import finance.model.Pessoa;
import finance.model.database.SQLiteDB;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceitaModel extends SQLiteDB {

    public boolean adicionarReceita(Receita receita){

        conectar();
        try{

            String query="INSERT into receita(user, tipo, descricao,fonte, valor,data) values(?,?,?,?,?,?)";
            PreparedStatement stm=conection.prepareStatement(query);
            stm.setString(1,receita.getUser());
            stm.setString(2,receita.getTipo());
            stm.setString(3,receita.getDescricao());
            stm.setString(4,receita.getFonte());
            stm.setDouble(5,receita.getValor());
            stm.setString(6,receita.getData());
            stm.execute();
            return true;


        }
        catch (SQLException erro){

            System.out.println("Erro ao tentar aceder a Base de Dados");
        }

        return false;
    }
    public ArrayList<Receita> listarReceitas(String username){

        String query="Select* from receita where user=?";
        ArrayList<Receita> receitas=new ArrayList<>();
        try{
            conectar();
            PreparedStatement stm=conection.prepareStatement(query);
            stm.setString(1,username);
            ResultSet resultado=stm.executeQuery();
            while (resultado.next()){

                Receita receita=new Receita(resultado.getInt("id"),resultado.getString("user"),
                        resultado.getString("tipo"),resultado.getString("descricao"),
                        resultado.getString("fonte"),resultado.getDouble("valor"),
                        resultado.getString("data"));
                receitas.add(receita);


            }
            return receitas;


        }catch (SQLException erro){

            System.out.println("Erro ao Tentar recuperar os dados das receitas");
        }


return null;
    }

    public double totalReceitaDoDia(String user, String mes, String dia){

conectar();

try {

    String query="SELECT SUM(valor) as total from receita where user=? and STRFTIME('%m',data)=? and STRFTIME('%d',data)=?";
    PreparedStatement stm=conection.prepareStatement(query);
    stm.setString(1,user);
    stm.setString(2,mes);
    stm.setString(3,dia);
    ResultSet resultado=stm.executeQuery();
    if (resultado==null)
        return 0;
    else
        return  resultado.getDouble("total");
}catch (SQLException erro){

    JOptionPane.showMessageDialog(null,"Erro ao tentar aceder a Base de Dados\n"+erro.getMessage());

}
return 0;

    }

}
