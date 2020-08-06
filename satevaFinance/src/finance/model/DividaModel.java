package finance.model;

import finance.classes.Divida;
import finance.controllers.LoginController;
import finance.model.database.SQLiteDB;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DividaModel extends SQLiteDB {




    public double totalDividasDoMesActual(){
      conectar();
      String query="Select Sum(valor) as total from divida where user=? and STRFTIME('%m',dataDivida)=STRFTIME('%m','now') and estado<>'Pago'";

      try{
          PreparedStatement stm=conection.prepareStatement(query);
          stm.setString(1, LoginController.getPessoa().getUsername());
          ResultSet resultado=stm.executeQuery();

          return resultado.getDouble("total");

      }catch (SQLException erro){

          System.out.println("Erro ao tentar achar o somatorio");
          JOptionPane.showMessageDialog(null,erro.getMessage());
      }

return 0;
    }
    public double totalDividasDoMesAnterior(){
        conectar();
        String query="Select Sum(valor) as total from divida where user=? and STRFTIME('%m',dataDivida)=STRFTIME('%m',DATE('now','-1 month')) and estado<>'Pago'";

        try{
            PreparedStatement stm=conection.prepareStatement(query);
            stm.setString(1, LoginController.getPessoa().getUsername());
            ResultSet resultado=stm.executeQuery();

            return resultado.getDouble("total");

        }catch (SQLException erro){

            System.out.println("Erro ao tentar achar o somatorio");
            JOptionPane.showMessageDialog(null,erro.getMessage());
        }

        return 0;
    }
    public boolean inserirDivida(Divida divida){
        conectar();
        String sql="INSERT INTO divida(user,tipo,descricao,dataDivida,dataLiquidacao,estado,dividendo,valor) values(?,?,?,?,?,?,?,?)";
        try{

            PreparedStatement stm=conection.prepareStatement(sql);
            stm.setString(1,divida.getUser());
            stm.setString(2,divida.getTipo());
            stm.setString(3,divida.getDescricao());
            stm.setString(4,divida.getDataDivida());
            stm.setString(5,divida.getDataLiquidacao());
            stm.setString(6,divida.getEstado());
            stm.setString(7,divida.getDividendo());
            stm.setDouble(8,divida.getValor());
            stm.execute();
            return true;
        }catch (SQLException erro){

            JOptionPane.showMessageDialog(null, "Erro ao tentar aceder Inserir Divida\n\n"+erro.getMessage());
        }
        return  false;
    }
    public ArrayList<Divida> listarDividas(String username){
        ArrayList<Divida> dividas= new ArrayList<>();
        conectar();
        String sql="SELECT * FROM divida where user=?";
        try
        {
            PreparedStatement stm=conection.prepareStatement(sql);
            stm.setString(1,username);
            ResultSet resultado=stm.executeQuery();
            if(resultado!=null)
                while (resultado.next()){


                    Divida divida= new Divida(resultado.getString("user"),resultado.getInt("id"),
                            resultado.getString("tipo"),resultado.getString("descricao"),
                            resultado.getString("dataDivida"),resultado.getDouble("valor"),
                            resultado.getString("estado"),resultado.getString("dividendo"),
                            resultado.getString("dataLiquidacao"));
                    dividas.add(divida);

/*
                    dividas.add(new Divida(resultado.getString("user"),resultado.getInt("id"),
                            resultado.getString("tipo"),resultado.getString("descricao"),
                            resultado.getString("dataDivida"),resultado.getDouble("valor"),
                            resultado.getString("estado"),resultado.getString("dividendo")));*/
                }

            return dividas;
        }
        catch (SQLException erro){

            JOptionPane.showMessageDialog(null, "Erro ao tentar listar as Dividas\n"+erro.getMessage());
        }

        return null;
    }

    public double totalDividaDoDia(String user, String mes, String dia){

        conectar();
                try{

                    String query="Select SUM(valor) as total from divida where user=? and STRFTIME('%m',dataDivida)=? and STRFTIME('%d',dataDivida)=?";
                    PreparedStatement stm= conection.prepareStatement(query);
                    stm.setString(1,user);
                    stm.setString(2,mes);
                    stm.setString(3,dia);
                    ResultSet resultado=stm.executeQuery();

                    if(resultado==null)
                        return  0;
                    else
                        return resultado.getDouble("total");
                }catch (SQLException erro){


                    JOptionPane.showMessageDialog(null, "Erro ao tentar listar divida do Dia: \n"+erro.getMessage());

                }
                return 0;

    }

}
