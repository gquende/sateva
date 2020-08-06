package employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class MainEmployee extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;


    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage=primaryStage;
        primaryStage.setTitle("This is my first Test");

        showMainView();
        showMenuItems();
    }

    private void showMainView() throws IOException{

        FXMLLoader loader=new FXMLLoader();//Classe que cria um objecto para manipulacao de ficheiros FXML
        loader.setLocation(getClass().getResource("Views/MainView.fxml")); //Selecciona o Ficheiro a ser carregado
        mainLayout=loader.load();//Carrega o ficheiro
        Scene scene =new Scene(mainLayout); //Selecciona o ficheiro numa Cena
        primaryStage.setScene(scene); //Selecio a Cena que devera ser apresentado
        primaryStage.show();

    }

    public static void showMenuItems() throws IOException{

        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(MainEmployee.class.getResource("Views/MainItems.fxml"));
        BorderPane mainItems= loader.load();
        mainLayout.setCenter(mainItems);


    }

    public static void showDepElectrico() throws IOException{

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MainEmployee.class.getResource("Views/depElectrico.fxml"));
        BorderPane depElectrico= loader.load();
        mainLayout.setCenter(depElectrico);

    }
    public static void showDepMecanica() throws IOException{

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MainEmployee.class.getResource("Views/depMecanica.fxml"));
        BorderPane depMecanica= loader.load();
        mainLayout.setCenter(depMecanica);

    }

    public static void showAdicionarEmpregado() throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(MainEmployee.class.getResource("Views/addEmpoyee.fxml"));
        AnchorPane novo=loader.load();


        //Estagio e um local onde sera mostrado uma Cena
        //Cena e tudo aquilo que sera mostra o seja o palco onde tudo vai acontecer
        //Nas cenas pode por botoe ancoras etc
        //Nos estagio so se poe as cenas
        Scene scene= new Scene(novo);

        Stage stage= new Stage(); //Cria um novo estagio que devera ser mostrado
        stage.setTitle("Adicionar Empregado");
        stage.initModality(Modality.WINDOW_MODAL);//Selecciona que forma o tela estara dependente do seu proprietario
        stage.initOwner(primaryStage);// Selecciona quem sera o seu proprietario

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }





}
