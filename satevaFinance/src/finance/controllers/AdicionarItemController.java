package finance.controllers;

import finance.MainFinance;
import finance.classes.AddItem;
import finance.model.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AdicionarItemController {

    @FXML
    private Button btnReceita;

    @FXML
    private Button btnDespesa;

    @FXML
    private Button btnDivida;

    @FXML
    private Button btnOrcamento;

    private static Pessoa pessoa;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCancelar;

    public static boolean adicionou=false;

    public static Stage addItemStage;//Estagio Privado para controlar as cenas Deste controlodor;


    public void initialize(){

        btnReceita.setOnMouseClicked(event -> {

            //addItemStage.close();
            AddReceitaController controller=new AddReceitaController();
            addItemStage.setTitle("Adicionar Receita");
            addItemStage.setScene(controller.showView());
           // addItemStage.showAndWait();
           // addItemStage.show();


        });
        btnDespesa.setOnMouseClicked(event -> {

            System.out.println("Inserir Despesa");
            AddDespesaController controller=new AddDespesaController();
            addItemStage.close();
            addItemStage.setTitle("Adicionar Despesa");
            addItemStage.setScene(controller.showView());
            addItemStage.show();

        });
        btnDivida.setOnMouseClicked(event -> {
            AddDividaController controller=new AddDividaController();//Para carregar a view
            addItemStage.close();//Fecha o estagio
            addItemStage=controller.showView(pessoa);//Abre o estagio com nova Scene
            addItemStage.show();
        });
    }

    public void showView()//mostra a view trazendo consigo a os dados da Pessoa
    {

        try
        {
            //this.pessoa=pessoa;
            AnchorPane addView= FXMLLoader.load(getClass().getResource("/finance/views/AdicionarItem.fxml"));
            addItemStage=new Stage();
            addItemStage.setResizable(false);
            addItemStage.setTitle("Adicionar Item");
            addItemStage.initOwner(MainFinance.primaryStage);
            addItemStage.initModality(Modality.WINDOW_MODAL);
            addItemStage.setScene(new Scene(addView));
            addItemStage.showAndWait();
            //addItemStage.show();
        }
        catch (IOException erro)
        {
            System.out.println("Erro ao tentar Mostrar o View");
        }


    }



}
