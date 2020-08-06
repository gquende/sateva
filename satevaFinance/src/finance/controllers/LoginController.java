package finance.controllers;

import finance.MainFinance;
import finance.model.Pessoa;
import finance.model.PessoaModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class LoginController {


    //  @FXML
    //  private Label fieldMenssage;

    @FXML
    private Label menssage;

    @FXML
    private Label labelCriarConta;

    @FXML
    private TextField fieldUsername;

    @FXML
    private TextField fieldPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnClose;

    private static Pessoa pessoa;

    @FXML
    private Pane paneLogin;
    @FXML
    private Pane paneSingIn;

    @FXML
    private ImageView avatarSingin;

    @FXML
    private Label labelFazerLogin;

    public static Pessoa getPessoa() {
        return pessoa;
    }

    @FXML
    public void initialize() throws SQLException
    {

        paneLogin.setVisible(true);
        paneSingIn.setVisible(false);



        btnClose.setOnMouseClicked(event -> {
            System.exit(0);
        });

        btnLogin.setOnMouseClicked(event -> {
        fazerLogin();
        });


        labelCriarConta.setOnMouseClicked(event -> {

            paneLogin.setVisible(false);
            paneSingIn.setVisible(true);

            System.out.println("Clicou em Criar Conta!");

        });
        labelFazerLogin.setOnMouseClicked(event -> {

            paneLogin.setVisible(true);
            paneSingIn.setVisible(false);


        });

        avatarSingin.setOnMouseClicked(event -> {

            FileChooser.ExtensionFilter extensao=new FileChooser.ExtensionFilter("Image Files","*.jpeg","*.jpg","*.png");
            FileChooser escolher=new FileChooser();
            escolher.getExtensionFilters().add(extensao);
            File ficheiro= escolher.showOpenDialog(null);
            //ficheiro.toURI();
            System.out.println(ficheiro.toPath());
            System.out.println( ficheiro.getName());
            System.out.println(ficheiro.getAbsoluteFile());



        });

    }


    private void fazerLogin(){

        Pessoa pessoa=login();//Pode ser eliminado

        if (pessoa!=null)
        {
            try{
                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource("/finance/views/MainViewFinance.fxml"));
                BorderPane root= new BorderPane();
                root=loader.load();
                MainViewFinanceController controller=loader.getController();
                //controller.dadosLogin(pessoa);
                // MainViewFinanceController.login=pessoa;
                MainFinance.primaryStage.setScene(new Scene(root));//Carrega a View No Stage Principal
                MainFinance.primaryStage.setTitle("Sateva- Personal Finance");
                MainFinance.primaryStage.show();
            }catch (IOException erro){
                System.out.println("Erro ao tentar mostrar a View!");
                erro.printStackTrace();
            }

        }
        else {
            JOptionPane.showMessageDialog(null,"Dados de Login incorrecto!");
        }

    }

    public Pessoa login() {

        String username=fieldUsername.getText();
        String password=fieldPassword.getText();

        Pessoa pessoa;
        PessoaModel pessoaModel=new PessoaModel();


        try {
            ResultSet log=pessoaModel.login(username,password);//Recebe o resultado da pesquisa
            int cont=0;
            if (log!=null)//verifica se existe algum resultado
                while (log.next())
                {
                    cont++;

                    String nome=log.getString("nome");
                    String sobrenome=log.getString("sobrenome");
                    String user=log.getString("username");
                    String dataNasc=log.getString("dataNasc");
                    String sexo=log.getString("sexo");

                    pessoa=new Pessoa( nome,  sobrenome, sexo, dataNasc, user);
                    this.pessoa=pessoa;
                    return pessoa;//Retorna os dados da pessoa

                }



        }catch (SQLException erro){
            System.out.println("Erro de SQL");
        }

        return null;
    }



}