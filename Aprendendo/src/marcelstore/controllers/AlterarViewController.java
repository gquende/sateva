package marcelstore.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import marcelstore.model.Cliente;

public class AlterarViewController
{

    @FXML
    private TextField labelName;

    @FXML
    private TextField labelCpf;

    @FXML
    private TextField labelTelefone;

private boolean confirmar=false;
private Cliente cliente;
private Stage stage;

    public boolean isConfirmar() {
        return confirmar;
    }

    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        labelName.setText(cliente.getNome());
        labelCpf.setText(cliente.getCpf());
        labelTelefone.setText(cliente.getTelefone());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }



    public void handlerConfirmar(){

        cliente.setNome(labelName.getText());//Pega os campos da View
        cliente.setCpf(labelCpf.getText());
        cliente.setTelefone(labelTelefone.getText());
        confirmar=true;
        stage.close();//para fechar a caixa de Dialgo

    }

    public void handlerCancelar(){

        stage.close();
    }
}




