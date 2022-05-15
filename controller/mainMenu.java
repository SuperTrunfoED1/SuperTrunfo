package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import src.Main;

public class mainMenu {
    @FXML
    void exit(ActionEvent event) throws IOException {
        Main.telaLogin();
    }

    @FXML
    void ComecarPartida(ActionEvent event) throws IOException {
        Main.telaPartida();
    }

    @FXML
    void gerarCartas(ActionEvent event) throws IOException {
        Main.telaGerador();
    }

}
