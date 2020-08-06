package finance.model;

import finance.classes.Orcamento;
import finance.model.database.SQLiteDB;


import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class OrcamentoModel extends SQLiteDB {

    //  private Orcamento orcamento;

    public boolean inserir(Orcamento orcamento) {

        conectar();
        String query = "INSERT INTO orcamento(user,tipo,valor,data,descricao) values(?,?,?,?,?)";


        try {

            PreparedStatement stm = conection.prepareStatement(query);
            stm.setString(1, orcamento.getUser());
            stm.setString(2, orcamento.getTipo());
            stm.setDouble(3, orcamento.getValor());
            stm.setString(4, orcamento.getData());
            stm.setString(5, orcamento.getDescricao());
            stm.execute();
            return true;

        } catch (SQLException erro) {


            JOptionPane.showMessageDialog(null, "Erro: Ao tentar inserir Orcamento: " + erro.getMessage());
           // return false;
        }
        return false;

    }
    public ArrayList<Orcamento> listar(){
        ArrayList<Orcamento> orcamentos= new ArrayList<>();

        conectar();
        try{

            String query="SELECT* from orcamento";
            PreparedStatement stm=conection.prepareStatement(query);
            ResultSet resultado=stm.executeQuery();
            if(resultado==null)
                return null;
            else
            {
                while (resultado.next())
                {


                    Orcamento orcamento=new Orcamento(resultado.getInt("id"),resultado.getString("user"),resultado.getString("tipo"),
                            resultado.getDouble("valor"),resultado.getString("data"),resultado.getString("descricao"));
                    orcamentos.add(orcamento);
                }
                return orcamentos;

            }



        }catch (SQLException erro){

            JOptionPane.showMessageDialog(null, "Erro ao tentar Listar orcamentos\n"+erro.getMessage());

        }
        return null;

    }
    public ArrayList<Orcamento> orcamentoMensal(String user, String mes){

        conectar();

        ArrayList<Orcamento> orcamentos= new ArrayList<>();
        try
        {
            String sql="Select* from orcamento where user=? and STRFTIME('%m',data)=?)";
            PreparedStatement stm=conection.prepareStatement(sql);
            stm.setString(1,user);
            stm.setString(2,mes);
            ResultSet resultado=stm.executeQuery();

            if (resultado==null)
                return null;
            else {

                while (resultado.next()){

                    Orcamento orcamento= new Orcamento(resultado.getInt("id"),resultado.getString("user"),
                            resultado.getString("tipo"),resultado.getDouble("valor"),resultado.getString("data"),
                            resultado.getString("descricao"));

                    orcamentos.add(orcamento);

                }
                return orcamentos;

            }



        } catch (SQLException erro){


            JOptionPane.showMessageDialog(null, "Erro ao tentar Listar orcamento Mensal!\n"+erro.getMessage());

        }

return null;



    }



    }





