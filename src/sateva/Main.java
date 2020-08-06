package sateva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sateva.controllers.MainTopViewController;
import sateva.models.DataBase;
import sateva.models.PessoaModel;

import java.io.IOException;

public class Main extends Application {




    public static Stage primaryStage;
   // private static AnchorPane mainLayout;
    public static BorderPane mainLayout;


    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage=primaryStage;
        primaryStage.setTitle("Welcome to Sateva");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //showLogin();
    mainPainel();
    }

    private static void showLogin() //Show Login Screen
    {

    try {
        FXMLLoader loader=new FXMLLoader();
       // loader.setLocationMa==.getResource("views/MainView.fxml"));
        loader.setLocation(Main.class.getResource("views/LoginView.fxml"));
        //System.out.println(Main.class.getResource("views/LoginView.fxml"));
       mainLayout=loader.load();
        //AnchorPane viewLogin=loader.load();
        Scene scene=new Scene(mainLayout);       //primaryStage.setScene(vi);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    catch (IOException erro)
    {

        System.out.println("Erro a tentar mostrar a View\n");
        erro.printStackTrace();

    }

    }
    public static void erroLogin()// Show When happen an erro in Login
    {

try
{
     FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("views/ErroLogin.fxml"));
    AnchorPane novo=loader.load();//Load Error Login View
    System.out.println("Ola");
    Scene scene= new Scene(novo);
    Stage stage= new Stage();
    stage.setTitle("Adicionar Empregado");
    stage.initModality(Modality.WINDOW_MODAL);// For depend
    stage.initOwner(primaryStage);//For depend to Main Stage
    stage.setScene(scene);
    stage.show();
    }

catch (IOException erro){

    System.out.println("Erro a tentar mostrar a View!!!");

}

    }


    public static  void mainPainel(){

       try{
           FXMLLoader loader= new FXMLLoader();
           loader.setLocation(Main.class.getResource("views/MainView.fxml"));
           mainLayout=loader.load();
           Scene mainView= new Scene(mainLayout,1200,800);
           primaryStage.setScene(mainView);
           primaryStage.setTitle("Sateva-Main Menu");

           primaryStage.show();
           mainTopView();

       }
       catch (IOException erro)
       {
           System.out.println("Erro tentar mostrar a View!\n"+erro.getStackTrace());
       }

    }


    public static  void mainTopView() //This conofiguration will go to LoginController

    {

        try {
            MainTopViewController.dadosLogin("Adolfo Qeraldo Quende","O mondo esta cheio de madaldade nos geralmente nunca sabemos o que nos estar por vir");
            //System.out.println(MainTopViewController.username2);
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/MainTopView.fxml"));
            AnchorPane mainTopView=loader.load();
            Main.mainLayout.setTop(mainTopView);
        }
        catch (IOException erro){


            System.out.println("Erro tentar abrir a Top View");
        }





    }


    public static void main(String[] args) {

        launch(args);
    }
}
