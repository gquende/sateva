package finance.controllers;

import finance.MainFinance;
import finance.classes.Receita;
import finance.model.CategoriaEFonteModel;
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

public class AddReceitaController {
    @FXML
    private ChoiceBox<String> tipoChoiceBox;

    @FXML
    private ChoiceBox<String> fonteChoiceBox;

    @FXML
    private TextArea descTextArea;

    @FXML
    private TextField valorTextField;

    @FXML
    private DatePicker dataDatePicker;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private static Pessoa pessoa;//Dados do Login;

    ObservableList<String> observableListCategoria;
    ArrayList<String> categorias;

    ObservableList<String> observableListFonte;
    ArrayList<String> fontes;


    public void initialize(){
        //System.out.println(pessoa.getNome());
        carregarLista();
        //System.out.println(tipoChoiceBox.getSelectionModel().selectedItemProperty());


        btnConfirmar.setOnMouseClicked(event -> {
          try {
              //Pega os dados a partir da view
              String tipo=tipoChoiceBox.getValue();
              String fonte=fonteChoiceBox.getValue();
              String descricao=descTextArea.getText();
              String data=String.valueOf(dataDatePicker.getValue());

//String data=dataDatePicker.getValue();
              double valor=Double.valueOf(valorTextField.getText());
              if (data.equals("null"))//Verifica se o utilizador nao selecionou uma data
              {
                  JOptionPane.showMessageDialog(null,"Erro: Seleccione uma data");
              }
              else
              if(tipo!=null && fonte!=null && descricao!=null && data!=null){
                  {
                      Receita receita= new Receita( LoginController.getPessoa().getUsername(),tipo, descricao, fonte, valor, data);
                      ReceitaModel receitaModel=new ReceitaModel();
                      AdicionarItemController.adicionou=receitaModel.adicionarReceita(receita); //Para enviar notificacao ao controlador
                      System.out.println(AdicionarItemController.adicionou);
                      JOptionPane.showMessageDialog(null,"Dados Inseridos com sucesso!");
                      tipoChoiceBox.setValue(null);
                      fonteChoiceBox.setValue(null);
                      dataDatePicker.setValue(null);
                      descTextArea.setText("");
                      valorTextField.setText("");
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
            //AdicionarItemController controller= new AdicionarItemController();
         //   controller.showView();


        });
    }

    private void carregarLista(){

        CategoriaEFonteModel categoriaEFonteModel = new CategoriaEFonteModel();//Objecto Model que trata do acesso a BD no que toca as categprias e fontes
        categorias= categoriaEFonteModel.listarCategoria();
        observableListCategoria= FXCollections.observableArrayList(categorias);
        //tipoChoiceBox.itemsProperty(observableListCategoria);
        tipoChoiceBox.setItems(observableListCategoria);
        fontes=categoriaEFonteModel.listarFonte();
        observableListFonte=FXCollections.observableArrayList(fontes);
        fonteChoiceBox.setItems(observableListFonte);
    }

    public Scene showView()//mostra a view trazendo consigo a os dados da Pessoa
    {

        try
        {
            //this.pessoa=pessoa;
            AnchorPane addView= FXMLLoader.load(getClass().getResource("/finance/views/AddReceita.fxml"));
            Stage   addItemStage=new Stage();
            addItemStage.setResizable(false);
            addItemStage.setTitle("Adicionar Receita");
            addItemStage.initOwner(MainFinance.primaryStage);
            addItemStage.initModality(Modality.WINDOW_MODAL);
            //addItemStage.setScene(new Scene(addView));
           return new Scene(addView);
            // return addItemStage;
        }
        catch (IOException erro)
        {
            System.out.println("Erro ao tentar Mostrar o View");
        }

        return  null;
    }


}
