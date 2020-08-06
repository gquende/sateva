package finance.classes;

import finance.MainFinance;
import finance.model.Pessoa;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;



public class AddItem {

private static Pessoa pessoa;

    public static Stage viewAddReceita(){

try {
    AnchorPane addView= FXMLLoader.load(AddItem.class.getResource("/finance/views/AddReceita.fxml"));
    //addItemStage.close();
    Stage addItemStage=new Stage();
    addItemStage.setResizable(false);
    addItemStage.setTitle("Adicionar Divida");
    addItemStage.initOwner(MainFinance.primaryStage);
    addItemStage.initModality(Modality.WINDOW_MODAL);
    addItemStage.setScene(new Scene(addView));
    return  addItemStage;
    //addItemStage.show();
}catch (IOException erro){

    System.out.println("Erro ao tentar mostrar a View");
}

      return null;

    }

    public static Stage viewAddDivida()
    {
        System.out.println(pessoa);
        try {

            AnchorPane addView= FXMLLoader.load(AddItem.class.getResource("/finance/views/AddDivida.fxml"));
            //addItemStage.close();
            Stage addItemStage=new Stage();
            addItemStage.setResizable(false);
            addItemStage.setTitle("Adicionar Divida");
            addItemStage.initOwner(MainFinance.primaryStage);
            addItemStage.initModality(Modality.WINDOW_MODAL);
            addItemStage.setScene(new Scene(addView));
            return  addItemStage;
            //addItemStage.show();
        }catch (IOException erro){

            System.out.println("Erro ao tentar mostrar a View");
        }

        return null;

    }



}


