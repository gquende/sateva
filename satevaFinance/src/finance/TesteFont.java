package finance;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class TesteFont {




    public void showFont() throws IOException {

        InputStream fontStream = TesteFont.class.getResourceAsStream("/finance/views/Regitta.ttf");
        if (fontStream != null) {
            Font bgFont = Font.loadFont(fontStream, 36);
            fontStream.close();

        Pane painel= new Pane();

        Label texto= new Label();
        texto.setFont(bgFont);
       // texto.setStyle("-fx-font-family: Regitta");
        texto.setText("Ola Todos");
        painel.getChildren().add(texto);
        Scene cenario= new Scene(painel,400,200);
        Stage janela= new Stage();
        janela.setScene(cenario);
        janela.setTitle("Ola");
        janela.show();
    }


}}
