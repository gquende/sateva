package employee.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Calendar;

public class AddEmpoyee {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoSobrenome;

    @FXML
    private DatePicker dataSelect;

    @FXML
    private TextField campoIdade;

    @FXML
    private ChoiceBox statusBox;
    @FXML
    private ToggleGroup sexo;

    private RadioButton sexoM;
    private  RadioButton sexoF;




    private ObservableList<String> estados= FXCollections.observableArrayList("Casado","Solteiro");


    public  void limparCampo(){

        campoNome.setText("");
        campoSobrenome.setText("");


    }




    public void initialize(){

        campoNome.setText("Adolfo Quende");
        statusBox.setValue("Solteiro");
        statusBox.setItems( estados);//Selecciona o conunto de opcoes que deverao ser mostrados
        //System.out.println(sexoM.getText());

    }

    public void calcularIdade() {


        Calendar calendario=Calendar.getInstance();//Cria uma nova instancia basenado na data de actual
        calendario.get(Calendar.YEAR);//Remove apenas o ano na data
        campoIdade.setText(String.valueOf(calendario.get(Calendar.YEAR)-dataSelect.getValue().getYear()/*A partir do DataPick retira o valor
    e com esse valor retira o ano*/));
        System.out.println(statusBox.getValue());

    }





    public void mudarDepart(){





    }

}
