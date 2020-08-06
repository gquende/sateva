package finance.controllers;

import finance.MainFinance;
import finance.classes.Divida;
import finance.model.CategoriaEFonteModel;
import finance.model.DividaModel;
import finance.model.Pessoa;
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

public class AddDividaController {


    @FXML
    private ChoiceBox<String> tipoChoiceBox;

    @FXML
    private ChoiceBox<String> choiceBoxEstado;

    @FXML
    private TextArea textAreaDescricao;

    @FXML
    private TextField textFieldValor;

    @FXML
    private DatePicker dataDivida;

    @FXML
    private TextField textFieldDividendo;



    @FXML
    private DatePicker dataLiquidacao;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    private static Pessoa pessoa;//Dados do Login;

    @FXML
    private Label textFieldDataLiquidacao;

    ObservableList<String> observableListCategoria;
    ArrayList<String> categorias;

    ObservableList<String> observableListEstados;
    ArrayList<String> estados;




    public void initialize(){

        textFieldDataLiquidacao.setVisible(false);
        dataLiquidacao.setVisible(false);
        carregarLista();

        choiceBoxEstado.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{

            if (newValue.equals("Pago")){

                textFieldDataLiquidacao.setVisible(true);
                dataLiquidacao.setVisible(true);
            }
            else
            {
                textFieldDataLiquidacao.setVisible(false);
                dataLiquidacao.setVisible(false);
            }


        });
        btnCancelar.setOnMouseClicked(event -> {
            AdicionarItemController.addItemStage.close();

        });

        btnConfirmar.setOnMouseClicked(event -> {
            inserirDados();

        });
    }

    private void carregarLista(){

        CategoriaEFonteModel categoriaEFonteModel = new CategoriaEFonteModel();//Objecto Model que trata do acesso a BD no que toca as categprias e fontes
        categorias= categoriaEFonteModel.listarCategoria();
        observableListCategoria= FXCollections.observableArrayList(categorias);
        tipoChoiceBox.setItems(observableListCategoria);
        estados= new ArrayList<>();

        estados.add("Pago");
        estados.add("Nao Pago");
        observableListEstados=FXCollections.observableArrayList(estados);
        choiceBoxEstado.setItems(observableListEstados);
    }

    public Stage showView(Pessoa pessoa)//mostra a view trazendo consigo a os dados da Pessoa
    {

        try
        {
            this.pessoa=pessoa;
            AnchorPane addView= FXMLLoader.load(getClass().getResource("/finance/views/AddDivida.fxml"));
            Stage   addItemStage=new Stage();
            addItemStage.setResizable(false);
            addItemStage.setTitle("Adicionar Divida");
            addItemStage.initOwner(MainFinance.primaryStage);
            addItemStage.initModality(Modality.WINDOW_MODAL);
            addItemStage.setScene(new Scene(addView));
            return addItemStage;
        }
        catch (IOException erro)
        {
            System.out.println("Erro ao tentar Mostrar o View");
        }

        return null;
    }

    private void inserirDados(){

        DividaModel dividaModel=new DividaModel();



        try {

            String dividendo=textFieldDividendo.getText();
            String tipo=tipoChoiceBox.getValue();
            String descricao=textAreaDescricao.getText();
            String data=String.valueOf(dataDivida.getValue());
            double valor= Double.valueOf(textFieldValor.getText());
            String estado= choiceBoxEstado.getValue();
            String dataLiquid= String.valueOf(dataLiquidacao.getValue());
            System.out.println(valor);

            if ((dividendo!=null || !dividendo.equals(""))
                    && tipo!=null &&
                    (descricao!=null || !descricao.equals(""))
                    && data!=null
                    && estado!=null) {

                if (dataLiquidacao!=null)
                {
                    Divida divida= new Divida(LoginController.getPessoa().getUsername(),tipo,descricao,data,valor,estado,dividendo,dataLiquid);
                    if (    dividaModel.inserirDivida(divida)==true){

                        choiceBoxEstado.setValue(null);
                        tipoChoiceBox.setValue(null);
                        textAreaDescricao.setText("");
                        textFieldDividendo.setText("");
                        dataDivida.setValue(null);
                        textFieldValor.setText("");
                        dataLiquidacao.setValue(null);
                    }

                }
                else
                {
                    Divida divida= new Divida(LoginController.getPessoa().getUsername(),tipo,descricao,data,valor,estado,dividendo);
                    dividaModel.inserirDivida(divida);
                }


            }
            else {

                JOptionPane.showMessageDialog(null, "Erro: Verifica os campos inseridos!");

            }
        }
        catch (NumberFormatException erro){

            JOptionPane.showMessageDialog(null,"Erro: Valor invalido!");
        }
        catch (NullPointerException erro){

            JOptionPane.showMessageDialog(null, "Erro em campos");
        }

    }

}
