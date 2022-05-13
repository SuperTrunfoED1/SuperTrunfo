package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import src.Main;

public class gerador {
    @FXML
    void voltar(ActionEvent event) throws IOException {
        Main.telaMainMenu();
    }

    @FXML
    void criar(ActionEvent event) throws IOException {
        Main.telaCriarCarta();
    }
}
