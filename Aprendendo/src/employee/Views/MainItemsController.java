package employee.Views;

import employee.MainEmployee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainItemsController {


    @FXML
    private Button botao;




public MainEmployee mainEmployee;

@FXML
public void depElectrico()throws IOException {


    botao.setStyle("-fx-background-color : #3E86A0");

    mainEmployee.showDepElectrico();
}

public void backHome()throws IOException{

    botao.setStyle("-fx-background-color : #2B2B2B");
mainEmployee.showMenuItems();

}

public void showDepMecanica()throws IOException{
    //botao.setStyle("-fx-background-color : #2B2B2B");
    mainEmployee.showDepMecanica();

}

    public void showAdicionar()throws IOException{

        mainEmployee.showAdicionarEmpregado();

    }


}
