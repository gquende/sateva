package marcelstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMarcelStore extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("views/MainView.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Vendas com JAVAFXML");
        primaryStage.setResizable(false);//para evitar o Redimensionamento
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    //public static Stage stage;






}
