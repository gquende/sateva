package finance.controllers;

import finance.MainFinance;
import finance.classes.Despesa;
import finance.classes.Divida;
import finance.model.DividaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;

public class DespesasDoMesController {


    @FXML
    private TableView<Despesa> tableView;

    @FXML
    private TableColumn<Despesa, String> colunaTipo;

    @FXML
    private TableColumn<Despesa, String> colunaValor;

    @FXML
    private TableColumn<Despesa, String> colunaDescricao;

    @FXML
    private TableColumn<Despesa, String> colunaData;

    @FXML
    private ImageView addDespesa;

    public static ArrayList<Despesa> despesas;

    private ObservableList<Despesa> despesasObservableList;

    //Tabela de dividas
    @FXML
    private TableView<Divida> tabelaDividas;

    @FXML
    private TableColumn<Divida, String> colunaDividendo;

    @FXML
    private TableColumn<Divida, String> colunaTipoDivida;

    @FXML
    private TableColumn<Divida, String> colunaValorDivida;

    @FXML
    private TableColumn<Divida, String> colunaDescricaoDivida;

    @FXML
    private TableColumn<Divida, String> colunaDataDaDivida;

    @FXML
    private TableColumn<Divida, String> colunaDataDoPagamento;

    public static ArrayList<Divida> dividasPagas;

    private ObservableList<Divida> dividasPagasObservableList;


    public void initialize(){
        carregarDados();

    }

    public void showView(){


        try {
            AnchorPane view= FXMLLoader.load(getClass().getResource("/finance/views/DespesasDoMes.fxml"));
            Stage stage= new Stage();
            stage.setScene(new Scene(view));
            stage.initOwner(MainFinance.primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Despesas do Mes");
            stage.show();
        }catch (IOException erro){
            JOptionPane.showMessageDialog(null, "Erro ao tentar mostrar a view\n"+erro.getMessage());
        }

    }
    private void carregarDados(){


        //Despesas Normais
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        despesasObservableList= FXCollections.observableList(despesas);
        tableView.setItems(despesasObservableList);
        //Dividas Pagas

        colunaDividendo.setCellValueFactory(new PropertyValueFactory<>("dividendo"));

        colunaTipoDivida.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaValorDivida.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaDescricaoDivida.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaDataDaDivida.setCellValueFactory(new PropertyValueFactory<>("dataDivida"));
        colunaDataDoPagamento.setCellValueFactory(new PropertyValueFactory<>("dataLiquidacao"));



        dividasPagasObservableList=FXCollections.observableList(dividasPagas);
        tabelaDividas.setItems(dividasPagasObservableList);
    }




}
