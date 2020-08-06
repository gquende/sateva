package finance.controllers;

import finance.MainFinance;
import finance.classes.Receita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

public class ReceitasDoMesController {


    @FXML
    private TableView<Receita> tableView;
    @FXML
    private TableColumn<Receita, String> colunaTipo;
    @FXML
    private TableColumn<Receita, String> colunaValor;
    @FXML
    private TableColumn<Receita, String> colunaFonte;
    @FXML
    private TableColumn<Receita, String> colunaDescricao;

    @FXML
    private TableColumn<Receita, String> colunaData;
    public static ArrayList<Receita> receitas;


    private ObservableList<Receita> receitaObservableList;


    public void initialize(){
        carregarDados();
    }

    public void showView(){


      try {
          AnchorPane view= FXMLLoader.load(getClass().getResource("/finance/views/ReceitasDoMes.fxml"));
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
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaFonte.setCellValueFactory(new PropertyValueFactory<>("fonte"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        receitaObservableList= FXCollections.observableList(receitas);
        tableView.setItems(receitaObservableList);

    }

}
