package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import src.Main;

public class criarCartas {
    
    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Main.telaGerador();
    }

}
