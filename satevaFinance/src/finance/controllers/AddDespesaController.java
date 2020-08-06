package finance.controllers;

import finance.MainFinance;
import finance.classes.Categoria;
import finance.classes.Despesa;
import finance.classes.Receita;
import finance.model.CategoriaEFonteModel;
import finance.model.DespesaModel;
import finance.model.Pessoa;
import finance.model.ReceitaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class AddDespesaController {
    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private TextArea textAreaDescricao;

    @FXML
    private TextField textField;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private static Pessoa pessoa;

    ObservableList<String> observableListCategoria;
    ArrayList<String> categorias;

    public void initialize(){

        carregarLista();


        btnConfirmar.setOnMouseClicked(event -> {
          try {
              //Pega os dados a partir da view
              String tipo=choiceBoxTipo.getValue();
             // String fonte=fonteChoiceBox.getValue();
              String descricao=textAreaDescricao.getText();
              String data=String.valueOf(dataPicker.getValue());

//String data=dataDatePicker.getValue();
              double valor=Double.valueOf(textField.getText());
              if (data.equals("null"))//Verifica se o utilizador nao selecionou uma data
              {
                  JOptionPane.showMessageDialog(null,"Erro: Seleccione uma data");
              }
              else
              if(tipo!=null && descricao!=null && data!=null){
                  {
                      Despesa despesa= new Despesa( LoginController.getPessoa().getUsername(),tipo,descricao,data,valor);
                      DespesaModel despesaModel=new DespesaModel();
                      AdicionarItemController.adicionou=despesaModel.inserirDespesa(despesa);
                      System.out.println(AdicionarItemController.adicionou);
                      JOptionPane.showMessageDialog(null,"Dados Inseridos com sucesso!");
                      choiceBoxTipo.setValue(null);
                      //fonteChoiceBox.setValue(null);
                      dataPicker.setValue(null);
                      textAreaDescricao.setText("");
                      textField.setText("");
                  }
              }

              else
              {
                  System.out.println("Erro: Campos vazios!!");
                  JOptionPane.showMessageDialog(null,"Erro: Campos vazios!");
              }

          } catch (NumberFormatException erro){
              JOptionPane.showMessageDialog(null,"Erro: Campos vazios!");

          }

        });

        btnCancelar.setOnMouseClicked(event -> {

            AdicionarItemController.addItemStage.close();

        });

    }

    private void carregarLista(){

        CategoriaEFonteModel categoriaEFonteModel = new CategoriaEFonteModel();//Objecto Model que trata do acesso a BD no que toca as categprias e fontes
        categorias= categoriaEFonteModel.listarCategoria();
        observableListCategoria= FXCollections.observableArrayList(categorias);
        choiceBoxTipo.setItems(observableListCategoria);

    }
    public Scene showView()//mostra a view trazendo consigo a os dados da Pessoa
    {

        try
        {
            //this.pessoa=pessoa;
            AnchorPane addView= FXMLLoader.load(getClass().getResource("/finance/views/AddDespesa.fxml"));
            Stage   addItemStage=new Stage();
            addItemStage.setResizable(false);
            addItemStage.setTitle("Adicionar Despesa");
            addItemStage.initOwner(MainFinance.primaryStage);
            addItemStage.initModality(Modality.WINDOW_MODAL);
            return new Scene(addView);

        }

        catch (IOException erro)
        {
            System.out.println("Erro ao tentar Mostrar o View");
        }

        return  null;
    }
}