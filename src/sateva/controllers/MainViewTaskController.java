package sateva.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import sateva.Main;

import java.io.IOException;

public class MainViewTaskController {

    @FXML
    private VBox items;

    public void initialize(){
        Node[] nodes= new Node[10];
        try {
            for (int i=0; i<nodes.length; i++){
                nodes[i]= FXMLLoader.load(Main.class.getResource("views/task/itemTask.fxml"));//Load de Item to MainTask
                items.getChildren().add(nodes[i]);
            }

        } catch (IOException erro){
            System.out.println("Erro Ao tentar mostrar a Tela");
            //erro.printStackTrace();
        }

    }

}
