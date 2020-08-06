package sateva.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sateva.Main;
import sateva.classes.Person;
import sateva.models.PessoaModel;

public class LoginController {

    public Main main;

    //  @FXML
    //  private Label fieldMenssage;

    @FXML
    private Label menssage;
    @FXML
    private TextField fieldUsername;

    @FXML
    private TextField fieldPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnClose;

    @FXML
    public void login() {

        if (fieldUsername.getText().equals("") ||fieldPassword.getText().equals("") ) /*Verifica no login se existe algum campo vazio*/{

            main.erroLogin();//Mostra a mensagem Erro;

        }

        else{

            String username=String.valueOf(fieldUsername.getText());
            String password=String.valueOf(fieldPassword.getText());
            PessoaModel pessoaModel= new PessoaModel();
            Person pessoa=pessoaModel.searchUser(username);
        try
        {
            if (pessoa.getUsername().equals(username))
            {
                if(pessoa.getPassword().equals(password))//Verifica se a palavra passe e igual ao do utilizador retornado
                {
                    main.mainPainel();
                }
                else
                {

                    menssage.setText("Password incorrect!");
                    menssage.setStyle("-fx-text-fill: #DC1900");
menssage.setVisible(true);
                   fieldUsername.setStyle("-fx-border-color: #DC1900");
                   fieldPassword.setStyle("-fx-border-color: #DC1900");

                    System.out.println("Palavra Passe incorrecta, Tente novamente!");
                }
            }
            else
                System.out.println("Utilizador Nao Encontrado!");

        }catch (NullPointerException erro){
            System.out.println("Utilizador nao encontrado!!");
        }
        }

    }
    public void initialize()

    {
        btnClose.setOnMouseClicked(event -> {
            System.exit(0);
        });
    }




}