package finance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFinance extends Application {

    public static Stage primaryStage;

    public void start(Stage stage)throws IOException{
        primaryStage=stage;
        FXMLLoader loader=new FXMLLoader();
        // loader.setLocation(MainFinance.class.getResource("/finance/views/MainViewFinance.fxml"));
        loader.setLocation(MainFinance.class.getResource("/finance/views/LoginView.fxml"));

        // AnchorPane root=new AnchorPane();
        Parent root=loader.load();
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sateva- Personal Finance");
        primaryStage.setResizable(false);//para evitar o Redimensionamento
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
