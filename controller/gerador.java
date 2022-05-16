package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import game.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import src.Main;

public class gerador implements Initializable {

    @FXML
    private ImageView ImgPrimeiro;

    @FXML
    private Label NomeJogador;

    @FXML
    private ImageView imgSegundo;

    @FXML
    private ImageView imgTerceiro;

    @FXML
    private Label pontosJogador;

    @FXML
    private Label nomeJogadorMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());
        nomeJogadorMsg.setText(Main.getRetorno());

        User usuario = new User();
        usuario.setNickname(Main.getRetorno());
        try {
            usuario = usuario.buscar(usuario);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (usuario.getNickname().equals(Main.getRanking1().getNickname())) {
            ImgPrimeiro.setVisible(true);
        } else if (usuario.getNickname().equals(Main.getRanking2().getNickname())) {
            imgSegundo.setVisible(true);
        } else if (usuario.getNickname().equals(Main.getRanking3().getNickname())) {
            imgTerceiro.setVisible(true);
        }

        pontosJogador.setText(usuario.getScore().toString() + " Pt");

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        Main.telaMainMenu();
    }

    @FXML
    void criar(ActionEvent event) throws IOException {
        Main.telaCriarCarta();
    }

}