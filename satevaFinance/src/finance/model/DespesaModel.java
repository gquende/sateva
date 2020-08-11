/* Classe Responsavel por tratar das Despesas com a base de Dados*/



package finance.model;
import finance.classes.Despesa;
import finance.model.database.SQLiteDB;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DespesaModel extends SQLiteDB {

    public boolean inserirDespesa(Despesa despesa)
    {
        conectar();
        try{

            String sql="INSERT INTO despesa(user,tipo,descricao,data,valor) values(?,?,?,?,?)";
            PreparedStatement stm= conection.prepareStatement(sql);
            stm.setString(1,despesa.getUser());
            stm.setString(2,despesa.getTipo());
            stm.setString(3,despesa.getDescricao());
            stm.setString(4,despesa.getData());
            stm.setDouble(5,despesa.getValor());
            System.out.println(stm.execute());
            return true;
        }catch (SQLException erro){


            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a Despesa\n"+erro.getMessage());

        }
        return false;
    }
    public ArrayList<Despesa> listarDespesas(String username){

        ArrayList<Despesa> despesas=new ArrayList<>();
        String sql="SELECT * FROM despesa where user=?";

        try {
            conectar();
            PreparedStatement stm= conection.prepareStatement(sql);
            stm.setString(1,username);
            ResultSet resultado=stm.executeQuery();

            while(resultado.next()){

                Despesa despesa= new Despesa(resultado.getString("user"),resultado.getInt("id"),
                        resultado.getString("tipo"),resultado.getString("descricao"),resultado.getString("data"),
                        resultado.getDouble("valor"));
                despesas.add(despesa);
            }
            return despesas;
        }catch (SQLException erro){

            JOptionPane.showMessageDialog(null, "Erro ao recuperar os Dados\n"+erro.getMessage());
        }
        return null;
    }

    public double totalDespesaDoDia(String user, String mes, String dia){

        conectar();

        try {

            String query="SELECT SUM(valor) as total from despesa where user=? and STRFTIME('%m',data)=? and STRFTIME('%d',data)=?";
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


