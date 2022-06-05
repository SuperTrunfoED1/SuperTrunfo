package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import view.src.Main;

public class partida implements Initializable {

    @FXML
    private ImageView imgCard1;

    @FXML
    private ImageView imgCard2;

    @FXML
    private ImageView imgCard3;

    @FXML
    private ImageView imgCard4;

    @FXML
    private Label pontos_ia;

    @FXML
    private Label pontos_jogador;

    @FXML
    private Label NomeJogador;

    @FXML
    private Label rodada;

    @FXML
    private Label turno;

    @FXML
    void sair(ActionEvent event) throws IOException {
        Main.telaMainMenu();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());
        pontos_ia.setText("0");
        pontos_jogador.setText("0");

    }
}
