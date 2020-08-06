package sateva.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.html.ImageView;

public class MainTopViewController {

    @FXML
    private Label quotesForDay;

    @FXML
    private Label usernameLogin;

    @FXML
    private static ImageView loginIcon;

    public static String username;
    public static String quotes;



    public void initialize(){
       // System.out.println(username2);
        usernameLogin.setText(username);
       quotesForDay.setText(quotes);
    }

    public static void dadosLogin(String user, String quote){

        username=user;
        quotes=quote;
    }

}
