package marcelstore.model.dao;

import marcelstore.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Cliente cliente){

        String sql="Insert into clientes (nome,cpf, telefone) values(?,?,?)";//Os pontos de interrogacao significam que serao parametro a ser adicionado depois

        try{
            PreparedStatement stmt= connection.prepareStatement(sql);//Recebe a query que devera ser executada
            stmt.setString(1,cliente.getNome());//Parametros que serao adicionado no local onde estiver o ponto de interrogacao
            stmt.setString(2,cliente.getCpf());
            stmt.setString(3,cliente.getTelefone());
            stmt.execute();//Executa o codigo SQL

            return true;
        }
        catch (SQLException ex){

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null, ex);
            return false;
        }

    }

    public boolean alterar(Cliente cliente){

        System.out.println("Entrei");
        String sql="UPDATE cliente SET nome=?, cpf=?, telefone=? where cdCliente=?";

        try{
            PreparedStatement stmt= connection.prepareStatement(sql);
            stmt.setString(1,cliente.getNome());//Parametros que serao adicionado no local onde estiver o ponto de interrogacao
            stmt.setString(2,cliente.getCpf());
            stmt.setString(3,cliente.getTelefone());
            stmt.setString(4,cliente.getCdCliente());
            stmt.execute();//Executa o codigo SQL
            return true;
        }
        catch (SQLException ex){

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null, ex);
            return false;
        }

    }

    public boolean remover(Cliente cliente){

        String sql="DELETE FROM clientes WHERE cdCliente=?";

        try{
            PreparedStatement stmt= connection.prepareStatement(sql);
            stmt.setString(1,cliente.getCdCliente());
            stmt.execute();//Executa o codigo SQL
            return true;
        }
        catch (SQLException ex){

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null, ex);
            return false;
        }

    }

    public List<Cliente> listar(){

        String sql="SELECT * FROM cliente";
        List<Cliente> clientes= new ArrayList<>();

        try{

            PreparedStatement stm=connection.prepareStatement(sql);
            ResultSet resultado=stm.executeQuery();
            while (resultado.next())//Itera o o resultado recebido da Base de Dados
            {
                Cliente cliente= new Cliente();
                cliente.setCdCliente(String.valueOf(resultado.getInt("cdCliente")));//Obtem o valor da coluna cdCliente que neste caso e um interiro
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setTelefone(resultado.getString("telefone"));
                clientes.add(cliente);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        return clientes;


    }

    public Cliente buscar(Cliente cliente){
        String sql="SELECT * FROM clientes WHERE cdCliente=?";

        Cliente retorno=new Cliente();
        try {

            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setString(1,cliente.getCdCliente());
            ResultSet resultado=stm.executeQuery();

            while (resultado.next()){
                //Cliente cliente1=new Cliente();
                retorno.setTelefone(resultado.getString("telefone"));
                retorno.setCpf(resultado.getString("cpf"));
                retorno.setNome(resultado.getString("nome"));
                retorno.setCdCliente(String.valueOf(resultado.getInt("cdCliente")));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        return retorno;

    }


}
