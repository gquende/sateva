package sateva.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sateva.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileStore;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;


public class MainController {

private static  Main main;

    @FXML
private Button btnTask;

    @FXML
    private void mostrarImage(){
        Stage stage= new Stage();
//        FileChooser fileChooser= new FileChooser();
  //      fileChooser.setTitle("Abrir Ar55quvio");
        //File arq =fileChooser.showOpenDialog(stage);
        //System.out.println(arq);


}


@FXML
    private void taskView(){

       try {
           btnTask.setStyle("-fx-background-color: #392611");
           FXMLLoader loader= new FXMLLoader();
           loader.setLocation(Main.class.getResource("views/task/MainViewTask.fxml"));
           BorderPane mainViewTask=loader.load();
           main.mainLayout.setCenter(mainViewTask);

       }
       catch (IOException erro)
       {
           System.out.println("Erro ao tentar Mostrar a View de Tarefas");
       }

    }

    @FXML
    private void financialView(){

        try {

            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/financial/MainViewFinancial.fxml"));
            BorderPane mainViewTask=loader.load();
            main.mainLayout.setCenter(mainViewTask);
        }
        catch (IOException erro)
        {
            System.out.println("Erro ao tentar Mostrar a View de Tarefas");
        }

    }






}
