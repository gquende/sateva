package finance.controllers;

import finance.MainFinance;
import finance.classes.Divida;
import finance.classes.Receita;
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

import java.io.IOException;
import java.util.ArrayList;

public class DividasDoMesController {

    @FXML
    private TableView<Divida> tableView;

    @FXML
    private TableColumn<Divida, String> colunaDividendo;

    @FXML
    private TableColumn<Divida, String> colunaTipo;

    @FXML
    private TableColumn<Divida, Double> colunaValor;

    @FXML
    private TableColumn<Divida, String> colunaDescricao;

    @FXML
    private TableColumn<Divida, String> colunaDataCriacao;

    @FXML
    private TableColumn<Divida, String> colunaDataLiquidacao;

    @FXML
    private TableColumn<Divida, String> colunaEstado;

    @FXML
    private ImageView addDivida;

    public static ArrayList<Divida> dividas;

    private ObservableList<Divida> dividasObservableList;


    public void initialize(){
        carregarDados();

    }

    public void showView(){

        try {
            AnchorPane view= FXMLLoader.load(getClass().getResource("/finance/views/DividasDoMes.fxml"));
            Stage stage= new Stage();
            stage.setScene(new Scene(view));
            stage.initOwner(MainFinance.primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Receitas do Mes");
            stage.show();
        }catch (IOException erro){
            System.out.println("Erro ao tentar mostrar a View");
        }

    }
    private void carregarDados(){

        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
       // colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        //colunaFonte.setCellValueFactory(new PropertyValueFactory<>("fonte"));
        colunaDataCriacao.setCellValueFactory(new PropertyValueFactory<>("dataDivida"));
        colunaDividendo.setCellValueFactory(new PropertyValueFactory<>("dividendo"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        dividasObservableList= FXCollections.observableList(dividas);
        tableView.setItems(dividasObservableList);
       // System.out.println("Ola");
    }

}
