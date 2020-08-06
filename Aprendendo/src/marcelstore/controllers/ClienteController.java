package marcelstore.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import marcelstore.model.Cliente;
import marcelstore.model.dao.ClienteDao;
import marcelstore.model.database.SQLiteConection;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ClienteController {

    @FXML
    private TableView<Cliente> tableViewClientes;

    @FXML
    private TableColumn<Cliente, String> tableColummClienteNome;

    @FXML
    private TableColumn<Cliente, String > tableColumnClienteCPF;

    @FXML
    private Label labelClienteCodigo;

    @FXML
    private Label labelClienteNome;

    @FXML
    private Label labelCilenteCPF;

    @FXML
    private Label labelClienteTelefone;

    @FXML
    private Button btnInserir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnRemover;

    private List<Cliente> listClientes; //Para Carregar todos os clientes da baseDados
    private ObservableList<Cliente> observableListClientes;// Para ser usado nas Table Comulum


    private final SQLiteConection sqLiteConection=new SQLiteConection();
    private final Connection connection=sqLiteConection.conectar();
    private final ClienteDao clienteDao=new ClienteDao();


    public void initialize(){

        clienteDao.setConnection(connection);
        carregarTableViewCliente();//Carrega todos Dados na Base de Dados

       tableViewClientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue )->
               seleccionarItemNatableView(newValue));

    }

    public void carregarTableViewCliente(){

     tableColummClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
     tableColumnClienteCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));//Mostra Os valores com base a Coluna que ira receber do banco de dados
     listClientes=clienteDao.listar();//Recebe a lista com os dados do banco de dados
     observableListClientes= FXCollections.observableArrayList(listClientes);
     tableViewClientes.setItems(observableListClientes);

    }

    private void seleccionarItemNatableView(Cliente cliente)//Funcao que serve para mostrar os dados na tabela a direita
    {

        labelCilenteCPF.setText(String.valueOf(cliente.getCpf()));
        labelClienteCodigo.setText(String.valueOf(cliente.getCdCliente()));
        labelClienteNome.setText(String.valueOf(cliente.getNome()));
        labelClienteTelefone.setText(String.valueOf(cliente.getTelefone()));
        System.out.println(cliente.toString());


    }

    public void alterarCliente()throws IOException{

        Cliente cliente= tableViewClientes.getSelectionModel().getSelectedItem();//para obter o item Seleccionado
boolean teste=showViewAlterar(cliente);
if (teste)
{
    clienteDao.alterar(cliente);
    carregarTableViewCliente();
}
else
{
    Alert alert= new Alert(Alert.AlertType.ERROR);
    alert.setContentText("Escolha um cliente na Tabela");
    alert.show();
}


    }

    private boolean showViewAlterar(Cliente cliente) throws IOException {

        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/marcelstore/views/AlterarView.fxml"));
        AnchorPane view=(AnchorPane) loader.load();
        Stage stage= new Stage();
        stage.setTitle("Alterar Cliente");
        stage.setResizable(false);
        Scene scene= new Scene(view);
        stage.setScene(scene);

        AlterarViewController controller=loader.getController();
        controller.setCliente(cliente);
        System.out.println(cliente.getNome());
        controller.setStage(stage);
        //stage.show();
        stage.showAndWait();

        return controller.isConfirmar();

    }




}