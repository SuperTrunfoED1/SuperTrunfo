package controller;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.User;
import util.Lista;
import view.src.Main;

public class mainMenu implements Initializable {

    @FXML
    private Label NomeJogador;

    @FXML
    private Label NomePrimeiro;

    @FXML
    private Label NomeSegundo;

    @FXML
    private Label NomeTerceiro;

    @FXML
    private Label primeiro;

    @FXML
    private Label segundo;

    @FXML
    private Label terceiro;

    @FXML
    public void receberLogin(String nomeUser) {
        NomeJogador.setText(nomeUser);
    }

    @Override //
    public void initialize(URL location, ResourceBundle resources) {

        NomeJogador.setText(Main.getRetorno());

        User usuario = new User();
        Lista<User> ListaUsuarios = new Lista<User>();

        try {
            ListaUsuarios = usuario.buscarTodos();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int sizeCorreto = ListaUsuarios.size;
        LinkedList<User> listaParaHanking = new LinkedList<>();
        for (int i = 0; i < sizeCorreto; i++) {
            listaParaHanking.add(ListaUsuarios.shift());
        }

        // 1º colocado
        User hanking = new User();
        for (User user : listaParaHanking) {
            if (hanking.getScore() <= user.getScore()) {
                hanking = user;
            }

        }

        Main.setRanking1(hanking);
        listaParaHanking.remove(hanking);

        NomePrimeiro.setText(hanking.getNickname());
        primeiro.setText(hanking.getScore().toString() + " Pt");

        // 2º colocado
        hanking.setScore(0);
        for (User user : listaParaHanking) {
            if (hanking.getScore() <= user.getScore()) {
                hanking = user;
            }

        }
        Main.setRanking2(hanking);
        listaParaHanking.remove(hanking);

        NomeSegundo.setText(hanking.getNickname());
        segundo.setText(hanking.getScore().toString() + " Pt");

        // 3º colocado
        hanking.setScore(0);
        for (User user : listaParaHanking) {
            if (hanking.getScore() <= user.getScore()) {
                hanking = user;
            }

        }

        Main.setRanking3(hanking);
        listaParaHanking.remove(hanking);

        NomeTerceiro.setText(hanking.getNickname());
        terceiro.setText(hanking.getScore().toString() + " Pt");

    }

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
