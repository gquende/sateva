package marcelstore.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class MainController {

    @FXML
    private MenuItem menuItemCadastrosClientes;

    @FXML
    private MenuItem menuItemProcessosVendas;

    @FXML
    private MenuItem menuItemGraficosVendasPorMes;

    @FXML
    private MenuItem menuItemQuantidadeEstoque;

    @FXML
    private AnchorPane anchorPane;



@FXML
    public void handlerMenuItemCadastroCliente() throws IOException {

AnchorPane a= FXMLLoader.load(getClass().getResource("/marcelstore/views/CadastroClientes.fxml"));
anchorPane.getChildren().setAll(a);

}



}
